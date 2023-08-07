# note.d
Note.d is a simple note taking application built with Kotlin Multiplatform for sharing business logic and Jetpack Compose & SwiftUI.

## Prerequisites
To build this project for Android you will need:
- Android Studio 2022.x.x or higher
- Gradle 8.0 or higher
- Kotlin 1.9.0 or higher

To build this project on iOS you will need:
- Xcode 15 or higher
- Swift 5.7 or higher

## Tech Stack & Libraries
- [Kotlin Multiplatform] (https://kotlinlang.org/docs/multiplatform.html#kotlin-multiplatform-use-cases): For sharing code between Android & iOS
- [Jetpack Compose] (https://developer.android.com/jetpack/compose): Declarative UI framework for Android
- [Swift UI] (https://developer.apple.com/xcode/swiftui/): Declarative UI framework for iOS
- [Koin] (https://insert-koin.io/): For dependency injection
- [SQLDelight] (https://cashapp.github.io/sqldelight/2.0.0/multiplatform_sqlite/): For generating typesafe Kotlin APIs from SQL statements.
- [KMP-NativeCoroutines] (https://github.com/rickclephas/KMP-NativeCoroutines): For generating Obj-C functions to enable Kotlin Coroutines usage from Swift code