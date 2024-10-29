# 关于 Quarkus

为什么要迁移到 Quarkus 呢？个人玩具其实没有什么好说的。非要说的话，国内网上有很多对比的、推荐的、谩骂的文章博客，除了自己玩玩，都是属于叫好不叫座的。

不出意外的话，本文应该会把所有本项目使用 Quarkus 的相关问题都放在这里。

## 注解

```java
// JAX-RS 请求注解
@GET
@POST
@PUT
@DELETE

// controller 访问路径，即 web api 访问路径
@Path("/")

// ######### @jakarta.enterprise.context 包或者 @jakarta.inject 包 #########
// 惰性(延迟加载) Bean，所有注入点共享，惰性：在客户端代理上调用方法后
@ApplicationScoped

// 非懒加载，就像 @ApplicationScoped 一样，只是没有使用客户端代理。在注入解析为 @Singleton Bean 的注入点时，将创建该实例
@Singleton

// 实例不共享，并且每个注入点都会生成依赖 bean 的新实例。依赖 bean 的生命周期与注入它的 bean 绑定 - 它将与注入它的 bean 一起创建和销毁。
@Dependent

// 注入依赖
@Inject
class ii{}
```

### [@ApplicationScoped and @Singleton](https://quarkus.io/guides/cdi#applicationscoped-and-singleton-look-very-similar-which-one-should-i-choose-for-my-quarkus-application)

@Singleton bean 没有 [client 代理](https://quarkus.io/guides/cdi#client_proxies)，因此在注入 bean 时会急切地创建一个实例。相比之下，@ApplicationScoped bean 的实例是懒惰创建的，即第一次在注入的实例上调用方法时。
此外，客户端代理仅委托方法调用，因此您永远不应该直接读/写注入的 @ApplicationScoped bean 的字段。您可以安全地读取/写入注入@Singleton 的字段。
@Singleton 的性能应该略好一些，因为没有间接寻址（没有从上下文委托到当前实例的代理）。另一方面，你不能使用 QuarkusMock 来模拟 @Singleton bean。
@ApplicationScoped bean 也可以在运行时销毁和重新创建。现有的注入点之所以有效，是因为注入的代理委托给当前实例。
因此，我们建议默认使用 @ApplicationScoped，除非有充分的理由使用 @Singleton。

> 以上内容来自官网内容机翻

使用 @Inject 时不推荐使用私有成员，因为这会使用反射，GraalVM 的限制之一就是使用反射。

### Bean 分类

- Class beans 类 bean
- Producer methods 生产者方法
- Producer fields 生产者字段
- Synthetic beans 合成豆

```java
// 类 Bean
@ApplicationScoped
public class Producers {
    // 字段 Bean，但未声明 scope，默认为 @Dependent
    @Produces
    double pi = Math.PI;
    // 方法 Bean
    @Produces
    List<String> names() {
        List<String> names = new ArrayList<>();
        names.add("Andy");
        names.add("Adalbert");
        names.add("Joachim");
        return names;
    }
}

@ApplicationScoped
public class Consumer {
    // 注入字段 bean
    @Inject
    double pi;
    // 注入方法 bean
    @Inject
    List<String> names;

    // ...
}
```

Bean 类型可以声明生命周期回调(@PostConstruct、@PreDestroy)：

```java
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@ApplicationScoped
public class Translator {
    // 此回调在 Bean 实例投入服务之前调用。在这里执行一些初始化是安全的。
    @PostConstruct
    void init() {
        // ...
    }
    // 此回调在 Bean 实例销毁之前调用。在此处执行一些清理任务是安全的。
    @PreDestroy
    void destroy() {
        // ...
    }
}
```

> 最好将回调中的逻辑保持为“无副作用”，即您应该避免在回调中调用其他 bean。

#### CDI Bean 的生命周期

@PostConstruct：在 bean 构造后调用，非常适合初始化 bean。
@PreDestroy：在 Bean 被销毁之前调用，用于清理资源。
@AroundInvoke：允许您拦截和修改 bean 调用。

#### Bean 注解的作用范围（scope）

| 注解                                            | 描述                                                                                         |
|-----------------------------------------------|--------------------------------------------------------------------------------------------|
| @jakarta.enterprise.context.ApplicationScoped | 单个 bean 实例用于应用程序，并在所有注入点之间共享。实例是懒惰创建的，即在客户端代理上调用方法后。                                       |
| @jakarta.inject.Singleton                     | 就像 @ApplicationScoped 一样，只是没有使用客户端代理。在注入解析为 @Singleton Bean 的注入点时，将创建该实例。                  |
| @jakarta.enterprise.context.RequestScoped     | Bean 实例与当前请求（通常是 HTTP 请求）相关联。                                                              |
| @jakarta.enterprise.context.Dependent         | 这是一个伪范围。实例不是共享的，并且每个注入点都会生成依赖 bean 的新实例。依赖 bean 的生命周期与注入它的 bean 绑定 - 它将与注入它的 bean 一起创建和销毁。 |
| @jakarta.enterprise.context.SessionScoped     | 此范围由对象 `jakarta.servlet.http.HttpSession` 提供支持。仅当使用 `quarkus-undertow` 扩展时，它才可用。           |

### 获取请求信息、响应信息

ContainerRequestContext、ContainerRequestFilter

## 依赖

简单说一些默认情况下的默认配置，其实这些问题官网都有言明。

在 Quarkus 中，只要引入了 json 扩展(例如 JSON-B、Jackson 等)，默认情况下 Quarkus 将对大多数返回值使用 `application/json` 媒体类型，除非显式声明。（众所周知的类型有一些例外，例如 **String** 和 **File**，它们分别默认为 text/plain 和 application/octet-stream

## 多模块项目

### [Bean发现](https://quarkus.io/guides/cdi-reference#bean_discovery)

默认情况下，Quarkus 不会在另一个模块中发现 CDI bean。这就会导致一个模块中的配置在另一个引用它的模块中不起作用(例如拦截器等配置)。

为多模块项目中的模块启用 CDI bean 发现的最佳方法是包含一个 `META-INF/beans.xml` 文件，除非它是配置了 quarkus-maven-plugin 的主应用程序模块，在这种情况下，它将自动被索引。

或者，可以使用一些非官方的 [Gradle Jandex](https://plugins.gradle.org/search?term=jandex) 插件来代替 `META-INF/beans.xml` 文件。

## 类

### 关于 MessageBodyReader、MessageBodyWriter

重写这两个接口可以实现自定义格式的读取和输出。因此可以使用 MessageBodyWriter 实现返回客户端响应封装的效果。

> - 在 MessageBodyWriter 实现的 writeTo 方法中无须关闭实体输出流。该流将由 Jersey 运行时自动关闭。
> - 深入了解：https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/message-body-workers.html
