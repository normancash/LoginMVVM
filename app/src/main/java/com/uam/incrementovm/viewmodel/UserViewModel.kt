package com.uam.incrementovm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.incrementovm.model.UserState
import com.uam.incrementovm.network.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(): ViewModel() {
    private val _users = MutableStateFlow<UserState>(UserState.Idle())
    val users: StateFlow<UserState> = _users

    private val userRepository = ServiceLocator.userRespository


    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.value = UserState.Loading
            val result = userRepository.getUsers()
            result.fold(
                onSuccess = {
                    _users.value = UserState.Success(it)
                    Log.d("STATE",_users.value.toString())
                },
                onFailure = {
                    _users.value = UserState.Error(it.message?:"No hay registros")
                }
            )
            Log.d("STATE AFTER",_users.value.toString())
        }
    }
}