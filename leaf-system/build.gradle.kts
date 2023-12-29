plugins {
    `java-library`
}
dependencies {
    /* spring security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    /* spring data jpa */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    /* spring data redis */
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    /* validation */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    /* springdoc */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.2.0")
    /* postgresql */
    runtimeOnly("org.postgresql:postgresql:42.6.0")
    /* java jwt */
    implementation(project(":leaf-common"))
    /* 缩略图 */
    implementation("net.coobird:thumbnailator:0.4.19")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}