## 构建多模块

本项目已经是多模块的雏形（这是一个多模块的项目，但是把所有文件都放到了一个模块，浪子不太喜欢多模块，文件树太长）。但是该项目框架采用 `多模块思想`
，使用文件夹分层分级，方便有需要的少侠后续重构。

如果您需要构建多模块，打开项目根路径的 `settings.gradle` 文件，可以看到如下内容：

```gradle
rootProject.name = 'market'
include 'leaf-example-boot3'
```

第一行是项目根路径，后面的 `include` 就是包含的子模块名称。

依赖管理也非常简单，项目根路径的 `build.gradle` 文件就是项目总配置内容，该文件最后有一段文本：

```gradle
// 子工程配置
subprojects {
    // 为什么为空？因为目前这是一个单模块项目
    // 如果喜欢，想要多模块开发，自行配置即可
    // -------------- 题外话 -------------------
    // 多模块开发，我很讨厌，找个东西都要扒拉半天，得亏 idea 智能，双击 Shift 天下无敌，让文件无处可逃。
    // 但是打开的文件树还是很恶心。
    // 单模块分包开发，可以；微服务采用多模块开发，没问题！
    // 不采用微服务，多模块开发？！Oh my god，浪子很难受
}
```

此段配置可以配置子项目的公共内容。

至于各个模块的依赖配置，类似 `Maven`，在每个模块下都有一个 `build.gradle` 文件，在里面配置各自的内容即可。

## 使用 ResponseBodyAdvice 封装返回结果集

一般我们在返回到前端的结果都会经过一层封装，该类大多必包含 `code`、`data`、`msg` 三个属性。然后在 `controller`
层的返回值都使用该类封装后再返回。

有时候返回的时候我们会忘记设置该返回值，有的项目使用 `ResponseBodyAdvice` 接口来对返回值做统一的封装，问题就出现在这里。

如果使用此接口做包装，`controller` 层返回的都是不经过包装类封装的结果。在使用 Apifox
等工具导入的时候，如果导入的有实体模型数据，那么该工具将会以直接返回的结果构建模型。但是在测试校验时返回的对象是封装的对象，这时该工具就会报告测试报错，不通过。

因此，如果项目中同时使用了 `swagger`、`ResponseBodyAdvice` 和
其它测试工具（例如Apipost，导入 swagger 文档），在自动化测试的时候 **可能会出现问题**，需要手动修改测试工具(Apifox等)
的导入模型。如果项目成员的接口文档写的好，不推荐使用 `swagger`；如果喜欢使用 `swagger` 的话，那就推荐 controller
层直接返回封装后的结果。当然，以上都是在使用自动化测试的前提下，若不使用。。。

```java

@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    // 省略其它 ...
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return body;
        }
        return ResultResponse.success(body);
    }
}

@Api(value = "user 管理模块", tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * swagger 文档导入到 apifox 等自动化测试的软件中实际的实体模型为 User
     * 可能会影响测试结果
     * 所以如果需要的话，建议此处返回值为 R（自封装结果）
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取指定用户", notes = "根据 id 获取指定用户信息，get 方法")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
```

## JSON 工具类

只是基于 ObjectMapper 封装了简单的几个方法，推荐使用 Alibaba 的 fastjson2。

## Http 网络工具

使用 JDK 的 HttpClient 封装的工具类，如果你喜欢使用 RestTemplate，也可以替换或者加入进来。

## 日期

本系统全面使用 jsr310 标准日期。

## 普通工具类

基本都使用 JDK 原生的的 API 或者 Spring 提供的工具类，减少依赖，降低工具类泛滥。

## 全局异常和全局状态响应

全局异常信息和全局状态响应分开。

## 关于Optional的使用

本项目强制只在返回值中使用该类，返回的 `Null` 是否有用，或是抛出异常，或是构造新的空值对象类都能满足。

## java-comment

i think you need read it: https://www.geeksforgeeks.org/comments-in-java/

## 关于Swagger、Spring Doc等工具

emmm，刚开发时喜欢的不得了，非常喜欢使用，接口注释都写在里面，不用 JavaDoc
帮我省去了很多空间。后来慢慢的，使用了 `apifox`、`apipost` 等工具，再使用 swagger
的话，总感觉有点儿多余。侵入性倒是没什么，打包体积咱也不担心，单纯感觉多余。当然，如果是中途进了项目组的话，前面的人没有写好接口文档的话，那咱们维护、开发就惨了。

所以浪子现在感觉那是留给平常偷懒的工具，本项目不引入相关依赖 ~~（少写了一些配置类，爽啊 :smile:）~~，使用 `apifox`
做接口开发、维护、调试，接口功能完善后随项目一同上传。

## [为什么使用构造注入？](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/htmlsingle/#beans-setter-injection)

以下内容摘自 Spring 官网：
> The Spring team generally advocates constructor injection as it enables one to implement application components as
> immutable objects and to ensure that required dependencies are not null. Furthermore constructor-injected components
> are
> always returned to client (calling) code in a fully initialized state. As a side note, a large number of constructor
> arguments is a bad code smell, implying that the class likely has too many responsibilities and should be refactored
> to
> better address proper separation of concerns.

机翻一下：
Spring团队通常提倡构造函数注入，因为它使人们能够将应用程序组件实现为不可变对象，并确保所需的依赖项不为空。此外，构造函数注入的组件总是以完全初始化的状态返回到客户端（调用）代码。顺便说一句，大量的构造函数参数是一种糟糕的代码气味，这意味着类可能有太多的责任，应该进行重构，以更好地解决关注点的适当分离。

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    // ...业务逻辑

    private final DemoDao demoDao;

    // 这里的 @Autowired 注解可加可不加
    @Autowired
    public DemoServiceImpl(DemoDao demoDao) {
        this.demoDao = demoDao;
    }
}
```

> 为了看代码比较方便，类中所有需要注入的对象全部放在该类的最后。

## [Spring MVC PathPattern、AntPathMatcher](https://spring.io/blog/2020/06/30/url-matching-with-pathpattern-in-spring-mvc)

`PathPattern` 是 Spring 5.0 提供的，在 Spring 6.0 中又有了改进。本项目全部使用 `PathPattern`，`AntPathMatcher`
是之前的路径匹配器。如果是新项目的话，推荐使用 Spring 提供的 `PathPattern`。

另外，如果项目中没有配置 `spring.mvc.pathmatch.matching-strategy` ，默认使用的也是 `PathPatternParser`。

Spring Security 5.7 之后的写法改变，包括路径的写法，无须显示调用 `antMatcher`、`mvcMatcher`。

## Eclipse Collections

官网指路：https://www.eclipse.org/collections/
使用请看这篇文章：https://www.baeldung.com/eclipse-collections
