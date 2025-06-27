package com.uam.incrementovm.network

import android.content.Context
import androidx.room.Room
import com.uam.incrementovm.db.AppDatabase
import com.uam.incrementovm.network.RetrofitInstance
import com.uam.incrementovm.repository.LoginRepository
import com.uam.incrementovm.repository.UserRepository

object ServiceLocator {
    private val userApi = RetrofitInstance.userApi
    private val loginApi = RetrofitInstance.loginApi
    @Volatile
    private var database: AppDatabase? = null
    private var repository: UserRepository? = null


    fun provideUserRepository(context: Context): UserRepository {
        val appContext = context.applicationContext
        val db = database ?: Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "user_database"
        ).build().also { database = it }
        return repository ?: UserRepository(
            userApi = userApi,
            dao = db.userDao()
        ).also { repository = it}
    }

    val loginRepository by lazy {
        LoginRepository(loginApi)
    }

}