## 一些说明

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

本系统全面使用 jsr310 标准日期

### 普通工具类

基本都使用 JDK 原生的的 API 或者 Spring 提供的工具类，减少依赖，降低工具类泛滥。

### 全局异常和全局状态响应

全局异常信息和全局状态响应分开

### 关于Optional使用

推荐在返回值中返回 null 时出现程序错误的时候使用。

### java-comment

i think you need read it: https://www.geeksforgeeks.org/comments-in-java/

