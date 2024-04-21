# 项目总结

浪子觉得总结不一定必须在最后写，在过程中写也是一样的。简单谈谈自己开发下来的感受。

## 一、个人总结

### 1.1 Spring xml 配置与 Java 配置

从 Spring4.x 版本开始，Spring 已经不推荐使用 xml 配置了，而是推荐 Java 配置，Java 配置也是 Spring Boot
推荐的配置方式。不过很多前辈、大牛，都很了解 xml 配置这种方式，这种方式对新手不是那么容易接受，至少浪子刚开始的时候确实如此。

不过得益于时代发展和技术更新，浪子工作的时候基本都是 Spring Boot 项目，还有更多都是要求掌握 Spring Cloud 了。(
Cloud也没什么，就是组件多了而已，~~其实是维护排查问题还有数据同步问题困难、麻烦~~)。

对于 `xml` 配置的方式进行项目开发接触不是太多。后面随着学习的深入，再看到这种项目浪子觉得 `xml`
是一个非常好的组件清单（你可以把它看成一个文档）;维护者接手这个项目只要看一眼这个 `xml`
就能搞清楚系统的组件的“架构（包括依赖关系）”。不过 `xml`
文件没有类型检查，如果导入了一个错误的类，可能你需要找很长时间的错误(不过我们有智能 IDE！但字符串拼写还是有可能漏查的)。

### 1.2 ORM

说实话，如果项目是采用敏捷开发的方式，很多时候数据库方面不会设计的很完美。尤其是小公司，时间紧，任务重，导致程序员直接梭哈，有什么问题以后再说。结果就是：在开发的过程中需要频繁的添加或者修改字段，项目中如果不使用
lombok 那是相当难受的；如果采用的手写 SQL，维护所付出的时间和精力也是很大的，尤其是后期。当然，你可以把 SQL
按照功能或者业务分类进行文件拆分，但是维护起来还是很麻烦。那将非常的浪费~~摸鱼的~~ （学习的）时间。所以选择一个合适的
ORM 框架是非常有必要的。

我自己工作中不是使用 MyBatis 就是 MyBatis Plus(MP)，其它的只是有所了解但没怎么使用过。唉，怎么说呢，SQL 写多了，有时候会怀疑人生，使用
Java8 还不能用 record 快速构建一个响应对象，导致最终很多的 DTO 类，但是里面只有几个字段🤣

最后，我自己想试试 Spring Data JPA，这个东西提供了一种叫 SQL Query DSL 的东东，直接使用 Java 代码完成
SQL（我个人比较喜欢这种，见仁见智吧，主要是 SQL 优化可以全部扔给框架提供者实现，偷个懒，嘿嘿~）。

那就有人说了，MP 也有啊！废话，我知道有，也用过了，想试试新东西没有问题吧！

然后，然后，然后自己稀里糊涂的发现了 Jimmer，看了作者大大的实现思路和理念，最终决定换成这个尝试一哈~框架作者帮我优化 SQL，欸嘿！

## 二、学习类库

这些类库在项目中都没有用过，为了简洁、减少依赖，这里单独拎出来写。这些东西都是开发过程中在网上获取资料时发现的，看起来挺不错的。可以酌情在项目中使用。

- 集合库：[eclipse collections](https://www.eclipse.org/collections/)
  ，具体使用可以参考看这篇文章：https://www.baeldung.com/eclipse-collections

## 三、其它文档

### JWT

- https://jwt.io/introduction/

### Java 异步

- https://www.callicoder.com/java-8-completablefuture-tutorial/
- https://www.callicoder.com/java-concurrency-multithreading-basics/
- https://www.codedemo.club/spring-security-async-principal-propagation/
