# Jimmer

## 一、为什么切换到 Jimmer？

higher faster stronger

## 二、基本使用

官网写的很详细了，很多的重复都是徒劳的。本项目使用 Java 语言，只讲解 Java 配置，Maven
如何配置请见 [Jimmer官方文档](https://babyfish-ct.github.io/jimmer-doc)，写的很详细了。

```kotlin build.gradle.kts
val jimmerVersion = "0.8.121"
// Jimmer Spring Boot Starter
annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:${jimmerVersion}")

// Without Jimmer Spring Boot Starter
annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
// 用户编写的实体代码所需的依赖
implementation("org.babyfish.jimmer:jimmer-core:${jimmerVersion}")
// 生成的代码所需的依赖，其他项目必然导入包含此依赖
compileOnly("org.babyfish.jimmer:jimmer-sql:${jimmerVersion}")
```

> [!IMPORTANT]
> - 若不使用 Jimmer 提供的 Spring Boot Starter，使用时需要自己集成事务管理和一些其它的配置。借用官网的说明：Jimmer
    自身是中立的，意味着你可以使用任何框架来集成 Jimmer 完成项目。
> - 如果你是第一次使用 Jimmer，强烈建议先通读一遍官方的文档，读不懂也没关系，实际使用中遇到问题有个大概印象，实在不行就问群友
    doge。

## 三、注意点

首先，Jimmer
的默认命名策略需要了解：[https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/base/naming-strategy](https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/base/naming-strategy)

Jimmer 的实体接口默认为非 null，如果为可 null，使用 `org.jetbrains.annotations.Nullable` 修饰。
`@Id` 属性必须非 null。Java 语言使用 boolean、char、byte、short、int、long、float、double。

### 实体声明

```java
// 声明一个 Jimmer 实体类
@org.babyfish.jimmer.sql.Entity
// 该实体对应的数据库表名，如果有不同的 schema，也可以加入
@org.babyfish.jimmer.sql.Table("schema.table_name")
public interface User {
    /**
     * Jimmer 提供了四种策略：
     * IDENTITY：数据库自动编号
     * SEQUENCE：数据库序列
     * @GeneratedValue(generatorType = UUIDIdGenerator.class)：UUID
     * 雪花ID
     */
    @org.babyfish.jimmer.sql.Id
    @org.babyfish.jimmer.sql.GeneratedValue(strategy = GenerationType.IDENTITY)
    int id();

    // 指定实体与数据库字段的映射
    @org.babyfish.jimmer.sql.Column(name = "userName")
    String username();

    String password();
}
```

:::tip 说明

- `@Column` 仅用于明确指定非关联属性列名，对于多对一或一对一关联属性的外键列名，必须通过 `@JoinColumn` 指定。
- 如果 ID 策略为 `SEQUENCE` 同时 `sequenceName` 属性未被指定，则使用 Jimmer
  的默认[命名策略](https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/base/naming-strategy)。
- 如果上面的 ID 策略都无法满足，Jimmer 提供了 `UserIdGenerator<T>` 接口，可以覆写该接口实现自己的 ID 生成算法。
- 由于 Jimmer 中使用 `Objects.createXXXX()`（后期会移除）和 `XXXDraft.$.produce()` 创建对象，加之 JDK 的 Objects
  内置方法较少，所以本项目迁移至 Jimmer 后代码中不再使用
  JDK 内置的 `Objects` 工具方法。

:::

