package com.mikirinkode.suitmediatest.data.source.network

import com.mikirinkode.suitmediatest.data.source.network.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUserList(@Query("page") page: Int): ApiResponse

}