# 构建 & 部署

## 一、构建

### 1. 开发工具

开始阅读本文档之前，请确保具有以下工具或者环境。

- JDK 17.0+
- Gradle 8.x+
- SpringBoot 3.1+
- PostgreSQL 15.0+
- Redis 5.x+

:::tip
一般来说，像 IDE 这种工具的版本对写代码影响不大，VIM 都可以写代码，就别纠结这些了，选自己喜欢的。
:::

### 2. 项目结构

#### 2.1 根目录

```bash
├── build.gradle.kts        # 父项目 gradle.kts 脚本
├── buildSrc                # kt 构建相关文件，*.gradle.kts 依赖版本控制 等
│   ├── build.gradle.kts
│   └── src
├── cz.config.js            # czg 配置文件
├── docs                    # 相关文档
├── leaf-system             # 系统模块
│   ├── build.gradle.kts
│   └── src
├── package.json            # npm 脚本文件
└── settings.gradle.kts     # 项目多模块设置
```

:::warning build.gradle.kts
`build.gradle.kts` 的依赖版本管理模块。目前（2023.8.20） `kts` 还不支持类似 `ext` 的方式，可以使用 extra 和 buildSrc
的方式，本项目使用后者。
:::

#### 2.2 系统模块（leaf-system）

```bash
├── main
│   ├── java                                # Java 文件
│   │   └── com
│   │       └── leaf
│   │           ├── LeafApplication.java
│   │           ├── common
│   │           │   ├── annotation
│   │           │   ├── business
│   │           │   ├── config              # 项目配置
│   │           │   ├── constant            # 项目常量
│   │           │   ├── exception           # 项目异常
│   │           │   ├── filter              # 过滤器
│   │           │   ├── interceptor         # 拦截器
│   │           │   ├── log                 # 日志
│   │           │   ├── response            # 响应
│   │           │   └── util                # 工具类
│   │           └── system                  # 系统管理入口
│   │               ├── controller
│   │               ├── domain
│   │               ├── repository
│   │               └── service
│   ├── Kotlin                              # Kotlin 文件
│   │   └── com
│   │       └── leaf
│   │           └── util
│   └── resources                           # 资源配置文件
│       ├── application-dev.yml
│       ├── application-prod.yml
│       ├── application.yml
│       ├── banner.txt
│       ├── log4j2.xml
│       ├── logback.xml
│       └── static
└── test
```

### 3. IDEA 社区版推荐插件

如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：

- [Log Support 2](https://plugins.jetbrains.com/plugin/9417-log-support-2)
- [Translation](https://plugins.jetbrains.com/plugin/8579-translation)

## 二、部署

### 1. 后端部署

本项目使用 Gradle 作为依赖管理工具，但不推荐本地安装 Gradle，尤其是使用 JetBrains IDEA 的用户。

那么如何处理呢？直接添加环境变量 `GRADLE_USER_HOME`，设置为你想存储 Gradle 的路径位置，重启电脑。
然后在该路径下创建 `init.gradle.kts` 文件，添加的内容和下面的一样。

设置此环境变量后，IDEA 自动下载的所有 gradle 版本和相关的依赖都会下载到此位置。

如果不设置 `GRADLE_USER_HOME` 环境变量的话，创建 `~/.gradle/init.gradle.kts` 文件并添加以下内容：

```kotlin ~/.gradle/init.gradle.kts
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
    "https://repo.maven.apache.org/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
    "https://repo1.maven.apache.org/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
    "https://dl.google.com/dl/android/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
    "https://plugins.gradle.org/m2" to "https://mirrors.tencent.com/nexus/repository/gradle-plugins/"
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

这样 Gradle 就算配置完成了。

下载项目：

```bash
git clone https://github.com/jhlzlove/leaf.git
```

修改 `leaf/leaf-system/src/main/resources/application-dev.yml` 配置文件的内容，确保连接信息和自己的本机信息一致。

### 2. 前端部署

后续补充~

## 三、代码规范

:::tip
代码规范可以帮助开发人员更好地理解和阅读代码，提高代码的可读性，并降低出现错误的概率。

同时，它还有助于提高代码的可维护性，使得其他开发人员能够轻松地理解和修改代码，而不需要花费大量时间去弄清楚代码的意图和逻辑。

不同的团队会有不同的规范，适合团队的、团队成员共同遵守的就是最好的！染于苍则苍，染于黄则黄
:::

本项目的代码规范如下：

### 注释

真正好的注释是想办法不写注释。所以方法名最好见名知意，内部逻辑保持简单，非常考验程序员的水平。

另外，注释只应该描述有关代码和设计的技术性信息，而不是通篇大论。

Java 中有自己特殊的注释，可以使用 `javadoc` 命令生成为 JavaDoc API 文档，i think you need read
it: https://www.geeksforgeeks.org/comments-in-java/

### 编码及缩进

一律使用 `UTF-8` 编码和 4 空格缩进。

### 业务函数参数

如果业务中函数的参数有三个以上，全部封装为类入参。

### 代码行长度限制：120

每一行的长度在 120 个字符左右，如果超过必须换行。一般来说，常见的有 80、100、120。

> IDEA 等常用 IDE 含有分割线提示，非常方便！

### 包装类与基本类型

实体、收参、出参使用包装类；局部变量尽量使用基础类型。

### 命名

1. 包名全部小写，如果有多个单词连着写，比如：`com.example.deepspace`；
2. 类名遵循 UpperCamelCase 风格；
3. 方法名都遵循 lowerCamelCase 风格；
4. 常量名全部大写，多个单词使用下划线分割；非常量遵循 lowerCamelCase 风格命名；
5. 尽量不要使用拼音命名；

### 工具类

减少依赖，降低工具类泛滥。非业务框架不应该封装过多工具，够用就好，具体使用什么应该交由用户决定。 本项目只是简单的基于 JDK 或者
Spring 中使用的 API 封装了几个工具类，后续使用可以自行选择自己喜欢的第三方库，封装的清单如下：

- 基于 ObjectMapper 封装了 JSON 工具；
- 基于 JDK 的 HttpClient、HttpRequest、HttpResponse 封装的网络工具；
- 基于 JDK jsr310 日期封装的 LocalDateUtil 工具；
- SpringUtil、SecurityUtil、ServletUtil；
- 下拉树菜单工具；

### Optional

本项目强制在返回值、级联对象调用（obj.getObjA().getObjB()）时使用该类。

- 在返回值中，无论返回的 `null` 是否有意义（有用），或是抛出异常，或是构造新的空值对象类都能满足；
- 在获取级联对象时，可以减少 if 的嵌套代码，使代码看起来更简短；

### 全部使用 jsr310 日期

项目强制不允许使用 Date，使用LocalDate、LocalDateTime 等 java8 提供的新式 API。
