package com.example.force_max_brightness.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF9800),
    secondary = Color(0xFFFF5722),
    tertiary = Color(0xFFFFC107)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF9800),
    secondary = Color(0xFFFF5722),
    tertiary = Color(0xFFFFC107)
)

@Composable
fun ForceMaxBrightnessTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
