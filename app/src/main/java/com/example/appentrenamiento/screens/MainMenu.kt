package com.example.appentrenamiento.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appentrenamiento.utils.BottomBar
import com.example.appentrenamiento.utils.Header
import com.example.appentrenamiento.utils.MenuOption

@Composable
fun MainMenu(navController: NavHostController, modifier: Modifier) {
    Scaffold(
        topBar = {
            Header(navController,modifier)
        },
        bottomBar = {
            BottomBar(navController,modifier)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MenuOption(
                    icon = Icons.Filled.AddCircle,
                    text = "Crear Entrenamiento",
                    onClick = { navController.navigate("createWorkout") }
                )
            }
            item {
                MenuOption(
                    icon = Icons.Filled.FitnessCenter,
                    text = "Ver Entrenamientos",
                    onClick = { navController.navigate("viewWorkouts") }
                )
            }
            item {
                MenuOption(
                    icon = Icons.Filled.Assessment,
                    text = "Ver Progreso",
                    onClick = { navController.navigate("progress") }
                )
            }
            item {
                MenuOption(
                    icon = Icons.Filled.Task,
                    text = "Tareas y Recordatorios",
                    onClick = { navController.navigate("tasks") }
                )
            }
            item {
                MenuOption(
                    icon = Icons.Filled.Settings,
                    text = "Configuración",
                    onClick = { navController.navigate("settings") }
                )
            }
        }
    }
}