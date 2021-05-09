object Remote {

    val dependencies = listOf(
        "com.google.code.gson:gson:${Versions.gson_version}",
        "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}",
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}",
        "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    )

    val testDependencies = listOf(
        "junit:junit:${Versions.junit_version}",
        "org.mockito.kotlin:mockito-kotlin:${Versions.mockito_version}",
        "com.google.truth:truth:${Versions.truth_version}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test_version}"
    )
}