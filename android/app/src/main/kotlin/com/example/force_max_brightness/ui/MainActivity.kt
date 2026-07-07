package com.example.force_max_brightness.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.force_max_brightness.MainActivity
import com.example.force_max_brightness.ui.theme.ForceMaxBrightnessTheme

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForceMaxBrightnessTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BrightnessControlScreen()
                }
            }
        }
    }
}
