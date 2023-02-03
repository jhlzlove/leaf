# 项目说明

## 1. [为什么使用构造注入？](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/htmlsingle/#beans-setter-injection)

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

## 2. 数据库的选择

开源的两大数据库，都接触一下试试呗。道听途说不如亲身体验。
