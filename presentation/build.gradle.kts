plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.example.presentation"
        minSdk = 2
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.android_compose_version
        kotlinCompilerExtensionVersion = "1.4.32"
    }
}

dependencies {
    // Depends on Data Module
    implementation(project(mapOf("path" to ":domain")))

    // Add dependencies
    Presentation.dependencies.forEach { implementation(it) }

    // Include annotation processors compilers
    // Presentation.compilers.forEach { kapt(it) }

    // Add Test dependencies
    Presentation.testDependencies.forEach { testImplementation(it) }
    Presentation.androidTestDependencies.forEach { androidTestImplementation(it) }
}