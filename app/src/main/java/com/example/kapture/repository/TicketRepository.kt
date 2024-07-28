package com.example.kapture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kapture.model.Ticket
import com.example.kapture.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TicketRepository {
    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://new-ticket-api.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    private val _tickets = MutableLiveData<List<Ticket>>()
    val tickets: LiveData<List<Ticket>> get() = _tickets

    suspend fun fetchTickets() {
        val response = apiService.getTickets()
        _tickets.postValue(response)
    }
}
