object Cache {

    val dependencies = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}",
        "androidx.core:core-ktx:${Versions.android_core_ktx_version}",
        "androidx.room:room-runtime:${Versions.room_version}",
        "androidx.room:room-ktx:${Versions.room_version}"
    )

    val compilers = listOf(
        "androidx.room:room-compiler:${Versions.room_version}"
    )

    val testDependencies = listOf(
        "junit:junit:${Versions.junit_version}",
        "androidx.room:room-testing:${Versions.room_version}",
        "org.mockito.kotlin:mockito-kotlin:${Versions.mockito_version}",
        "com.google.truth:truth:${Versions.truth_version}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test_version}"
    )

    val androidTestDependencies = listOf(
//        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test_version}",

        // Core library
        "androidx.test:core:${Versions.android_test_core_version}",

        // AndroidJUnitRunner and JUnit Rules
        "androidx.test:runner:${Versions.android_runner_version}",
        "androidx.test:rules:${Versions.android_runner_version}",

        // Assertions
        "androidx.test.ext:junit:${Versions.android_junit_version}",
        "androidx.test.ext:truth:${Versions.android_truth_version}",
        "com.google.truth:truth:${Versions.android_truth_google_version}",

        // Espresso dependencies
        "androidx.test.espresso:espresso-core:${Versions.espresso_version}"
    )
}