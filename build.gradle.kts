val mavenUrl: String by project.extra
plugins {
    `java-library`
    id("org.springframework.boot") version "3.2.5"
    // Spring Boot 官方提供的 Gradle 插件之一，可以帮助开发人员更轻松地管理项目依赖项。统一管理项目依赖项的版本，使项目的依赖项版本更加清晰明确，避免出现依赖冲突。
    id("io.spring.dependency-management") version "1.1.4"
}

subprojects {
    group = "com.leaf"
    version = "1.0.0"

    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("java-library")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    repositories {
        maven(mavenUrl)
        mavenLocal()
    }

    dependencies {
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        // developmentOnly("org.springframework.boot:spring-boot-devtools")
    }


}