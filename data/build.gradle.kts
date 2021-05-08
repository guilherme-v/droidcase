plugins {
    id("kotlin")
}

dependencies {
    // DataModule can depends on DomainModule (an inner layer)
    implementation(project(mapOf("path" to ":domain")))

    // Include DataModuleTest dependencies
    Data.testDependencies.forEach { testImplementation(it) }
}