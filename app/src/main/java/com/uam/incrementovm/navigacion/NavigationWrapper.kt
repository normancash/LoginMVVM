package com.uam.navegacionobject.navigacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.uam.incrementovm.screen.LoginScreen
import com.uam.incrementovm.screen.UserScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{backStackEntry ->
          LoginScreen(){navController.navigate(ListUser)}
        }
        composable<ListUser>()
        { backStackEntry ->
            UserScreen()
        }
    }
}