package com.uam.incrementovm.network

import com.uam.incrementovm.model.Users
import retrofit2.http.GET

interface UserApi {
    @GET("usuario/all")
    suspend fun getUsers():Users
}