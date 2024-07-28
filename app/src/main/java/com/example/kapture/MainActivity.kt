package com.example.kapture

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kapture.adapter.TickerAdapter
import com.example.kapture.databinding.ActivityMainBinding
import com.example.kapture.model.Ticket
import com.example.kapture.sample_data.TicketSampleData
import com.example.kapture.view_model.TicketViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tickets = ArrayList<Ticket>()
    private val tickerAdapter by lazy {
        TickerAdapter(this, tickets)
    }
    private val ticketViewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tickets.addAll(TicketSampleData.data)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = tickerAdapter

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddOrEditActivity::class.java)
            startActivity(intent)
        }
        ticketViewModel.tickets.observe(this, Observer { tickets ->
            tickerAdapter.updateTickets(tickets)
        })
    }
}