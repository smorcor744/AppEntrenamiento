package com.example.appentrenamiento.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appentrenamiento.ui.theme.LightBlue
import com.example.appentrenamiento.ui.theme.White

@Composable
fun MenuOption(icon: ImageVector, text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(16.dp)
            .clickable(onClick = onClick)
            .background(
                color = LightBlue,
                shape = MaterialTheme.shapes.medium
            )
            .padding(vertical = 16.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(32.dp).fillMaxWidth(0.1f),
                tint = White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = White,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }
    }
}