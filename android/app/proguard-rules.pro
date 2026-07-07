# Retrofit
-keep interface retrofit2.** { *; }
-keep class retrofit2.** { *; }

# Gson
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Compose
-keep class androidx.compose.** { *; }
-keepclasseswithmembers class * {
    @androidx.compose.** <methods>;
}

# DataStore
-keep class androidx.datastore.** { *; }

# Kotlin
-keep class kotlin.** { *; }
-keepclassmembers class * {
    <init>(...);
}

# Keep MainActivity and services
-keep class com.example.force_max_brightness.MainActivity { *; }
-keep class com.example.force_max_brightness.MediaMonitorService { *; }
-keep class com.example.force_max_brightness.BootReceiver { *; }
