package com.uam.incrementovm.network

import com.uam.incrementovm.model.LoginRequest
import com.uam.incrementovm.model.LoginResponse
import com.uam.incrementovm.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApi {
    @POST("usuario/login")
    suspend fun login(@Body request: LoginRequest):LoginResponse

    @GET("usuario/all")
    suspend fun getUsers():List<User>
}