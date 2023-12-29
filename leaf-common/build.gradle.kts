plugins {
    `java-library`
}

repositories {
    mavenLocal()
}

dependencies {
    api("com.auth0:java-jwt:4.4.0")
    /* spring web */
    api("org.springframework.boot:spring-boot-starter-web")
    /* spring aop */
    api("org.springframework.boot:spring-boot-starter-aop")
}