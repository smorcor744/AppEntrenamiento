package com.example.appentrenamiento.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appentrenamiento.ViewModel
import com.example.appentrenamiento.ui.theme.LightBlue
import com.example.appentrenamiento.ui.theme.Naranja
import com.example.appentrenamiento.ui.theme.White

@Composable
fun LoginScreen(navController: NavHostController, viewModel: ViewModel) {
    // Variables para manejar el estado del nombre de usuario y la contraseña
    var username = viewModel.username.value
    var password = viewModel.password.value
    var passwordVisible = viewModel.passwordVisibility.value

    // Superficie que define el fondo de la pantalla
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Naranja // Color de fondo
    ) {
        // Columna que organiza los elementos verticalmente en el centro
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título de la pantalla
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "Inicia Sesión",
                fontSize = 40.sp ,
                style = MaterialTheme.typography.labelLarge,
                color = White // Color del texto
            )

            // Campo de texto para el nombre de usuario
            TextField(
                value = username,
                onValueChange = { viewModel.onUsernameChanged(it) }, // Actualiza el estado del nombre de usuario
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los campos

            // Campo de texto para la contraseña
            TextField(
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it) }, // Actualiza el estado de la contraseña
                label = { Text("Contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Oculta/expone la contraseña
                trailingIcon = {
                    // Icono para mostrar/ocultar la contraseña
                    val image = if (passwordVisible)
                        painterResource(id = android.R.drawable.ic_menu_view)
                    else painterResource(id = android.R.drawable.ic_secure)

                    IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                        Image(painter = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Enlace para "¿Has olvidado la contraseña?"
            Text(
                text = "¿Has olvidado la contraseña?", // Texto de la pregunta
                color = Color.Blue, // Color azul para el enlace
                textDecoration = TextDecoration.Underline, // Subrayado
                style = MaterialTheme.typography.labelLarge, // Estilo de texto grande
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clickable {
                        navController.navigate("menu") // Navega a la pantalla de menú
                    }
                    .padding( top = 10.dp),
                fontSize = 15.sp // Tamaño de fuente
            )

            Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre los botones

            // Fila con los botones de "Iniciar sesión" y "Registrar usuario"
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 10.dp)
            ) {
                // Botón para iniciar sesión
                Button(
                    modifier = Modifier.weight(1f), // Ocupa el mismo espacio que el otro botón
                    colors = ButtonDefaults.buttonColors(LightBlue), // Color del botón
                    onClick = {
                        // Verifica el login y navega al menú si es exitoso
                        if (viewModel.confirmLogin()) {
                            navController.navigate("menu")
                        }
                    }
                ) {
                    Text("Iniciar sesión")
                }

                Spacer(modifier = Modifier.width(20.dp)) // Espaciado entre los botones

                // Botón para registrar un nuevo usuario
                Button(
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(LightBlue),
                    onClick = { navController.navigate("register") } // Navega a la pantalla de registro
                ) {
                    Text("Registrar usuario")
                }
            }

        }
    }
}
