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
    // Scaffold es una estructura de diseño que organiza el contenido en la pantalla con un topBar y un bottomBar
    Scaffold(
        topBar = {
            // Header es la barra superior, donde se puede mostrar el título o navegación
            Header(navController, modifier)
        },
        bottomBar = {
            // BottomBar es la barra inferior que contiene los botones de navegación
            BottomBar(navController, modifier)
        }
    ) { innerPadding ->
        // LazyColumn permite una lista de elementos desplazables, optimizada para grandes cantidades de datos
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño disponible
                .padding(innerPadding), // Aplica el padding recibido desde Scaffold
            horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado entre los elementos
        ) {
            // Cada item dentro de la LazyColumn representa una opción del menú
            item {
                // Crear Entrenamiento: al hacer clic, navega a la pantalla "createWorkout"
                MenuOption(
                    icon = Icons.Filled.AddCircle, // Icono de "Añadir"
                    text = "Crear Entrenamiento", // Texto de la opción
                    onClick = { navController.navigate("createWorkout") } // Acción al hacer clic
                )
            }
            item {
                // Ver Entrenamientos: al hacer clic, navega a la pantalla "viewWorkouts"
                MenuOption(
                    icon = Icons.Filled.FitnessCenter, // Icono de "Fitness"
                    text = "Ver Entrenamientos", // Texto de la opción
                    onClick = { navController.navigate("viewWorkouts") } // Acción al hacer clic
                )
            }
            item {
                // Ver Progreso: al hacer clic, navega a la pantalla "progress"
                MenuOption(
                    icon = Icons.Filled.Assessment, // Icono de "Evaluación"
                    text = "Ver Progreso", // Texto de la opción
                    onClick = { navController.navigate("progress") } // Acción al hacer clic
                )
            }
            item {
                // Tareas y Recordatorios: al hacer clic, navega a la pantalla "tasks"
                MenuOption(
                    icon = Icons.Filled.Task, // Icono de "Tarea"
                    text = "Tareas y Recordatorios", // Texto de la opción
                    onClick = { navController.navigate("tasks") } // Acción al hacer clic
                )
            }
            item {
                // Configuración: al hacer clic, navega a la pantalla "settings"
                MenuOption(
                    icon = Icons.Filled.Settings, // Icono de "Configuración"
                    text = "Configuración", // Texto de la opción
                    onClick = { navController.navigate("settings") } // Acción al hacer clic
                )
            }
        }
    }
}
