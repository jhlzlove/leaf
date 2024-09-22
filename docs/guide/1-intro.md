# Why？

一直想做一些东西，奈何总是三分钟热度，做做停停，中间浪费了许多时间，最后什么也没做出来。ORM 从 MyBatis Plus 改到 JPA 再改到 Jimmer，但是自身功能没有任何的完善。做出一个完整的业务比夸夸其谈要实际的多。

开始的时候，这个项目的定位是对自己工作以来的开发经验的总结，把自己的学习、思考、与其它的小收获融入到这个项目中，因为 Java 生态不缺轮子。但是随着工作的使用，忽然发现使用的框架多多少少存在一些问题，并且不太好解决：

- 框架的迭代跟不上技术的迭代，Java 新版本的那些实用的特性无法使用；
- 应用框架的封装过深，找一个东西需要花费很长时间；
- 应用框架引入的第三方包较为杂乱(用过若依原版框架的应该知道一个项目同时拥有 Spring + SpringBoot 的依赖)；
- 代码设计过度，晦涩难懂；
- 源码开源，文档却不是；等等。

这种应用框架想改是不太好修改的，尤其是业务成型之后。后面看技术大佬的博客时，读到了一句话：“虽说不要重复造轮子，但是自己造的轮子它不会脱离自己的控制”。很有感触，就萌生了把这个项目使用 Quarkus 重构一遍，成为一个应用框架。

关于为什么要选择 Quarkus，基本所有的 Javaer 都知道了 Spring Boot 相较于 Quarkus 和 Micronaut 而言有点儿笨重，而且现在是云原生的时代，Spring Boot 3 虽然有所改善，就目前而言不太好用；但这都不重要，重要的是开源社区已经存在很多使用 Spring Boot 脚手架的应用框架了。

如果想要了解 Quarkus 和 Micronaut 的对比，可以看看这篇 [文章](https://digma.ai/quarkus-vs-micronaut/)。

:::tip 个人的想法

一个简单的项目框架，使用什么工具最好交给使用者自己去选择。框架自身引入越少的 lib 不仅可以使得最终打包体积减小（虽然得益于科技的发展这已经不算什么了），而且还可以减少冲突。对于其它的好用的、流行的第三方库的使用权就交给用户选择吧，毕竟 Java 生态极其庞大，好用的类库有很多，根据自己或者团队选择合适的就可以。拿自己趁手的武器去战斗吧！

:::

## 一、Feature

作者整理的很勤快，这里什么都没有留下...

## 二、使用工具清单

| 工具         | 版本           |
|------------|--------------|
| JDK        | 21+          |
| Quarkus    | 3.x          |
| Gradle     | 8.8+         |
| PostgreSQL | 16+          |
| Redis      | 7.2.5        |
| Nodejs     | 20.16.0+ LTS |
| czg        | latest       |
| Dbeaver    | latest       |
| VSCode     | latest       |
| Maven      | latest       |

## 三、项目结构

### 根目录及其子模块

```bash｛5｝
├── build.gradle.kts        # 父项目构建脚本
├── docs                    # 文档
├── leaf-common             # 常规工具模块，不与框架耦合，可以直接抽出去为任意项目使用
├── leaf-framework          # 主框架集成
├── leaf-system             # 系统模块
└── settings.gradle.kts     # 项目多模块设置
```

### 系统模块（leaf-system）

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

### 常规模块（leaf-common）

该模块是一些通用的配置类，例如：通用注解、常量、全局异常、日志、返回值包装（客户端响应对象）、工具类等，只要是使用 Spring MVC 和
Spring AOP 的项目直接复制该模块到项目中即可使用。


## 四、Thanks

感谢各个开源社区，不分语言，不分国家，不涉政治地理文化。互联网能有今天的发展，离不开各个社区、成员所作的贡献，开源社区太强大啦~

- JetBrains IDEA Community
- [Quarkus](https://quarkus.io/)
- [Jimmer](https://github.com/babyfish-ct/jimmer)
- [Gradle](https://gradle.org/)
- [Postgresql](https://www.postgresql.org/)
- [VitePress](https://vitepress.dev/)
- [czg](https://cz-git.qbb.sh/zh/)

## 五、推荐

如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：

- [Log Support 2](https://plugins.jetbrains.com/plugin/9417-log-support-2)
- [Translation](https://plugins.jetbrains.com/plugin/8579-translation)
- [JimmerDTO](https://plugins.jetbrains.com/plugin/22618-jimmerdto)
