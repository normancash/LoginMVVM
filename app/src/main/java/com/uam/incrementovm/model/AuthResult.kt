package com.uam.incrementovm.model

sealed class AuthResult {
    object Loading : AuthResult()
    data class Success(val user : User) : AuthResult()
    data class Error(val message:String): AuthResult()
}

data class User(val apellido: String,
                val email: String,
                val id: Int,
                val nombre: String)