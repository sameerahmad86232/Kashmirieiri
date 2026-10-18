# Kashmiri Keyboard

Native Android system-wide Kashmiri Perso-Arabic keyboard (Input Method Editor / IME).

## Features

- Kashmiri Perso-Arabic letters
- Extended letters (for Kashmiri and Urdu usage)
- Combining marks (zabar, zer, pesh, sukun, tashdid, etc.)
- Kashmiri punctuation and symbols
- Action keys: delete, space, enter

## Local build (debug APK)

From repository root:

```bash
./gradlew assembleDebug
```

APK output:

`/home/runner/work/Kashmirieiri/Kashmirieiri/app/build/outputs/apk/debug/app-debug.apk`

## GitHub Actions APK artifact

This repository includes `.github/workflows/build-apk.yml`.

On every push and pull request, it builds the debug APK and uploads it as an artifact:

1. Open the repository **Actions** tab.
2. Open the latest **Build APK** workflow run.
3. In **Artifacts**, download `kashmiri-keyboard-debug-apk`.
4. Extract the ZIP to get `app-debug.apk`.

On version tags (`v*`), the workflow also attaches the APK to the GitHub Release.

## Install APK on Android

1. Transfer `app-debug.apk` to your Android device.
2. Install it (allow installation from unknown sources if prompted).

## Enable and select the keyboard

1. Open **Settings** → **System** → **Languages & input**.
2. Open **On-screen keyboard** / **Manage keyboards**.
3. Enable **Kashmiri Perso-Arabic Keyboard**.
4. Open any text field.
5. Use the keyboard-switch/globe key and choose **Kashmiri Perso-Arabic Keyboard**.
