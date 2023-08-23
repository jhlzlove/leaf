## Jackson

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

### @JsonView

可以在已经存在的实体的属性中选择性的创建返回的对象视图。
