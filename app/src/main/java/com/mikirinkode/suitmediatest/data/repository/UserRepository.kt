package com.mikirinkode.suitmediatest.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.mikirinkode.suitmediatest.data.model.UserEntity
import com.mikirinkode.suitmediatest.data.source.network.UserPagingSource
import com.mikirinkode.suitmediatest.data.source.network.ApiService
import com.mikirinkode.suitmediatest.utils.Constants.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow


class UserRepository(private val service: ApiService){

    fun getUserList(): LiveData<PagingData<UserEntity>> {
        Log.e("Repository", "New Page")
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UserPagingSource(service) }
        ).liveData
    }
}