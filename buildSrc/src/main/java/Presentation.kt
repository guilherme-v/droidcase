object Presentation {
    val dependencies = listOf(
        "androidx.core:core-ktx:${Versions.android_core_ktx_version}",
        "androidx.appcompat:appcompat:${Versions.android_appcompat_version}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.android_lifecycle_version}",
        "com.google.android.material:material:${Versions.android_material_version}",
        "androidx.constraintlayout:constraintlayout:${Versions.android_constraint_version}",

        // compose core
        "androidx.compose.ui:ui:${Versions.android_compose_version}",

        // Tooling support (Previews, etc.) https://developer.android.com/studio/preview/features?hl=cs&skip_cache=false%22#layout-inspector-add-dependency
        "androidx.compose.ui:ui-tooling:${Versions.android_compose_version}",
        "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin_reflect_version}",
        
        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        "androidx.compose.foundation:foundation:${Versions.android_compose_version}",
        
        // Material Design
        "androidx.compose.material:material:${Versions.android_compose_version}",
        
        // Material design icons
        "androidx.compose.material:material-icons-core:${Versions.android_compose_version}",
        "androidx.compose.material:material-icons-extended:${Versions.android_compose_version}",
        
        // Integration with activities
        "androidx.activity:activity-compose:${Versions.android_activity_compose_version}",
        
        // Integration with ViewModels
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.android_compose_vm_version}",
        
        // Integration with observables
        "androidx.compose.runtime:runtime-livedata:${Versions.android_compose_ld_version}",
        "androidx.compose.runtime:runtime-rxjava2:${Versions.android_compose_ld_version}",
        
        // Hilt
        "com.google.dagger:hilt-android:${Versions.hilt_version}",
        
        // Nav
        "androidx.navigation:navigation-fragment-ktx:${Versions.android_nav_version}",
        "androidx.navigation:navigation-ui-ktx:${Versions.android_nav_version}",
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.android_nav_version}",
        "androidx.navigation:navigation-compose:${Versions.android_nav_compose_version}",

        // Room
        "androidx.room:room-runtime:${Versions.room_version}",
        "androidx.room:room-ktx:${Versions.room_version}",

        // Image loading
        "com.google.accompanist:accompanist-coil:${Versions.coil_version}",
    )

    val compilers = listOf(
        "com.google.dagger:hilt-compiler:${Versions.hilt_version}",
         "androidx.room:room-compiler:${Versions.room_version}",
    )

    val testDependencies = listOf(
        "junit:junit:${Versions.junit_version}",
        "org.mockito.kotlin:mockito-kotlin:${Versions.mockito_version}",
        "com.google.truth:truth:${Versions.truth_version}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test_version}"
    )

    val androidTestDependencies = listOf(
        // Core library
        "androidx.test:core:${Versions.android_test_core_version}",
        "androidx.compose.ui:ui-test-junit4:${Versions.android_compose_version}",

        // AndroidJUnitRunner and JUnit Rules
        "androidx.test:runner:${Versions.android_runner_version}",
        "androidx.test:rules:${Versions.android_runner_version}",

        // Assertions
        "androidx.test.ext:junit:${Versions.android_junit_version}",
        "androidx.test.ext:truth:${Versions.android_truth_version}",
        "com.google.truth:truth:${Versions.android_truth_google_version}",

        // Espresso dependencies
        "androidx.test.espresso:espresso-core:${Versions.espresso_version}",

        // Nav
        "androidx.navigation:navigation-testing:${Versions.android_nav_version}",
    )
}