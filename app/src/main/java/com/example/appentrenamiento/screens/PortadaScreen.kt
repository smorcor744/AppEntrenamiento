package com.example.appentrenamiento.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appentrenamiento.R
import com.example.appentrenamiento.ui.theme.LightBlue
import com.example.appentrenamiento.ui.theme.Naranja
import com.example.appentrenamiento.ui.theme.White

@Composable
fun PortadaScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize().background(Naranja),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxSize().background(Naranja),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(300.dp)
                    .wrapContentHeight()
            )
            Text(
                text = "Entrenamientos App",
                fontSize = 25.sp ,
                style = MaterialTheme.typography.labelLarge,
                color = White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors( LightBlue)
            ) {
                Text(
                    "Entrar",
                    fontSize = 20.sp ,
                )
            }
        }
    }
}