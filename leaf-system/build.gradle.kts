plugins {
    `java-library`
}

dependencies {
    /* spring security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    /* spring web */
    implementation("org.springframework.boot:spring-boot-starter-web")
    /* spring aop */
    implementation("org.springframework.boot:spring-boot-starter-aop")
    /* spring data jpa */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    /* spring data redis */
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    /* validation */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    /* springdoc */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.2.0")
    /* postgresql */
    runtimeOnly("org.postgresql:postgresql:${pgVersion}")
    /* java jwt */
    implementation("com.auth0:java-jwt:${jwtVersion}")
    /* 缩略图 */
    implementation("net.coobird:thumbnailator:0.4.19")
}