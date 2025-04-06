# Why？

开始的时候，这个项目的定位是对自己工作以来的开发经验的总结，把自己的学习、思考、与其它的小收获融入到这个项目中，因为 Java 生态不缺轮子。但是随着工作的使用，忽然发现使用的框架多多少少存在一些问题，并且不太好解决：

- 框架的迭代跟不上技术的迭代，Java 新版本的那些实用的特性无法使用；
- 应用框架的封装过深，找一个东西需要花费很长时间；
- 应用框架引入的第三方包较为杂乱(用过若依原版框架的应该知道一个项目同时拥有 Spring + SpringBoot 的依赖)；
- 代码设计、包装过度，晦涩难懂；
- 源码开源，文档却不是；等等。

这种应用框架想改是不太好修改的，尤其是自定义过深且没有文档参考更是难上加难。后面看技术大佬的博客时，读到了一句话：“虽说不要重复造轮子，但是自己造的轮子它不会脱离自己的控制”。很有感触，就萌生了自己做一个应用框架的想法。

现在，基本所有的 Javaer 都知道了 Spring Boot 相较于 Quarkus 和 Micronaut 而言有点儿笨重。但是毫无疑问，目前为止，Spring Boot 的生态很完美，体验也是最好的，没有之一，开源社区已经存在很多使用 Spring Boot 脚手架的应用框架了。

本着生命不息，折腾不止的原则，打造了这个玩具项目。

:::tip 个人的想法

一个简单的项目框架，使用什么工具最好交给使用者自己去选择。框架自身引入越少的 lib 不仅可以使得最终打包体积减小（虽然得益于科技的发展这已经不算什么了），而且还可以减少冲突。对于其它的好用的、流行的第三方库的使用权就交给用户选择吧，毕竟 Java 生态极其庞大，好用的类库有很多，根据自己或者团队选择合适的就可以。选择自己趁手的武器去战斗吧！

:::

## 一、Feature

作者整理的很勤快，这里什么都没有留下...

## 二、使用工具清单

| 工具         | 版本     |
|------------|--------|
| JDK        | 21+    |
| Micronaut  | 4.x    |
| Gradle     | 8.8+   |
| PostgreSQL | 16+    |
| Redis      | 7.2.5  |
| czg        | latest |
| Dbeaver    | latest |
| VSCode     | latest |
| Maven      | latest |

## 三、结构

### 目录结构

划分多模块依据 package 拆分，可以更好的移植到微服务结构，因此本项目不使用多模块。另外必须提一嘴，多模块划分后依赖比较难搞，各种服务比较分散。 ~~不是哥们儿，写个业务我还得思考该放哪个模块，老板要的提升效率呢！~~

```bash

```

## 四、Thanks

感谢各个开源社区，不分语言，不分国家，不涉政治地理文化。互联网能有今天的发展，离不开各个社区、成员所作的贡献，开源社区太强大啦

- JetBrains IDEA Community
- [Micronaut](https://micronaut.io/)
- [Jimmer](https://github.com/babyfish-ct/jimmer)
- [Gradle](https://gradle.org/)
- [Postgresql](https://www.postgresql.org/)
- [VitePress](https://vitepress.dev/)
- [czg](https://cz-git.qbb.sh/zh/)

## 五、推荐

如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：

- [Lombok](https://plugins.jetbrains.com/plugin/6317-lombok)
- [Log Support 2](https://plugins.jetbrains.com/plugin/9417-log-support-2)
- [Translation](https://plugins.jetbrains.com/plugin/8579-translation)
- [HttpRequest](https://plugins.jetbrains.com/plugin/26352-httprequest)
- [Jimmer Buddy](https://plugins.jetbrains.com/plugin/26622-jimmer-buddy)
- [JimmerDTO](https://plugins.jetbrains.com/plugin/22618-jimmerdto)

### 类库

- 集合库：[eclipse collections](https://www.eclipse.org/collections/)，具体使用可以参考看这篇文章：https://www.baeldung.com/eclipse-collections

### Java 异步

- https://www.callicoder.com/java-8-completablefuture-tutorial/
- https://www.callicoder.com/java-concurrency-multithreading-basics/
- https://www.codedemo.club/spring-security-async-principal-propagation/

### 一些参考链接

- [Quarkus](https://quarkus.io/)
- [quarkus vs micronaut](https://digma.ai/quarkus-vs-micronaut/)
- [JWT](https://jwt.io)