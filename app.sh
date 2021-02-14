# Desktop
chmod +x gradlew
export PATH=/opt/homebrew/bin:$PATH
./gradlew assembleDebug && ./gradlew installDevelopmentDebug
adb shell am start -n com.example.animatedsplash/.SplashActivity