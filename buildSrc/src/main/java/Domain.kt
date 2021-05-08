object Domain {

    val testDependencies = listOf(
        "junit:junit:${Versions.junit_version}",
        "org.mockito.kotlin:mockito-kotlin:${Versions.mockito_version}",
        "com.google.truth:truth:${Versions.truth_version}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test_version}"
    )
}