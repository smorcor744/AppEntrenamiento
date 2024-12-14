package com.example.appentrenamiento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.appentrenamiento.navigation.AppNavigation
import com.example.appentrenamiento.ui.theme.AppEntrenamientoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEntrenamientoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerpading ->
                    val viewModel = ViewModel()
                    AppNavigation(viewModel,Modifier.padding(innerpading))
                }


            }
        }
    }
}




