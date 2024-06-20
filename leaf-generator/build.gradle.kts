plugins {
    kotlin("jvm") version "1.9.23"
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