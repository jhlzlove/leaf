val mavenUrl: String by project.extra
plugins {
    `java-library`
    id("org.springframework.boot") version "3.3.0" apply true
    id("io.spring.dependency-management") version "1.1.5"
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
