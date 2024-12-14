package com.example.appentrenamiento.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appentrenamiento.ViewModel
import com.example.appentrenamiento.ui.theme.LightBlue
import com.example.appentrenamiento.ui.theme.Naranja
import com.example.appentrenamiento.ui.theme.White

@Composable
fun RegisterScreen(navController: NavHostController,viewModel: ViewModel) {
    var name = viewModel.name.value
    var username = viewModel.username.value
    var password = viewModel.password.value
    var confirmPass = viewModel.confirmPassword.value
    var passwordVisible = viewModel.passwordVisibility.value
    var confirmPasswordVisible = viewModel.passwordConfirmVisibility.value


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Naranja
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "Registrate",
                fontSize = 40.sp ,
                style = MaterialTheme.typography.labelLarge,
                color = White
            )
            TextField(
                value = name,
                onValueChange = { viewModel.onNameChanged(it) },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = username,
                onValueChange = { viewModel.onUsernameChanged(it) },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it)},
                label = { Text("Contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        painterResource(id = android.R.drawable.ic_menu_view)
                    else painterResource(id = android.R.drawable.ic_secure)

                    IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                        Image(painter = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = confirmPass,
                onValueChange = { viewModel.onConfirmPasswordChanged(it)},
                label = { Text("Confirmar Contraseña") },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (confirmPasswordVisible)
                        painterResource(id = android.R.drawable.ic_menu_view)
                    else painterResource(id = android.R.drawable.ic_secure)

                    IconButton(onClick = { viewModel.toggleConfirmPasswordVisibility() }) {
                        Image(painter = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding( top = 10.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(LightBlue),
                    onClick = {
                        navController.navigate("login")
                    }

                ) {
                    Text("Cancelar")
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(LightBlue),
                    onClick = {
                        if (viewModel.addSession()) {
                            navController.navigate("menu")
                        } }
                ) {
                    Text("Aceptar")
                }
            }

        }
    }
}