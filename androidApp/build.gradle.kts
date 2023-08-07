plugins {
    id("com.android.application")
    kotlin("android")

}

android {
    namespace = "com.code.shinobi.notedkmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.code.shinobi.notedkmm.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    with(libs.compose) {
        implementation(icons.extended)
    }

    implementation(libs.koin.androidx.compose)
    implementation(libs.activity.compose)
    implementation(libs.koin.android)
    implementation(libs.navigation.compose)
}