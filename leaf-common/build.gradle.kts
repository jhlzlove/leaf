plugins {
    java
}

dependencies {
    api("com.auth0:java-jwt:4.4.0")
    /* spring web */
    api("org.springframework.boot:spring-boot-starter-web")

    /* 缩略图 */
    implementation("net.coobird:thumbnailator:0.4.19")

}