# 简介

为了更好的了解一些技术的使用以及原理，甚至是一些问题，新开一个模块结合前端框架 [Vben Admin](https://vvbin.cn/doc-next/)
一起写一个简单的例子。

```bash
|-market-vben-example/src             # 后端源码
|  |-main/java
|  |  |-com/example
|  |  |  |-common                     # 常规文件
|  |  |  |  |-config                  # 配置文件
|  |  |  |  |  |- kaptcha             # 验证码
|  |  |  |  |  |- security            # spring security
|  |  |  |  |-...
|  |  |  |-domain                     # 实体类
|  |  |  |-mapper                     # 数据层
|  |  |  |  |-xml                     # xxxMapper.xml文件
|  |  |  |-service                    # 服务层
|  |  |  |  |-impl                    # 服务层实现
|  |  |  |-controller                 # 控制层
|  |  |  |-filter                     # 过滤器
|  |  |  |-inceptor                   # 拦截器
|  |-main/resources                   # 资源文件
|-market-vben-example/vue-vben-admin  # 前端源码
```

# 开发理念

- 新
    - 新的日期处理类
    - 框架新版本

- 少
    - 尽量减少第三方库的依赖，尽量减少工具类的封装，使用 JDK 或者项目中使用的依赖库以及框架自带的工具类，例如 Spring
      框架的工具类。比如
      Base64 既可以使用 `java.util` 包下的工具类，也可以使用
      Spring 框架提供的 `Base64Utils` 工具类，判空使用 Spring 框架的 `ObjectUtils.isEmpty()`。
    - 虽然封装的工具类用着舒服，但是个人感觉其它api用着也行，异常处理的还是建议封装一层，不然难受。
    - 如果后期必须使用大量封装的话，考虑引入 Hutool 或自行封装。

## 说明

目前项目中使用直接属性注入，后面会修改为构造注入。构造注入可以避免该属性没有注入而报 NPE 的异常。但是注意，该方法可能会造成代码过多的情况。

# 后端工具使用

```bash
|-JDK17

|-spring boot2.7.2
  |-spring security(5.7.x)
  |-spring mvc
  |-spring-mybatis
  |-spring swagger3.0
  |-lombok
  
|-MySQL8.0
```

# 前端工具请参考 [Vben Admin 官方文档](https://vvbin.cn/doc-next/)

## 延伸阅读

- [Vben Admin 官方文档](https://vvbin.cn/doc-next/guide/introduction.html)
- [Ant-Design-Vue](https://2x.antdv.com/docs/vue/introduce-cn/)
- [Vitejs](https://vitejs.dev/)
- [Vue-Router](https://router.vuejs.org/)
- [TypeScript](https://www.typescriptlang.org/)
- [Es6](https://es6.ruanyifeng.com/)

```bash
# 安装依赖
yarn
# 启动项目
yarn dev
# 打包
yarn build
```