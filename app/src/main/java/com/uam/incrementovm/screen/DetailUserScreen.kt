package com.uam.incrementovm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uam.incrementovm.model.User

@Composable
fun DetailUserScreen(user:User){
    Column(modifier = Modifier.fillMaxSize()
        .padding(PaddingValues(20.dp))
    ) {
        Text(user.nombre)
        Text(user.apellido)
        Text(user.email)
    }
}