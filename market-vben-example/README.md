# 工程简介

为了更好的了解一些技术的使用以及原理，甚至是一些问题，新开一个模块结合前端框架 [Vben Admin](https://vvbin.cn/doc-next/)
一起写一个简单的例子。
准备都使用最新版本构建。

```bash
|-market-vben-example/src             # 后端源码
|  |-main/java
|  |  |-com/market/example
|  |  |-com/market/config               # 配置文件
|  |  |-com/market/domain               # 实体类
|  |  |-com/market/mapper               # 数据层
|  |  |-com/market/service              # 服务层
|  |  |-com/market/controller           # 控制层
|  |-main/java/resources               # 资源文件
|-market-vben-example/vue-vben-admin  # 前端源码
```

本项目尽量减少第三方库的依赖，使用 JDK 或者 Spring 相关框架原生的简单工具。比如 Base64 既可以使用 `java.util` 包下的工具类，也可以使用
Spring 框架提供的 `Base64Utils` 工具类。另外，都使用 Java8 提供的新的日期处理类。

# 延伸阅读

- [Vben Admin 官方文档](https://vvbin.cn/doc-next/guide/introduction.html)
- [Ant-Design-Vue](https://2x.antdv.com/docs/vue/introduce-cn/)
- [Vitejs](https://vitejs.dev/)
- [Vue-Router](https://router.vuejs.org/)
- [TypeScript](https://www.typescriptlang.org/)
- [Es6](https://es6.ruanyifeng.com/)

# 后端工具使用

JDK17、Lombok、Spring Boot2.7.x、MySQL

```bash
|-spring boot2.7.2
  |-spring security(5.7.x)
  |-spring mvc
  |-spring-mybatis
  |=spring swagger3.0
```

# 前端工具请参考 [Vben Admin 官方文档](https://vvbin.cn/doc-next/)

```bash
# 安装依赖
yarn
# 启动项目
yarn dev
# 打包
yarn build
```