package com.uam.incrementovm.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey val id: Int,
                val apellido: String,
                val email: String,
                val nombre: String)