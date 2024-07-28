package com.example.kapture.view_model

import com.example.kapture.repository.TicketRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class TicketViewModel : ViewModel() {
    private val repository = TicketRepository()

    val tickets = liveData(Dispatchers.IO) {
        emitSource(repository.tickets)
        repository.fetchTickets()
    }
}
