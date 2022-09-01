# 简介

为了更好的了解一些技术的使用以及原理，甚至是一些问题，新开一个模块结合前端框架 [Vben Admin](https://vvbin.cn/doc-next/)
一起写一个简单的例子。

- [项目结构和介绍请移步](./market-vben-example/instructions.md)
- [项目使用工具清单请移步](./listutils.md)

# 开发理念

- 新
    - 新的日期处理类
    - 技术框架使用最新版本
    - 尝试最新语法

- 少
    - 尽量减少第三方库的依赖，尽量减少工具类的封装，使用 JDK 或者项目中使用的依赖库以及框架自带的工具类，例如 Spring
      框架的工具类。比如
      Base64 既可以使用 `java.util` 包下的工具类，也可以使用
      Spring 框架提供的 `Base64Utils` 工具类，判空可以使用 Spring 框架的 `ObjectUtils.isEmpty()`。
    - 虽然封装的工具类用着舒服，但是个人感觉其它 api 用着也行，异常处理的还是建议封装一层，不然难受。
    - 如果后期必须使用大量封装的话，考虑引入 `Hutool`。

# 部署


# 致谢

感谢：[Vben Admin](https://vvbin.cn/doc-next/) 社区提供的优秀框架。
