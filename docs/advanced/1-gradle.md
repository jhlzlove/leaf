# Gradle

:::tip 说明
使用 JetBrains IDEA 旧版本（2023.2 以下）的用户来说，是否在本地安装 Gradle 并无太大区别。IDEA 的早期版本对本地的 gradle
支持并不友好。几乎次次都要下载，无论是新建项目还是 clone 的已有项目。

对于早期版本的用户，推荐设置 `GRADLE_USER_HOME` 环境变量来配置一个存储空间较大的路径，后面使用 IDEA 的时候所有版本的
gradle
的安装包、依赖都会下载到此目录。

强烈推荐使用最新版的 IDEA（2023.3 ~ latest），社区版也是可以的！！！对于 Gradle 的开发体验较好，本地安装的 Gradle
版本的作用终于显现出来啦！😉
:::

## 一、配置

### Gradle 依赖下载配置

这里采用腾讯的镜像，以下脚本仅限 Gradle Version > 6.8 时可用。

- 如果是使用本地安装的 Gradle，在安装路径创建 `init.gradle.kts` 文件，添加以下内容：

    ```kotlin init.gradle.kts
    fun RepositoryHandler.enableMirror() {
        all {
            if (this is MavenArtifactRepository) {
                val originalUrl = this.url.toString().removeSuffix("/")
                urlMappings[originalUrl]?.let {
                    logger.lifecycle("Repository[$url] is mirrored to $it")
                    this.setUrl(it)
                }
            }
        }
    }
    
    val urlMappings = mapOf(
        "https://repo.maven.apache.org/maven2" to "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/",
        "https://repo1.maven.apache.org/maven2" to "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/",
        "https://dl.google.com/dl/android/maven2" to "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/",
        "https://plugins.gradle.org/m2" to "https://mirrors.cloud.tencent.com/nexus/repository/gradle-plugins/"
    )
    
    gradle.allprojects {
        buildscript {
            repositories.enableMirror()
        }
        repositories.enableMirror()
    }
    
    gradle.beforeSettings {
        pluginManagement.repositories.enableMirror()
        dependencyResolutionManagement.repositories.enableMirror()
    }
    ```

- 如果是 **只创建** 了 `GRADLE_USER_HOME` 环境变量的，在该环境变量配置的路径下创建 `init.gradle.kts` 文件，添加的内容和上面的内容一致。

:::tip 脚本说明

- 以上脚本内容来源于 [B 站霍老师](https://www.bilibili.com/video/BV12k4y1T73E/?spm_id_from=333.999.0.0) 的视频中提供的
  gist 地址，国内没有魔法无法正常访问，且该脚本只有 Gradle 6.8 以上版本可直接使用。

- `~/.gradle` 是 Gradle 默认下载的位置（Windows 中位于 C 盘用户目录中）。`GRADLE_HOME`、`GRADLE_USER_HOME`
  是不同的环境变量。`GRADLE_HOME` 为本地安装 Gradle 的路径。

- gradle 寻找自定义下载源地址的文件路径如下，已排过顺序：

  ```bash
  # 排列顺序即加载顺序 * 代表可以为任意名称
  ~/.gradle/init.gradle
  ~/.gradle/init.d/*.gradle
  GRADLE_HOME/init.d/*.gradle
  GRADLE_USER_HOME/init.gradle
  GRADLE_USER_HOME/init.d/*.gradle
  
  # Gradle 查找依赖的顺序
  # M2_HOME 是 Maven 的安装路径环境变量
  ~/.m2/settings.xml
  M2_HOME/conf/settings.xml
  ~/.m2/repository
  ```

:::

### gradle.properties

该文件可以声明环境变量，进而覆盖 gradle 的默认配置。

### 开启使用 http 协议下载依赖

gradle 默认是不允许使用 http 协议下载依赖的，如果需要，按照下面的方式修改父目录中的 `build.gradle.kts`：

```kotlin {3-4} build.gradle.kts
repositories {
    maven {
        url = uri("http 地址")
        isAllowInsecureProtocol = true
    }
}
```

## 二、说明

很多人说 Gradle 需要学习新语言，其实完全不需要，Maven 迁移过来基本只使用基础功能就行，至于自定义 task 等可以查阅资料或者
AI，很多都有解决方案，现在来说已经是很简单的了，况且很多时候也用不到那么多高级功能。

### Gradle scope 说明

在Gradle中，有几种不同的依赖范围，它们定义了依赖在不同阶段的行为和可见性。以下是一些常见的依赖范围：

1. **api**：

    - 在新的Android插件和一些非Android项目中，推荐使用`api`替代`compile`。
    - `api`范围的依赖在编译和运行时都是可用的，并且会被传递到依赖此模块的其他模块。
    - 这意味着，当你在某个模块中使用`api`来声明一个依赖时，这个依赖会同时被编译和打包到该模块的输出，并且任何依赖于这个模块的其他模块也将能够访问到这个依赖。

2. **implementation**：

    - `implementation`范围的依赖在编译和运行时对当前模块是可用的，但在编译依赖此模块的其他模块时不可见。
    - 这意味着，如果你在一个模块中使用`implementation`依赖了一个库，那么其他依赖这个模块的模块需要自己再次声明对这个库的依赖。

3. **runtimeOnly**（或`runtime`）：

    - `runtimeOnly`范围的依赖只在运行时是必需的，编译时不需要。
    - 这种依赖通常用于那些只需要在运行时加载的库，如JDBC驱动、日志框架的配置文件等。

4. **testImplementation**：

    - `testImplementation`范围的依赖只在编译和运行测试代码时需要，不会影响主代码的编译和运行。
    - 这种依赖通常用于测试框架和相关的库。

5. **testRuntimeOnly**：

    - `testRuntimeOnly`范围的依赖只在运行测试时需要，编译测试代码时不需要。
    - 这种依赖通常用于那些只在测试环境中使用的资源或库。

## 三、[Version Catalog](https://docs.gradle.org/current/userguide/platforms.html)

Gradle 7.x 引入了 version catalog 功能预览，gradle 8 默认启用（读取项目目录下的 `gradle/libs.versions.toml`），对于 Gradle
多模块需要依赖共享的项目非常好用。

个人不是很喜欢 extra 和 buildSrc 的方式，所以本项目未采用，当然，使用 `build.gradle.kts`
可以在文件里直接 `val xxxVersion = "version"` 更香。

在项目根目录的 `gradle/` 目录中创建 `libs.versions.toml` 文件管理所有依赖，子项目中按需引入。该文件分为以下几个部分(
里面的内容只是例子)：

```toml gradle/libs.versions.toml
[versions]
# 版本管理
springBoot = "3.3.0"
springDenpendencyManagement = "1.1.5"

[libraries]
# 依赖管理，有两种编写方式
# 第一种
spring-boot = { group = "org.springframework.boot", name = "spring-boot", version.ref = "springBoot" }
spring-boot-starter-aop = { group = "org.springframework.boot", name = "spring-boot-starter-aop", version.ref = "springBoot" }
spring-boot-starter-security = { group = "org.springframework.boot", name = "spring-boot-starter-security", version.ref = "springBoot" }
spring-boot-starter-web = { group = "org.springframework.boot", name = "spring-boot-starter-web", version.ref = "springBoot" }

# 第二种
spring-boot = { module = "org.springframework.boot:spring-boot", version.ref = "springBoot" }
spring-boot-starter-aop = { module = "org.springframework.boot:spring-boot-starter-aop", version.ref = "springBoot" }

[bundles]
# 依赖分组/打包
spring = ["spring-boot", "spring-boot-starter-aop", "spring-boot-starter-security", "spring-boot-starter-web"]

[plugins]
# 插件管理
spring-boot = { id = "org.springframework.boot", version.ref = "springBoot" }
spring-dependency-management = { id = "io.spring.dependency-management", version.ref = "springDenpendencyManagement" }
```

子项目使用时非常简单：

```kotlin build.gradle.kts
// 使用 libs.versions.toml 定义的插件
plugins {
    alias(libs.plugins.xxx)
}

// 使用 libs.versions.toml 定义的依赖
dependencies {
    // implementation(libs.spring.boot)

    // 引入依赖组，包含里面的所有依赖性
    // 即引入了 "spring-boot", "spring-boot-starter-aop", "spring-boot-starter-security", "spring-boot-starter-web"
    implementation(libs.bundles.spring) // [!code highlight]
}
```

> - `libs.versions.toml` Gradle
    默认查找并读取的文件名称，也可以使用其它名称（譬如开发和生产使用不同的依赖项），不过需要在 `settings.gradle.kts`
    中做一些配置，让 Gradle
    可以读取，配置方式自行查阅 [官方文档](https://docs.gradle.org/current/userguide/platforms.html#sub:central-declaration-of-dependencies)。
> - 版本定义上面使用了 `version.ref` 的方式，也可以使用 `version`
    直接写版本字符串，例如 `spring-boot = { group = "org.springframework.boot", name = "spring-boot", version = "3.2.5" }`。
> - 在 `libs.versions.toml` 中定义名称使用 `-` 分割(spring-boot)，但在使用时需要使用 `.` 分割(libs.spring.boot)。
