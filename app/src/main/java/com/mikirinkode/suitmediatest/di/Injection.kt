package com.mikirinkode.suitmediatest.di

import com.mikirinkode.suitmediatest.data.repository.UserRepository
import com.mikirinkode.suitmediatest.data.source.network.ApiConfig

object Injection {

    fun provideRepository(): UserRepository{
        val apiService = ApiConfig.getApiService()
        return UserRepository(apiService)
    }
}