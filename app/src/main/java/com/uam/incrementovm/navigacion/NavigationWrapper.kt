package com.uam.navegacionobject.navigacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.uam.incrementovm.model.User
import com.uam.incrementovm.screen.DetailUserScreen
import com.uam.incrementovm.screen.LoginScreen
import com.uam.incrementovm.screen.UserScreen
import com.uam.navegacionobject.type.generarType
import kotlin.reflect.typeOf


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{backStackEntry ->
          LoginScreen(){navController.navigate(ListUser)}
        }
        composable<ListUser>()
        { backStackEntry ->
            UserScreen {navController.navigate(DetailUser(it))}
        }
        composable<DetailUser>(typeMap = mapOf(typeOf<User>() to generarType<User>())){
            backStackEntrty ->
            val detail : DetailUser = backStackEntrty.toRoute()
            DetailUserScreen(detail.user)
        }
    }
}

