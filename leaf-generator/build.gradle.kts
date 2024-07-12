plugins {
    kotlin("jvm") version libs.versions.kotlin
}

group = "com.leaf"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.postgresql)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}