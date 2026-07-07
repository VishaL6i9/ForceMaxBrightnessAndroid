package com.example.force_max_brightness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("BootReceiver", "Device booted, checking auto-start preference")
            
            val prefs = context.getSharedPreferences("force_brightness_prefs", Context.MODE_PRIVATE)
            val autoStart = prefs.getBoolean("auto_start_service", false)
            
            if (autoStart) {
                Log.d("BootReceiver", "Auto-start enabled, starting service")
                val serviceIntent = Intent(context, MediaMonitorService::class.java).apply {
                    action = "START_MONITORING"
                }
                
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(serviceIntent)
                } else {
                    context.startService(serviceIntent)
                }
            }
        }
    }
}
