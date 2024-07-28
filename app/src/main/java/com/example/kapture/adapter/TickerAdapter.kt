package com.example.kapture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kapture.databinding.RvTicketBinding
import com.example.kapture.model.Ticket

class TickerAdapter(var context: Context, var ticketList: List<Ticket>) :
    RecyclerView.Adapter<TickerAdapter.ViewHolder>() {

    class ViewHolder(var binding: RvTicketBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =RvTicketBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ticketList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTicketText.text= ticketList[position].subject
    }

    fun updateTickets(newTickets: List<Ticket>) {
        ticketList = newTickets
        notifyDataSetChanged()
    }

}