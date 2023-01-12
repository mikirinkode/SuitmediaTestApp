package com.mikirinkode.suitmediatest.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mikirinkode.suitmediatest.data.model.UserEntity
import com.mikirinkode.suitmediatest.data.repository.UserRepository
import com.mikirinkode.suitmediatest.di.Injection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val userList: LiveData<PagingData<UserEntity>> =
        repository.getUserList()
            .cachedIn(viewModelScope)

}

