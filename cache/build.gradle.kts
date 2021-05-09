plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(22)
        targetSdkVersion(30)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
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
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    // Depends on Data Module
    implementation(project(mapOf("path" to ":data")))

    // Add dependencies
    Cache.dependencies.forEach { implementation(it) }

    // Include annotation processors compilers
    Cache.compilers.forEach { kapt(it) }

    // Add Test dependencies
    Cache.testDependencies.forEach { testImplementation(it) }
    Cache.androidTestDependencies.forEach { androidTestImplementation(it) }
}
