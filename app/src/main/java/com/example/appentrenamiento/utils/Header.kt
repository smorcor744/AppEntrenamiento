package com.example.appentrenamiento.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appentrenamiento.R
import com.example.appentrenamiento.ui.theme.Naranja

@Composable
fun Header(navController: NavHostController,modifier: Modifier) {
    // Barra superior con logo, menú y opciones de navegación
    Row(
        modifier = modifier
            .background(color = Naranja)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo de la aplicación
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Logo",
            modifier = Modifier
                .height(80.dp)
                .wrapContentHeight()
        )

        // Barra de íconos a la derecha con varias opciones
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            // Íconos para diferentes secciones

            ClickableIcon(nombre = "Favoritos",imageVector = Icons.Filled.Star) {
                navController.navigate("login")
            }

            ClickableIcon(nombre = "Calendario",imageVector = Icons.Filled.DateRange) {
                navController.navigate("login")
            }

            ClickableIcon(nombre = "Añadir Entrenamientos",imageVector = Icons.Filled.AddCircle) {
                navController.navigate("login")
            }

            ClickableIcon(nombre = "Sessions",imageVector = Icons.Filled.AccountBox) {
                navController.navigate("login")
            }

            ClickableIcon(nombre = "Menu",imageVector = Icons.Filled.Menu) {
                navController.navigate("login")
            }

        }
    }

}