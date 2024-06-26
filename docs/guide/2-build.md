# 构建 & 部署

## 一、构建

### 1.1 开发工具清单

| 工具         | 版本           |
|------------|--------------|
| JDK        | 21+          |
| Gradle     | 8.7+         |
| SpringBoot | 3.2+         |
| PostgreSQL | 16+          |
| Redis      | 7.2.5        |
| Nodejs     | 20.10.0+ LTS |
| czg        | 1.9.0+       |
| 自己喜欢的      | IDE          |

### 1.2 项目结构

#### 根目录及其子模块

```bash
├── build.gradle.kts        # 父项目构建脚本
├── cz.config.ts            # czg 配置文件
├── docs                    # 文档相关
├── leaf-common             # 常规模块，可以直接抽出去为任意项目使用
├── leaf-system             # 系统模块
│   ├── build.gradle.kts
│   └── src
├── package.json
└── settings.gradle.kts     # 项目多模块设置
```

#### 系统模块（leaf-system）

```bash
├── main
│   ├── java
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

#### 常规模块（leaf-common）

该模块是一些通用的配置类，例如：通用注解、常量、全局异常、日志、返回值包装（客户端响应对象）、工具类等，只要是使用 Spring MVC 和
Spring AOP 的项目直接复制该模块到项目中即可使用。

## 二、部署

### 2.1 后端部署

#### Gradle

本项目使用 Gradle 作为依赖管理工具，所以第一步先安装 Gradle。不知道为什么，从 2023 年 9 月份吧，应该是。gradle
在国内的下载速度不行了，不仅仅是依赖的下载速度，还有 Gradle
安装包的下载速度。这里推荐从腾讯的镜像网下载 [Gradle-8.7-all.zip](https://mirrors.cloud.tencent.com/gradle/)

Gradle 的配置请参照：[进阶-Gradle](/advanced/1-gradle.md)

#### 下载项目

:::code-group

```bash [学习或使用]
git clone --depth 1 https://github.com/jhlzlove/leaf.git 
```

```bash [参与完善和开发]
git clone https://github.com/jhlzlove/leaf.git 
```

:::

然后使用你喜欢的 IDE 打开该项目，修改 `leaf/leaf-system/src/main/resources/application-dev.yml` 配置文件的内容，确保连接信息和自己的本机信息一致。

- application-dev.yml：开发环境配置
- application-prod.yml：生产环境配置

### 2.2 前端部署

暂时还没有哦~

### 2.3 IDEA 社区版推荐插件

如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：

- [Log Support 2](https://plugins.jetbrains.com/plugin/9417-log-support-2)
- [Translation](https://plugins.jetbrains.com/plugin/8579-translation)
- [JimmerDTO](https://plugins.jetbrains.com/plugin/22618-jimmerdto)

## 三、代码规范

:::tip
代码规范可以帮助开发人员更好地理解和阅读代码，提高代码的可读性，并降低出现错误的概率。

同时，它还有助于提高代码的可维护性，使得其他开发人员能够轻松地理解和修改代码，而不需要花费大量时间去弄清楚代码的意图和逻辑。

不同的团队会有不同的规范，适合团队的、团队成员共同遵守的就是最好的！
:::

本项目的代码规范如下：

### 注释

真正好的注释是想办法不写注释。所以方法名最好见名知意，内部逻辑保持简单，非常考验程序员的水平。 注释只应该描述有关代码和设计的技术性信息，而不是通篇大论。

> [!NOTE]
> Java 中有自己特殊的注释，可以使用 `javadoc` 命令生成为 JavaDoc API 文档，i think you need read
> it: [https://www.geeksforgeeks.org/comments-in-java/](https://www.geeksforgeeks.org/comments-in-java/)。

### 编码及缩进

一律使用 `UTF-8` 编码和 4 空格缩进。

### 业务函数参数

如果业务中函数的参数有三个以上，全部封装为类入参。

### 代码行长度限制：120

每一行的长度在 120 个字符左右，如果超过必须换行。一般来说，常见的有 80、100、120。

> [!NOTE]
> IDEA 等常用 IDE 中含有分割线提示，非常方便！

### 包装类与基本类型

实体、收参、出参使用包装类，如果要严格控制不可空，还是推荐使用基础类型，尽早的暴露错误，编写健壮的代码有利于团队的摸鱼和提升工作技能；局部变量尽量使用基础类型。

> [!NOTE]
> 如果使用过 Kotlin 的空安全后，这条规则就很尴尬。只能说 Java 还是败在了出生比较早，或者说，人不能不服老啊！唉，大江东去，浪淘尽！

### 命名

1. 包名全部小写，如果有多个单词连着写，比如：`com.example.deepspace`；
2. 类名遵循 UpperCamelCase 风格；
3. 方法名都遵循 lowerCamelCase 风格；
4. 常量名全部大写，多个单词使用下划线分割；非常量遵循 lowerCamelCase 风格命名；
5. 尽量不要使用拼音命名；

### Optional

本项目强制在返回值、级联对象调用 `obj.getObjA().getObjB()` 时使用该类。

- 在返回值中，无论返回的 `null` 是否有意义（有用），或是抛出异常，或是构造新的空值对象类都能满足；
- 在获取级联对象时，可以减少 if 的嵌套代码，使代码看起来更简短；

### 全部使用 jsr310 日期

项目强制不使用 Date，应使用 LocalDate、LocalDateTime 等 java8 之后提供的新式 API。

### CURD

| prefix     | meaning     |
|------------|-------------|
| add        | 新增          |
| update     | 更新          |
| remove     | 逻辑删除(非永久删除) |
| delete     | 物理删除(永久删除)  |
| select、get | 单记录查询       |
| list       | 多记录查询       |
| page       | 分页查询        |
