package com.example.kapture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kapture.databinding.ActivityAddOrEditBinding
import com.google.android.material.appbar.CollapsingToolbarLayout

class AddOrEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddOrEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddOrEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarLayout.findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Add or Edit Ticket"
    }
}
