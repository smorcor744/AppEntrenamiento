package com.example.appentrenamiento.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.appentrenamiento.ui.theme.White

@Composable
fun ClickableIcon(nombre: String, imageVector: ImageVector,onClick: () -> Unit) {
    Icon(
        imageVector = imageVector,
        contentDescription = nombre,
        tint = White,
        modifier = Modifier
            .size(48.dp)
            .padding(5.dp)
            .clickable { onClick() } // Acción al hacer clic
    )
}