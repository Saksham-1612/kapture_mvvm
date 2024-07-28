package com.example.kapture.service

import com.example.kapture.model.Ticket
import retrofit2.http.GET

interface ApiService {
    @GET("tickets")
    suspend fun getTickets(): List<Ticket>
}

