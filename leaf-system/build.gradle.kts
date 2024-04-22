plugins {
    java
}

dependencies {
    implementation(libs.lombok)
    implementation(libs.jimmer.spring.boot)
    annotationProcessor(libs.jimmer.apt)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.aop)
    runtimeOnly(libs.postgresql)
    implementation(libs.lombok)
    implementation(libs.springdoc)
    implementation(project(":leaf-common"))
}