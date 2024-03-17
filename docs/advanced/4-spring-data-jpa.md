# SpringDataJPA

## 一、注解

### @Entity、@Table、@Id、@GeneratedValue

使用 JPA 实体类需要添加 `@Entity` 声明该类是一个实体。该注解可以用一个 name
属性来标识对应的数据库的表名。当然也可以和另一个注解共同使用 `@Table` 实现同样的效果。

使用 `@Entity` 注解的类必须使用 `@Id` 注解，这两个注解 **必须** 同时出现。`@GeneratedValue` 指定 id
列的值的增长策略规范，默认为 `AUTO`，一般设置为 `@GeneratedValue(strategy = GenerationType.IDENTITY)`
，表示使用数据库的自增策略。除此之外，还有 `TABLE`、`SEQUENCE`、`UUID`。

```java
// 下面两种写法选一种使用即可
@Entity(name = "表名")
// OR
@Entity
@Table("表名")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

### @Transient

如果在实体类中出现了数据库中没有的字段，可以在该字段上使用 `@Transient` 注解，此注解表明该字段不参与数据持久化。

```java
// omit other annotation
public class User {
    @Id
    private Long id;
    @Transient
    private String ignoreValue;
}
```

### @OneToOne、@OneToMany、@ManyToOne、@ManyToMany、@ManyToAny

如果该实体有一对多的关系，使用集合需要在属性上添加 `@OneToMany`
注解。同理，还有一个 `@ManyToMany` 注解代表多对多的关系，其它类似。下面是最最最简单的使用，具体使用推荐看这几个注解的源码注释。

```java
// omit other annotation
public class User {
    @Id
    private Long id;
    @OneToMany // 一对多关系
    private List<Role> roles;
    @ManyToMany // 多对多关系
    private List<Condition> conditions;
}
```

### @DynamicInsert、@DynamicUpdate(Spring6.0 已弃用)

@DynamicInsert：指定注释实体的SQL插入语句是动态生成的，只插入实体对象的非空属性列。如果实体在第一次持久化时可能具有许多空属性，那么这可能会提高性能。但是，在运行时生成SQL会产生一定的成本。
@DynamicUpdate：动态更新，只更新改变的列值，若不开启（false），调用更新接口会根据传入的对象的所有字段进行更新（对于没有传的字段，会以
null 值覆盖更新）。

```java
// omit other annotation
@DynamicInsert
@DynamicUpdate
public class User {
    // ...
}
```

### @MappedSuperclass

抽取使用公共属性类时，需要在公共属性类上加入 @MappedSuperclass 注解。

```java

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 创建者 */
    private String createBy;

    /**创建时间 */
    private LocalDateTime createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    private LocalDateTime updateTime;

    /** 备注 */
    private String remark;
}
```

### @PageableDefault

将 `Pageable` 注入控制器方法时设置默认值的注释，其默认值为 page = 0, size = 10。您也可以使用 `SortDefault`
或 `SortDefault.SortDefaults` 来代替配置 `sort()` 和 `direction()`。

```java
class UserController {
    /**
     * 如果没有传入 Pageable 对象的 page、size 值，则默认设置为 page=0，size=20
     */
    @GetMapping
    public Page<User> listPage(@PageableDefault(page = 0, size = 20) Pageable page) {
        return userService.listPage(page);
    }
}
```

### @EntityListeners、@EnableJpaAuditing

开启 JPA
审计功能，可以在我们的操作中自动的更新一些公共字段：创建者、更新者、创建时间、更新时间，这样我们无须在程序中手动设置。使用该功能，需要在 `Application`
启动类上加入 `@EnableJpaAuditing` 开启。
具体使用详见：https://www.baeldung.com/database-auditing-jpa

### @Modifying、@Query

在 Spring Data Jpa 中，使用 `@Modifying` 注解的方法，自身或者调用方至少其中之一必须添加事务确保数据的四大特性，如果不添加事务控制则会输出以下内容且不执行该
SQL：

```bash
Executing an update/delete query
```

### @EnableJpaRepositories、@Repository

这两个注解和 MyBatis 的 @MapperScan 和 @Mapper 的关系是一样的，本项目使用的局部。

```java

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.leaf.system.repository")
public class LeafApplication {
    ...
}
```

## 二、持久层

持久层类可以实现两个接口：`JpaRepository<T, O>`, `CrudRepository<T, O>`，开发中任意选择。`JpaRepository`
接口提供的功能更多，有分页、按字段排序等。本项目都使用 `JpaRepository`。

### save() and saveAndFlush()

save()：通常，Hibernate 会在内存中保存可持久化的状态。将该状态同步到底层数据库的过程称为刷新。
当我们使用 `save()` 方法时，除非明确调用 `flush()` 或 `commit()` 方法，否则与保存操作相关的数据不会被刷新到数据库中。
如果我们在不提交的情况下自行刷新数据，那么除非在此事务中调用提交，或者外部事务的隔离级别为 `READ_UNCOMMITTED`
，否则外部事务将无法看到这些更改。

saveAndFlush()：通常，当我们的业务逻辑需要在同一事务的稍后阶段但在提交之前读取 **已保存** 的更改时，我们就可以使用这种方法。

例如，想象一下我们必须执行一个存储过程的场景，该存储过程需要我们保存的实体的一个属性。在这种情况下，save()
方法将不起作用，因为更改并不与数据库同步，存储过程也不知道这些更改。`saveAndFlush()` 方法非常适合这种情况。

## 三、分页(PageRequest、Pageable、Page、PageImpl)

Pageable 是一个分页接口，PageRequest 是它的子类。我们可以使用 PageRequest 提供的几个 `of()` 方法手动构造分页对象，查询时传入此参数实现分页查询和排序。

Page 也是一个接口，PageImpl 是它的实现类，PageImpl 可以构造最终返回的分页列表信息。它的构造方法接收三个参数：结果集，Pageable，总记录数。

```java

@Service
class UserServiceImpl implements UserService {
    /**
     * 第一种分页方法
     * @param page  接收的 Pageable 对象
     * @return 分页数据
     */
    public Page<User> page01(Pageable page) {
        List<User> list = userRepository.findAll();
        return new PageImpl<User>(list, page, list.size());
    }

    /**
     * 第二种分页方法
     * @param page  接收的 Pageable 对象
     * @return 分页数据
     */
    public Page<User> page02(Pageable page) {
        return userRepository.findAll(page);
    }

    /**
     * 手动构造分页对象
     * @return 分页数据
     */
    public Page<User> page03() {
        PageRequest page = PageRequest.of(0, 20);
        return userRepository.findAll(page);
    }

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```
