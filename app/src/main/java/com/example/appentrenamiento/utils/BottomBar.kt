package com.example.appentrenamiento.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.appentrenamiento.ui.theme.Naranja

@Composable
fun BottomBar(navController: NavHostController){
    Row(
        modifier = Modifier
            .background(color = Naranja)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ClickableIcon(nombre = "Back", imageVector = Icons.Filled.ArrowBack) {
            navController.popBackStack()
        }
        ClickableIcon(nombre = "Home",imageVector = Icons.Filled.Home) {
            navController.navigate("menu")
        }
        ClickableIcon(nombre = "Settings",imageVector = Icons.Filled.Settings) {
            navController.navigate("settings")
        }
    }
}