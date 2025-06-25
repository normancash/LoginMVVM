package com.uam.incrementovm.repository

import com.uam.incrementovm.model.LoginRequest
import com.uam.incrementovm.model.LoginResponse
import com.uam.incrementovm.model.User
import com.uam.incrementovm.model.Users
import com.uam.incrementovm.network.RetrofitInstance
import com.uam.incrementovm.network.UserApi

class UserRepository(private val userApi : UserApi) {

    suspend fun getUsers(): Result<Users> {
        return try {
            val response = userApi.getUsers()
            Result.success(response)
        }
        catch(e: Exception) {
            Result.failure(e)
        }
    }
}