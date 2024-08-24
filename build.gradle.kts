val mavenUrl: String by project.extra
plugins {
    `java-library`
    id("org.springframework.boot") version libs.versions.springBoot
    id("io.spring.dependency-management") version libs.versions.springDenpendencyManagement
}
// 定义所有工程的下载源地址
allprojects {
    repositories {
        maven(mavenUrl)
        mavenLocal()
    }
}
// 声明主类
springBoot {
    mainClass = "com.leaf.LeafApplication"
}

// 子项目配置
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

    dependencies {
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        // developmentOnly("org.springframework.boot:spring-boot-devtools")
    }

    // 声明主类
    springBoot {
        mainClass = "com.leaf.LeafApplication"
    }
}
