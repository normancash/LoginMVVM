package com.uam.incrementovm.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uam.incrementovm.model.UserState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.unit.dp
import com.uam.incrementovm.viewmodel.UserViewModel


@Composable
fun UserScreen(userModel : UserViewModel = viewModel()) {

    val state by userModel.users.collectAsState()
    when(val s = state) {
        is  UserState.Idle->{
            Text("Cargando...")
        }
        is UserState.Loading -> {
            CircularProgressIndicator()
        }
        is UserState.Success -> {
            Log.d("SCREEN","ENTRE")
            LazyColumn(modifier = Modifier.fillMaxSize().
                            padding(top=20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(s.users){
                    user->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ){
                        Text("${user.nombre} ${user.apellido}")
                        Text("${user.email} ")
                    }
                }
            }
        }
        is UserState.Error -> {
             Text(s.message)
        }
    }
}