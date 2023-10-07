plugins {
    `java-library`
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-freemarker:3.1.3")
    runtimeOnly("org.postgresql:postgresql:${pgVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    project(":leaf-system")
    implementation("org.springframework.boot:spring-boot-starter-web")

}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}