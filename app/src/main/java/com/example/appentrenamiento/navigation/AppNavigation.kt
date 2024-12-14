package com.example.appentrenamiento.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appentrenamiento.ViewModel
import com.example.appentrenamiento.screens.LoginScreen
import com.example.appentrenamiento.screens.MainMenu
import com.example.appentrenamiento.screens.PortadaScreen
import com.example.appentrenamiento.screens.RegisterScreen

@Composable
fun AppNavigation(viewModel: ViewModel, modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "portada") {
        composable("portada") { PortadaScreen(navController) }
        composable("login") { LoginScreen(navController,viewModel) }
        composable("register") { RegisterScreen(navController,viewModel) }
        composable("menu") { MainMenu(navController,modifier) }
    }
}
