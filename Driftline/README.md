# Driftline

A standalone demo Android app (Kotlin + Jetpack Compose). It has its own
name, branding, color scheme, and login flow. It is not a copy of, and does
not interact with, any other app or service — there is no security-ticket
field, no server, no account system. "Continue as Guest" just opens a local
sample screen.

## Build with Android Studio
1. Open this folder in Android Studio (Giraffe or newer).
2. Let Gradle sync; install Android SDK Platform 35 if prompted.
3. Run the `app` configuration on an emulator/device, or
   **Build > Build Bundle(s) / APK(s) > Build APK(s)** to get an installable APK.

## Build an APK without installing anything (GitHub Actions)
1. Push this folder to a new GitHub repository.
2. Go to the repo's **Actions** tab and run the "Build Driftline APK" workflow
   (or just push to `main` — it runs automatically).
3. When it finishes, open the run and download the `driftline-debug-apk`
   artifact — that's your installable APK.

## Build from the command line (if you already have Gradle + Android SDK)
```bash
gradle assembleDebug
```
APK lands at `app/build/outputs/apk/debug/app-debug.apk`.
