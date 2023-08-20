import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Java 插件
    java
    // spring boot version control
    id("org.springframework.boot") version "3.1.2"
    // 该插件用于管理 Spring Boot 项目中依赖项的版本。
    // 它是 Spring Boot 官方提供的 Gradle 插件之一，可以帮助开发人员更轻松地管理项目依赖项。
    // 该插件的作用是统一管理项目依赖项的版本，使项目的依赖项版本更加清晰明确，避免出现依赖冲突。
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
}

group = "com.leaf"
version = "0.0.1"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

// 配置所有项目（包括子项目，拥有最高优先级），所有子项目继承相同的配置。
allprojects {


    // 依赖下载源设置
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
}

// 依赖
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    /* spring security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    /* spring web */
    implementation("org.springframework.boot:spring-boot-starter-web")
    /* spring aop */
    implementation("org.springframework.boot:spring-boot-starter-aop")
    /* spring data jpa */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    /* validation */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    /* postgresql */
    implementation("org.postgresql:postgresql:${pgVersion}")
    /* java jwt */
    // https://github.com/auth0/java-jwt
    implementation("com.auth0:java-jwt:${jwtVersion}")
    /* 缩略图 */
    implementation("net.coobird:thumbnailator:0.4.19")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// kt 编译选项
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

// java 编译字符编码
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}