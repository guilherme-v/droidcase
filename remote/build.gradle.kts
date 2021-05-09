plugins {
    id("kotlin")
}

dependencies {
    // Remote depends on Data layer
    implementation(project(mapOf("path" to ":data")))

    // Include all Remote dependencies
    Remote.dependencies.forEach { implementation(it) }

    // Include all Remote dependencies
    Remote.testDependencies.forEach { testImplementation(it) }
}