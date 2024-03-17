# Jimmer

## 一、为什么切换到 Jimmer？

higher faster stronger

## 二、基本使用

官网写的很详细了，很多的重复都是徒劳的。

```kotlin build.gradle.kts
val jimmerVersion = "0.8.109"
// Jimmer Spring Boot Starter
annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:${jimmerVersion}")

// Without Jimmer Spring Boot Starter
annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
implementation("org.babyfish.jimmer:jimmer-sql:${jimmerVersion}")
```

> [!IMPORTANT]
> - 不使用 Jimmer 提供的 Spring Boot Starter 需要自己集成事务管理和一些其它的配置。
    > 借用官网的说明：Jimmer 自身是中立的，意味着你可以使用任何框架来集成 Jimmer 完成项目中的 ORM。
> - 如果是 Kotlin 还需要额外的配置，请自行查阅 [官方文档](https://babyfish-ct.github.io/jimmer-doc)，本文基于 Java，只讲关于
    Java 的。
