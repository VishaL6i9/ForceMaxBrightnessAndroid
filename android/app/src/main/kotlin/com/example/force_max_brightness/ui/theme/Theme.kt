package com.example.force_max_brightness.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Material You - Dynamic Color Palettes
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFB74D),
    onPrimary = Color(0xFF1F1F1F),
    primaryContainer = Color(0xFFE65100),
    onPrimaryContainer = Color(0xFFFFEDD5),
    secondary = Color(0xFFFFB74D),
    onSecondary = Color(0xFF1F1F1F),
    secondaryContainer = Color(0xFFE65100),
    onSecondaryContainer = Color(0xFFFFEDD5),
    tertiary = Color(0xFFFFC107),
    onTertiary = Color(0xFF1F1F1F),
    tertiaryContainer = Color(0xFFFF9800),
    onTertiaryContainer = Color(0xFFFFF3E0),
    background = Color(0xFF121212),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF1F1F1F),
    onSurface = Color(0xFFFFFFFF),
    surfaceContainer = Color(0xFF2A2A2A),
    onSurfaceVariant = Color(0xFFCCCCCC),
    error = Color(0xFFCF6679),
    onError = Color(0xFF1F1F1F),
    errorContainer = Color(0xFF9B000A),
    onErrorContainer = Color(0xFFFFDADA)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE65100),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD7A8),
    onPrimaryContainer = Color(0xFF4D2600),
    secondary = Color(0xFFE65100),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFD7A8),
    onSecondaryContainer = Color(0xFF4D2600),
    tertiary = Color(0xFFFF9800),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFE0B2),
    onTertiaryContainer = Color(0xFF662D00),
    background = Color(0xFFFFFAF5),
    onBackground = Color(0xFF1F1F1F),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1F1F1F),
    surfaceContainer = Color(0xFFF5F5F5),
    onSurfaceVariant = Color(0xFF666666),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B)
)

@Composable
fun ForceMaxBrightnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
