# 构建 & 部署

## 一、构建

### 1. 开发工具

本项目使用工具的版本如下

- JDK 21
- Gradle 8.5
- SpringBoot 3.2
- PostgreSQL 16
- Redis 7.0.14
- Nodejs 20.10.0 LTS
- Czg 1.7.1
- 自己喜欢的 IDE

:::tip
一般来说，像 IDE 这种工具的版本对写代码影响不大，VIM 都可以写代码，就别纠结这些了，选自己喜欢的。
:::

### 2. 项目结构

#### 2.1 根目录及其子模块

```bash
├── build.gradle.kts        # 父项目构建脚本
├── cz.config.js            # czg 配置文件
├── docs                    # 文档相关
├── leaf-common             # 常规模块，可以直接抽出去为任意项目使用
├── leaf-system             # 系统模块
│   ├── build.gradle.kts
│   └── src
├── package.json            # node 脚本文件
└── settings.gradle.kts     # 项目多模块设置
```

:::warning build.gradle.kts
目前（2023.8.20） `kts` 还不支持类似 `ext` 的方式，可以使用 extra 和 buildSrc 的方式。gradle 7 开启了 version catalog
预览，gradle 8 正式启用，使用过程中还不是很好用，此项目还未使用以上方式管理。
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

#### Gradle

本项目使用 Gradle 作为依赖管理工具，所以第一步先安装 Gradle。不知道为什么，从 2023 年 9 月份吧，应该是。gradle
在国内的下载速度又不行了，推荐从镜像网下载 [Gradle-8.5-all.zip](https://mirrors.cloud.tencent.com/gradle/)

:::warning
使用 JetBrains IDEA 旧版本（2023.2 以下）的用户是否在本地安装配置 Gradle 并无太大区别，早期版本对本地的 gradle
支持并不好。对于早期版本的用户，推荐设置 `GRADLE_USER_HOME` 环境变量设置一个空间较大的路径，后面使用 IDEA 的时候所有 gradle
的安装包、依赖都会下载到此目录。

强烈推荐使用最新版的 IDEA，社区版也是可以的！！！
:::

接下来配置一下依赖下载的源地址，这里采用腾讯的镜像。

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

- 如果是 **只创建** 了 `GRADLE_USER_HOME` 环境变量的，在配置的路径下创建 `init.gradle.kts` 文件，添加的内容和上面的内容一致。

:::tip
`~/.gradle` 是 IDEA 默认下载的位置。`GRADLE_HOME`、`GRADLE_USER_HOME` 是不同的环境变量。一般 `GRADLE_HOME` 为本地安装
Gradle 的路径配置。

gradle 寻找自定义下载源地址的文件路径如下，以排过顺序：

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

#### 下载项目

如果你只是想学习或者使用该项目：

```bash
git clone --depth 1 https://github.com/jhlzlove/leaf.git 
```

如果你想参与该项目的开发完善：

```bash
git clone https://github.com/jhlzlove/leaf.git 
```

修改 `leaf/leaf-system/src/main/resources/application-dev.yml` 配置文件的内容，确保连接信息和自己的本机信息一致。

- application-dev.yml：开发环境配置
- application-prod.yml：生产环境配置

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
