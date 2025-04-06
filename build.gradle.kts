plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.plugin.allopen)
    alias(libs.plugins.ksp)
    alias(libs.plugins.shadow)
    alias(libs.plugins.micronaut.application)
    alias(libs.plugins.micronaut.aot)
}

group = "com.jhlz"
version = "0.1"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    ksp(libs.bundles.micronaut.ksp)
    implementation(libs.bundles.micronaut)
    compileOnly(libs.bundles.micronaut.compile)
    runtimeOnly(libs.bundles.micronaut.runtime)
    testImplementation(libs.micronaut.http.client)

    implementation(libs.jimmer.sql.kotlin)
    ksp(libs.jimmer.ksp)
    runtimeOnly(libs.postgresql)

}

application {
    mainClass = "com.jhlz.Application"
}

java {
    sourceCompatibility = JavaVersion.toVersion("21")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.jhlz.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}