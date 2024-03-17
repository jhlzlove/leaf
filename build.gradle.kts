val mavenUrl: String by project.extra
plugins {
    `java-library`
    // spring boot version control
    id("org.springframework.boot") version "3.2.3"
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
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }
    tasks {
        // java 编译器编译字符集
        withType<JavaCompile> {
            options.encoding = "UTF-8"
            // 从版本 4 开始，Spring 完全支持基于 编译器标志的 -parameters Java 8 参数名称发现。通过在生成中使用此标志作为调试信息的替代方法，可以省 @Param 略命名参数的注释。
            options.compilerArgs.add("-parameters")
        }
    }

}