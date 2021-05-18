plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.example.presentation"
        minSdk = 22
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        useIR = true

        // Error: This version (1.0.0-alpha13) of the Compose Compiler requires Kotlin version 1.4.30 but you appear to be using Kotlin version 1.5.0 which is not known to be compatible.  Please fix your configuration (or `suppressKotlinVersionCompatibilityCheck` but don't say I didn't warn you!).
        // Fix: https://stackoverflow.com/questions/65545018/where-can-i-put-the-suppresskotlinversioncompatibilitycheck-flag
        // freeCompilerArgs = listOf(
        //    "-P",
        //    "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
        // )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.android_compose_version
    }
}

dependencies {
    // Depends on Data Module
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":remote")))
    implementation(project(mapOf("path" to ":cache")))

    // Add dependencies
    Presentation.dependencies.forEach { implementation(it) }

    // Include annotation processors compilers
    Presentation.compilers.forEach { kapt(it) }

    // Add Test dependencies
    Presentation.testDependencies.forEach { testImplementation(it) }
    Presentation.androidTestDependencies.forEach { androidTestImplementation(it) }
}