# Force Max HDR Brightness

A native Android app built with Jetpack Compose that automatically forces maximum screen brightness during media playback on unrooted devices.

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.02-brightgreen.svg)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## Overview

Force Max HDR Brightness is a lightweight Android application designed to automatically boost screen brightness during HDR/Dolby Vision video playback. Built entirely with Jetpack Compose and Material 3, it provides a modern, responsive UI for managing system brightness on unrooted Android devices.

**Key Achievement:** Reduced APK size by 76% through migration from Flutter to native Compose (69.5 MB → 16.64 MB).

## Features

### Brightness Control
- **Manual system brightness** control via slider (0-255)
- **Preset brightness buttons** (Min, Mid, Max)
- **Window-level brightness override** - instant, no permission needed
- **Brightness mode toggle** - switch between manual and automatic modes
- **Permission status display** with one-tap permission grant

### Media Monitoring
- **Real-time media playback detection** using MediaSession monitoring
- **Automatic brightness boost** when video playback starts
- **Automatic brightness restore** when playback stops/pauses
- **Foreground service** with persistent notification
- **Auto-start on boot** - optional service launch at device startup
- **System integration** - respects status bar and system insets

### User Experience
- **Modern Material 3 UI** with card-based layout
- **Responsive design** with scroll support
- **Real-time status updates** and permission feedback
- **Persistent settings** stored across app restarts
- **Dark theme support** via Material 3 color scheme

## Target Device
- **Device**: OnePlus 13 (tested)
- **Android Version**: Android 16 (Android 7.0+ supported)
- **Constraint**: Unrooted device

## Installation

### From Source

1. Clone the repository:
```bash
git clone https://github.com/YourUsername/ForceMaxBrightness.git
cd ForceMaxBrightness/force_max_brightness
```

2. Build the debug APK:
```bash
cd android
./gradlew assembleDebug
```

3. Install on device:
```bash
adb install build/app/outputs/apk/debug/app-debug.apk
```

### Build Requirements

- Android Studio Hedgehog or later
- JDK 23+
- Android SDK 35+
- Gradle 8.12+

## Setup & Permissions

### Required Permissions

1. **WRITE_SETTINGS**
   - Required for system brightness control
   - App will prompt you to grant permission in Settings
   - Navigate to: **Settings → Apps → Special Access → Modify system settings**

2. **Notification Access** (for media monitoring)
   - Required for MediaSession-based playback detection
   - Navigate to: **Settings → Apps → Special Access → Notification Access**
   - Enable "Force Max Brightness"

### Optional: Boot Auto-Start

Enable "Auto-start on boot" toggle in the app settings to automatically launch the monitoring service at device startup.

## Usage

### Manual Brightness Control

1. **Grant WRITE_SETTINGS permission** - Tap "Grant Permission" button
2. **Adjust brightness** using the slider or preset buttons:
   - **Min**: Set to 0% brightness
   - **Mid**: Set to 50% brightness  
   - **Max**: Set to 100% brightness
3. **Toggle brightness mode** - Switch between Manual (fixed) and Auto (adaptive) modes

### Window Brightness Override

Window brightness provides instant app-level brightness without needing system permissions:
- **Max**: Force app window to maximum brightness
- **Mid**: Set app window to 50% brightness
- **Reset**: Return to system brightness level

### Auto Media Monitoring

1. **Enable Notification Access** permission (see Setup section)
2. **Tap "Start Monitor"** to launch the background service
3. **Green indicator** shows service is running
4. **Automatic brightness control**:
   - Boosts to maximum when video playback detected
   - Restores original brightness when playback stops/pauses
5. **Tap "Stop Monitor"** to disable the service

### Toggle Auto-Start

Enable "Auto-start on boot" switch to automatically resume media monitoring after device restart.

## Architecture

### UI Layer
- **Jetpack Compose** with Material 3 design system
- **Responsive layout** with proper status bar handling
- **Activity-result launcher** for permission handling
- **Composable state management** with proper recomposition

### Android Layer (Kotlin)
- **MainActivity**: Sets Compose content and manages activity lifecycle
- **MediaMonitorService**: Foreground service for playback monitoring
- **BootReceiver**: Auto-start support
- **Direct system API access** - no Flutter overhead

### System Integration
- **Settings.System.SCREEN_BRIGHTNESS** - System brightness control
- **Settings.System.SCREEN_BRIGHTNESS_MODE** - Manual/Auto mode switching
- **Window.LayoutParams.screenBrightness** - Window-level override
- **MediaSessionManager** - Media playback detection
- **SharedPreferences** - Settings persistence

### Project Structure
```
android/
├── app/
│   ├── src/main/
│   │   ├── kotlin/com/example/force_max_brightness/
│   │   │   ├── MainActivity.kt          # Entry point
│   │   │   ├── MediaMonitorService.kt   # Background service
│   │   │   ├── BootReceiver.kt          # Boot handler
│   │   │   └── ui/
│   │   │       ├── Screens.kt           # UI composables
│   │   │       └── theme/
│   │   │           ├── Theme.kt         # Material 3 theme
│   │   │           └── Type.kt          # Typography
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
└── settings.gradle.kts
```

## Performance

- **APK Size**: 16.64 MB (76% reduction from Flutter)
- **Build Time**: ~6 seconds (debug build)
- **Startup Time**: <1 second
- **Memory Footprint**: Minimal (Compose-only, no Flutter runtime)
- **Battery Impact**: Low (background service uses minimal resources)

## Known Limitations

1. **MediaSession Permissions**: Requires manual Notification Access setup
2. **HDR Detection**: Currently triggers on all video playback (no HDR-specific detection)
3. **OEM Settings**: OnePlus-specific HBM settings may require manufacturer APIs
4. **Unrooted Constraint**: Cannot access `/system` settings
5. **Battery**: Continuous background monitoring uses battery

## Development Status

✅ Phase 1: Project Setup  
✅ Phase 2: Basic Brightness Control  
✅ Phase 3: Window Override & Mode Controls  
✅ Phase 4: Media Playback Detection  
✅ Phase 5: Auto-Start & Settings Persistence  
✅ Phase 6: Flutter → Compose Migration (76% APK reduction)  
✅ Phase 7: Permission Handling & UI Polish  
🔄 Phase 8: Device Testing & Optimization (Next)

See `progress.md` for detailed development tracking.

## Testing on Device

1. Install APK on Android device (API 24+)
2. Launch app and grant WRITE_SETTINGS permission
3. Enable Notification Access for auto-monitoring
4. Test with Jellyfin, ExoPlayer, or YouTube
5. Verify brightness boosts during video playback
6. Check that brightness restores after playback ends

## Troubleshooting

### Permission Not Detected After Granting
- Close and reopen the app
- App automatically rechecks permission on launch
- Status should update from "Permission required" to "Permission granted"

### Status Bar Overlapping Content
- App includes 16dp top padding to respect system status bar
- Scroll content if needed
- All UI elements should be visible and interactive

### Media Monitor Not Starting
- Ensure Notification Access is enabled
- Check device logs: `adb logcat com.example.force_max_brightness`
- Verify foreground service notification appears

### Build Failures
```bash
# Clean and rebuild
cd android
./gradlew clean
./gradlew assembleDebug
```

## Future Improvements

- HDR-specific content detection
- Package-specific app filtering (video apps only)
- Notification action controls (quick brightness adjust)
- Advanced battery optimization
- OEM-specific brightness curves
- Custom brightness profiles
- Schedule-based brightness control

## Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| UI Framework | Jetpack Compose | 2024.02 |
| Design System | Material 3 | Latest |
| Language | Kotlin | 2.1.0 |
| Build Tool | Gradle | 8.12 |
| Min API | Android 7.0 | API 24 |
| Target API | Android 16 | API 35 |

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Contact & Support

- **Issues**: Report bugs via GitHub Issues
- **Discussions**: Feature requests and ideas in GitHub Discussions

---

**Disclaimer**: This tool should only be used on devices you own or have explicit permission to modify. Unauthorized system modifications may void warranty or cause unexpected behavior.
