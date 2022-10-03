# Instructions

代码功能以及风格的一些说明

## Feature

2022.9.7

- Restful Interface
- controller 请求地址前缀支持自定义，默认 `api`；
- jwt token，前缀支持自定义，默认 `Authorization `；
- 支持 Security 采用的 PasswordEncoder 自动升级密码加密方式；

## Todo

* [ ] 权限隔离
* [ ] 登录验证码
* [ ] 加入redis缓存
* [ ] 数据脱敏

## Note

### 1. 数据库

本项目中有关数据库的说明如下。

#### 1.1 互斥使用 bit 类型字段

- 确定互斥的逻辑使用 `bit` 类型，该类型特征：`> 0 ? true : false`  
  因此可以在实体中使用 `boolean` 与之对应，在 SQL 语句操作时，bit 类型的属性可以用 `true/false`
  赋值，数据库会自动转为 `1/0`。
- 例如：逻辑删除标识字段 `del_flag`，该字段是一个互斥字段。 `1` 为删除(true)，`0` 为未删除(false);
- 再如启用标识字段 `enabled`: `1` 为启用，`0` 为未启用。

  如果 使用 `bit(M) M>1` 来表示数据，数据大小不仅可以表示 0 或 1，也可以表示大于 1 的数，映射到 Java 的数据类型 Boolean 时，
  0对应为false，非0的数据都将映射为true。

### 2. 注入方式

本项目使用构造注入（构造注入的可以防止注入的对象 NPE），该方法可能会造成代码冗余过多的情况。从 Spring4.3
之后，如果一个类中只有一个构造函数，那么 Spring
将根据构造函数自动注入。所以在 `xxxServiceImpl` 里看到以下信息不要惊讶。

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    // ...业务逻辑

    private final DemoDao demoDao;

    // 这里的 Autowired 注解可加可不加
    @Autowired
    public DemoServiceImpl(DemoDao demoDao) {
        this.demoDao = demoDao;
    }
}
```

> 为了看代码比较方便，类中所有需要注入的对象全部放在该类的最后。

## Structure

```bash
|-- src
|   |-- main
|   |   |-- java
|   |   |   `-- com
|   |   |       `-- example
|   |   |           |-- common                  # 普通包
|   |   |           |   |-- annotation          # 注解
|   |   |           |   |-- config              # 配置相关
|   |   |           |   |   |-- kaptcha         # Verify Code
|   |   |           |   |   `-- security        # Spring Security
|   |   |           |   |-- constant            # 常量
|   |   |           |   |-- exception           # 异常
|   |   |           |   |-- filter              # 过滤器
|   |   |           |   |-- interceptor         # 拦截器
|   |   |           |   |-- log                 # 日志相关
|   |   |           |   |-- response            # 响应
|   |   |           |   `-- utils               # 工具类
|   |   |           |-- controller              # controller
|   |   |           |-- domain                  # entity
|   |   |           |-- repository              # dao
|   |   |           `-- service                 # service
|   |   |               `-- impl                # serviceImpl
|   |   `-- resources                           # 资源文件
|   `-- test                                    # 测试包
|       `-- java
|           `-- com
|               `-- example
```

> common package 下包名除工具类以外全部使用 `单数` 形式，`utils` 包下名称后缀一律为 `单数` 形式

## My ideas

### 1. 封装

对于高级语言来说，原生的（不考虑最底层） API 想要使用的舒服，必须封装，尤其是 io，需要考虑多种可能出现的异常。  
本项目初期开发都是用 JDK 或者 Spring 框架原生的工具类
API，开发过程中如果缺少对应的也会自己封装一些。
为什么不使用 `common-lang3` 和 `hutool`？
有些工具类（比如字符串）除了某些业务场景必须要自己手动实现之外，其它引入的工具类大同小异，上述两种工具都非常强大易用，但在能满足使用的情况下浪子不会引入这些依赖。如果后面需要使用的工具类有很多，那么浪子会考虑放弃自己封装，引入 `hutool`
。

### 2. Spring xml 配置

从 Spring4.x 开始，Spring 已经不推荐使用 xml 配置了，推荐 Java 配置，Java 配置也是 Spring Boot
推荐的配置方式。不过很多前辈、大牛，都知道这种方式，但是这种方式对新手不是那么容易接受，至少浪子刚开始的时候确实如此。

不过得益于时代发展，我工作的时候基本都是 Spring Boot 项目，提倡 ”约定大于配置“，而且大多数都是要求掌握 Spring Cloud 的。对于
xml 配置的方式进行项目开发接触不是太多。

后面随着学习的深入，个人觉得其实 spring 的 xml
是一个非常好的组件清单（你可以把它看成一个文档）;后来的维护者接手这个项目只要看一眼这个 `xml` 就能搞清楚系统的组件的“架构（包括依赖关系）”。不过
xml 文件没有类型检查，如果导入了一个错误的类，可能你需要找很长时间的错误(不过我们有智能 IDE！但字符串还是有可能漏查的)。

但是如果使用注解的话，那么这些关系配置都会散落在系统的各个角落，理清组件间的关系也是需要一定的时间的，尤其是对于规模较大的项目，除非你有非常好的文档或者约定。

### 3. Hibernate Or Nutz.Dao

项目开发初期，或者入门人员自己编写的 Demo 案例，很多时候数据库属性不会设计的很完美，在开发的过程中需要频繁的删除或者修改字段。如果是使用的
mybatis，那就需要我们频繁的去对我们的代码做修改。使用 lombok 的情况下我们对实体所做的就是添加属性，如果没有使用则还需要添加
setter、getter、toString 等；除此之外，如果有自定义的响应，比如所谓的 DTO、VO 等，也需要修改；还有 `sql.xml` 文件可能也需要修改。

另一方面，手写的 SQL 如果特别多的话，后期维护也是比较头疼的一件事。可能有人说，如果 SQL 较多的话我使用多个 `sql.xml` 文件，它们的
namespace 都指向同一个 Dao 接口不也是可以的？没错，是可以，但是上面频繁的修改依旧是免不了的。最重要的是，如果是个人业余的项目这样做，会浪费很多时间，并不是每个人、每个公司都有
DBA 专员，能够完美或者较完美的去设计库表的结构及预测后期的需求变化。

此时修改大量的文件会导致效率底下，如果映射做的不好，漏了哪个字段还需要修改重启多次去测试。

如果使用 Mybatis Plus 的话可能是一个很好的选择，如果你的 SQL 能力比较强，这两种方式无论使用哪种都是可以的，技术选型唯手熟尔。

其实也可以考虑使用 Hibernate，自带分页、验证器。使用的话，可以引入 JPA，JPA 是一种规范，而 Hibernate 是它的众多实现中的一种，但是
Hibernate 的功能比 JPA 要多，得益于它的社区更新较快。至于网上现在为什么使用
Hibernate 就引入 JPA 的依赖而不引入 Hibernate 依赖的这个问题，就很神奇，大家可以自行搜索。

很多人说 Hibernate 不灵活，复杂场景（多表连接）就特别难受。其实浪子觉得其实也不用强求必须遵循三范式，建模对于后期的影响比较大，适当的冗余可以减少表连接，也减少的与数据库交互、dev
维护的复杂度，不好？很多人说具体场景根据不同业务采用不同的技术，这是非常正确的，毕竟开发受多种环境的影响。

NutsDao 也很不错，不过建议和 NutsBoot 一起使用比较好。

因此，浪子这里使用 Spring JPA，感觉对于个人来说很不错。使用框架的时候更换就行，引入 Mybatis 或者 Plus 也不难，使用 Hibernate
就更简单了。
