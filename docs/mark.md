## 一些说明

### 构建多模块

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

### 封装结果集

Controller 接口层返回数据统一处理
注意：使用其它接口工具导入 swagger 接口进行自动化或者批量测试时，不以该对象为主，而是以 controller 中实际返回的对象为主。
因此，还是建议 controller 的每个方法的返回值都为封装的对象

```java

@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    // 省略其它 ...
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JSONUtil.toJSONString(body);
        }
        return R.success(body);
    }
}


@Api(value = "user 管理模块", tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 在把 swagger 导入到 apifox 等自动化测试的软件中实际的实体为 User
     * 所以如果需要的话，建议此处返回值为 R（自封装结果）
     */
    @GetMapping("{id}")
    @ApiOperation(value = "获取指定用户", notes = "根据 id 获取指定用户信息，get 方法")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
```

### JSON 工具类

只是基于 ObjectMapper 封装了简单的几个方法，推荐使用 Alibaba fastjson2，更换简单。

### Http 网络工具

使用 JDK 的 HttpClient 封装的工具类，如果你喜欢使用 RestTemplate，也可以替换或者加入进来。

### 日期

本系统全面使用 jsr310 标准日期。

### 普通工具类

基本都使用 JDK 原生的的 API 或者 Spring 提供的工具类，减少依赖，降低工具类泛滥。

### 全局异常和全局状态响应

全局异常信息和全局状态响应分开。

### 关于Optional的使用

本项目强制只在返回值中使用该类，返回的 `Null` 是否有用，或是抛出异常，或是构造新的空值对象类都能满足。

### java-comment

i think you need read it: https://www.geeksforgeeks.org/comments-in-java/

## Swagger、Spring Doc说明文档

emmm，刚开发时喜欢的不得了，非常喜欢使用，接口注释都写在里面，不用 JavaDoc
帮我省去了很多空间。后来慢慢的，使用了 `apifox`、`apipost` 等工具，再使用 swagger
的话，总感觉有点儿多余。侵入性倒是没什么，打包体积咱也不担心，单纯感觉多余。当然，如果是中途进了项目组的话，前面的人没有写好接口文档的话，那咱们维护、开发就惨了。

所以浪子现在感觉那是留给平常的懒人工具，本项目不引入相关依赖 ~~（少写了一些配置类，爽啊 :smile:）~~，使用 `apifox`
做接口开发、维护、调试，接口功能完善后随项目一同上传。
