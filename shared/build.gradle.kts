plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight") version "2.0.0"
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-13"
}

repositories {
    google()
    mavenCentral()
}

sqldelight {
    databases {
        create("NotesDatabase") {
            packageName.set("com.code.shinobi.notedkmm")
        }
    }
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    kotlin.sourceSets.all {
        languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(libs.koin)
                implementation(libs.sqldelight.coroutines)
            }

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.sqldelight.native)
            }
        }
    }
}

android {
    namespace = "com.code.shinobi.notedkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
    }
}