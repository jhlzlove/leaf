plugins {
    `java-library`
    id("io.quarkus")
    // quarkus 多模块 bean 发现
    // https://github.com/kordamp/jandex-gradle-plugin
    id("org.kordamp.gradle.jandex") version "2.0.0"
}

// 子项目配置
subprojects {
    group = "com.leaf"
    version = "1.0.0"

    apply {
        plugin("io.quarkus")
        plugin("java-library")
        plugin("org.kordamp.gradle.jandex")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_23
        targetCompatibility = JavaVersion.VERSION_23
    }

    val mavenUrl: String by project.extra
    val quarkusPlatformGroupId: String by project
    val quarkusPlatformArtifactId: String by project
    val quarkusPlatformVersion: String by project

    repositories {
        maven(mavenUrl)
        mavenLocal()
    }

    dependencies {
        implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    }

    sourceSets {
        main {
            resources {
                srcDirs("META-INF/services")
            }
        }
    }
}

allprojects {
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }

    tasks.withType<Test> {
        systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    }

    // 跳过测试
    tasks.named("processTestResources") {
        enabled = false
    }

    tasks.named("compileQuarkusTestGeneratedSourcesJava") {
        enabled = false
    }

    tasks.named("quarkusGenerateCodeTests") {
        enabled = false
    }
}
