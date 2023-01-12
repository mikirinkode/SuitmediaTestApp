package com.mikirinkode.suitmediatest.data.source.network

import com.mikirinkode.suitmediatest.data.source.network.response.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getAllUsers(): ApiResponse

}