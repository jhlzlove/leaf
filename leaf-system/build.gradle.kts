plugins {
    `java-library`
}

val jimmerVersion: String by project.extra
val lombokVersion: String by project.extra
dependencies {
    annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
    // annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:${jimmerVersion}")
    /* spring security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    /* validation */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    /* springdoc */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.4.0")
    /* postgresql */
    runtimeOnly("org.postgresql:postgresql:42.7.3")
    /* java jwt */
    implementation(project(":leaf-common"))
}