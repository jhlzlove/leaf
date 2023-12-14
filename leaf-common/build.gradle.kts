plugins {
    `java-library`
}

group = "code.simple"
version = "1.0.0"

repositories {
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    api("com.auth0:java-jwt:4.4.0")
    /* spring web */
    api("org.springframework.boot:spring-boot-starter-web")
    /* spring aop */
    api("org.springframework.boot:spring-boot-starter-aop")
}

tasks.test {
    useJUnitPlatform()
}