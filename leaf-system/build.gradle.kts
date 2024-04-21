plugins {
    java
}

val jimmerVersion: String by project.extra
val lombokVersion: String by project.extra

dependencies {
    /* Jimmer */
    annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
    implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:${jimmerVersion}")
    /* lombok */
    implementation("org.projectlombok:lombok:${lombokVersion}")
    /* spring security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    /* spring aop */
    api("org.springframework.boot:spring-boot-starter-aop")
    /* validation */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    /* springdoc */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.4.0")
    /* postgresql */
    runtimeOnly("org.postgresql:postgresql:42.7.3")
    /* leaf-common */
    implementation(project(":leaf-common"))
}