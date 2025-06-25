package com.uam.incrementovm.network

import com.uam.incrementovm.network.RetrofitInstance
import com.uam.incrementovm.repository.LoginRepository
import com.uam.incrementovm.repository.UserRepository

object ServiceLocator {
    private val userApi = RetrofitInstance.userApi
    private val loginApi = RetrofitInstance.loginApi

    val userRespository by lazy {
        UserRepository(userApi)
    }

    val loginRepository by lazy {
        LoginRepository(loginApi)
    }


}