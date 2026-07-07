# Force Max Brightness (HDR/HBM)

A Flutter Android app that automatically forces maximum screen brightness during media playback, specifically designed for HDR/Dolby Vision content on unrooted devices.

## Features

- **Manual Brightness Control**: Set system brightness (0-255) with permission
- **Window Brightness Override**: Instant app-level brightness (no permission needed)
- **Brightness Mode Toggle**: Switch between manual and auto brightness
- **Media Playback Monitoring**: Automatically detect media playback and boost brightness
- **Auto-Start on Boot**: Optional service auto-start when device boots
- **HDR Settings Testing**: Experimental interface to test HDR-related system settings

## Target Device
- **Device**: OnePlus 13
- **Android Version**: Android 16
- **Constraint**: Unrooted device

## Installation

1. Clone the repository
2. Open in Android Studio or VS Code
3. Run `flutter pub get`
4. Build and install: `flutter run` or `flutter build apk`

## Setup & Permissions

### Required Permissions

1. **WRITE_SETTINGS** (In-app prompt)
   - Required for system brightness control
   - App will prompt you to grant permission in Settings

2. **Notification Access** (Manual setup)
   - Required for media playback detection
   - **Settings** → **Apps** → **Special Access** → **Notification Access**
   - Enable for "Force Max Brightness"

### Optional: Boot Auto-Start

Enable "Auto-start on boot" in the app to automatically start monitoring when device boots.

## Usage

### Manual Control
1. Grant WRITE_SETTINGS permission when prompted
2. Use the brightness slider or preset buttons (Min/Mid/Max)
3. Toggle brightness mode (Manual/Auto)

### Window Brightness Override
- **Force Max**: Instantly set app brightness to maximum (no permission)
- **Medium**: Set to 50% brightness
- **Reset**: Return to system brightness

### Auto-Monitoring
1. Enable Notification Access permission (see above)
2. Tap "Start Monitor" in the app
3. Service runs in background and monitors media playback
4. Brightness automatically boosts during video playback
5. Brightness restores when playback stops/pauses

### HDR Settings (Experimental)
- Test reading/writing system settings like `minimumHdrPercentOfScreen`
- Useful for debugging on-device HDR behavior

## Architecture

### Android Native (Kotlin)
- **MainActivity**: MethodChannel bridge for Flutter-Android communication
- **MediaMonitorService**: Foreground service monitoring MediaSession
- **BootReceiver**: Handles boot events for auto-start

### Flutter (Dart)
- **main.dart**: UI with brightness controls, service management, settings

### Key APIs Used
- `Settings.System.SCREEN_BRIGHTNESS` - System brightness (0-255)
- `Settings.System.SCREEN_BRIGHTNESS_MODE` - Manual/Auto mode
- `Window.LayoutParams.screenBrightness` - Window-level override
- `MediaSessionManager` - Playback state detection
- `SharedPreferences` - Settings persistence

## Known Limitations

1. **MediaSession Access**: Requires Notification Access permission (manual setup)
2. **HDR Detection**: Currently triggers on all video playback (no HDR-specific detection yet)
3. **OEM Settings**: OnePlus-specific HBM settings may not be accessible without root
4. **Battery**: Continuous monitoring may impact battery life

## Development Status

✅ Phase 1: Project Setup  
✅ Phase 2: Basic Brightness Control  
✅ Phase 3: Window Override & Mode Controls  
✅ Phase 4: Media Playback Detection  
✅ Phase 5: Auto-Start & Settings Persistence  
🔄 Phase 6: Device Testing & Refinement (Next)

See `progress.md` for detailed development tracking.

## Testing on Device

1. Install APK on OnePlus 13
2. Grant WRITE_SETTINGS permission
3. Enable Notification Access
4. Test with Jellyfin or other video apps
5. Verify brightness boost during playback

## Future Improvements

- HDR content detection (vs all video)
- Package-specific filtering (only target video apps)
- Notification action controls
- Battery optimization
- OEM-specific brightness modes (OnePlus HBM)

## Technical Notes

- **System Brightness**: Requires WRITE_SETTINGS permission
- **Window Brightness**: Works immediately without permission
- **MediaSession**: Most reliable for playback detection on modern Android
- **Accessibility Service**: Alternative approach if MediaSession insufficient

## License

MIT License (or your preferred license)
