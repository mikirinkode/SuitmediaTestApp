package com.mikirinkode.suitmediatest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mikirinkode.suitmediatest.data.model.UserEntity
import com.mikirinkode.suitmediatest.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(repository: UserRepository) : ViewModel() {
    val userList: LiveData<PagingData<UserEntity>> =
        repository.getUserList()
            .cachedIn(viewModelScope)

}

