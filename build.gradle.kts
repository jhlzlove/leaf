import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    // spring boot version control
    id("org.springframework.boot") version "3.1.2"
    // Spring Boot 官方提供的 Gradle 插件之一，可以帮助开发人员更轻松地管理项目依赖项。统一管理项目依赖项的版本，使项目的依赖项版本更加清晰明确，避免出现依赖冲突。
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.leaf"
version = "0.0.1"

allprojects {
    // 所有项目使用的插件
    apply {
        plugin("kotlin")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    // 依赖下载源
    repositories {
        // 本地 maven 仓库
        mavenLocal()
        // 腾讯云仓库
        maven("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        // 如果项目中需要从 http 下载依赖，打开下面的设置
        // maven {
        //     url = uri("http://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        //     isAllowInsecureProtocol = true
        // }
    }

    // 所有项目的公共依赖
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks {
        // kt 编译选项
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xplugin=org.jetbrains.kotlin.allopen:" +
                        "annotation=org.springframework.stereotype.Service")
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "17"
            }
        }
        // java 编译器编译字符集
        withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.compilerArgs.add("-parameters")
        }

        withType<Jar> {
            enabled = true
        }
    }
}

