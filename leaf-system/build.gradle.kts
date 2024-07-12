plugins {
    java
}

dependencies {
    implementation(libs.jimmer.spring.boot)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
    annotationProcessor(libs.jimmer.apt)
    implementation(libs.bundles.spring)
    runtimeOnly(libs.postgresql)
    implementation(project(":leaf-common"))
}