# Jackson

## 注解

### @JsonProperty

序列化、反序列化时都使用该注解指定的值，只能指定一个。

### @JsonAlias

只有 **反序列化** 时读取里面定义的值，可定义多个，jackson 负责读取并把把该值赋给实际的变量名称。

:::tip
上面两个结合场景很好理解，对于我们定义的实体，调用其他系统（尚在开发，不稳定）返回的结果字段后期可能会改变，但是我们希望使用该实体接收并正确解析，使用 `@JsonAlias`
定义其它系统字段即可，实体无需修改。
:::

### @JsonView

使用该字段创建视图，使用在 controller 类上，控制返回的字段，可以在已经存在的实体的属性中选择性的创建返回的对象视图。类似于
DTO、VO，不用在自己不用创建实体了，框架会把未使用该注解的字段过滤后然后返回给客户端。

不过注意，使用该注解时，返回的结果只能返回该 **对象** 或者 **该对象的集合**
；如果在外层使用自定义包装的形式，那么会直接返回一个空值 `{}`。

比如我们一般自定义返回结果类的时候，可以使用以下方法，加入项目自定义封装的类为 Result：

```java

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
}

record User(
        @JsonView(Views.NameAndAge.class) String name,
        @JsonView(Views.NameAndAge.class) Integer age,
        LocalDateTime bir) {
}

interface Views {
    class NameAndAge {
    }
}


@RestController
class WebController {

    @GetMapping("user")
    @JsonView(Views.NameAndAge.class)
    public Result getNameAndAge() {
        List<User> users = List.of(
                new User("jhlz", 20, LocalDateTime.now()),
                new User("john", 21, LocalDateTime.now()),
                new User("yo", 22, LocalDateTime.now()),
                new User("me", 23, LocalDateTime.now()),
                new User("girl", 24, LocalDateTime.now())
        );
        return new Result("成功！", 200, users);
    }
}

record Result(
        @JsonView(Object.class) String msg,
        @JsonView(Object.class) int code,
        @JsonView(Object.class) Object data) {

}

```

这样就返回的结果就正常了。

### @Valid @Validated

- @Valid 是 jakarta 包下的，而 @Validated 是 Spring 提供的；
- @Valid 不支持分组验证，@Validated 支持，@Validated 是 @Valid 的扩展；
- @Valid 使用在对象属性中，可以递归校验对象属性是否符合要求；

```java
public class Subject {
    @NotEmpty(message = "学科名称不能为空")
    private String teacherName;
    @Min(value = 1, message = "学科类型从1开始计算")
    private int type;
}

public class StudentBean implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String name;
    @Email(message = "邮箱格式错误")
    private String email;

    // 加入该注解才会验证 Subject 里面的内容，否则只验证 NotNull Size
    @Valid
    @NotNull(message = "所学科目不能为空")
    @Size(min = 1, message = "至少学习一个科目")
    private List<Subject> subjectList;
}
```

