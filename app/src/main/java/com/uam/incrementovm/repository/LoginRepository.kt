package com.uam.incrementovm.repository

import com.uam.incrementovm.model.LoginRequest
import com.uam.incrementovm.model.LoginResponse
import com.uam.incrementovm.network.LoginApi

class LoginRepository(
    private val loginApi: LoginApi
) {
    suspend fun login(username : String,password : String) : Result<LoginResponse>{
        return try {
            val response = loginApi.login(LoginRequest(username,password))
            Result.success(response)
        }
        catch (e:Exception) {
            Result.failure(e)
        }
    }

}