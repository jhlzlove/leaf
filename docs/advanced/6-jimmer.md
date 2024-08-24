# Jimmer

## 一、为什么切换到 Jimmer？

higher faster stronger

## 二、[Jimmer官方文档](https://babyfish-ct.github.io/jimmer-doc)

https://babyfish-ct.github.io/jimmer-doc

使用 Jimmer 后，repository 基本没有存在的必要。因此本项目不做保留。

## 三、一些说明

### 注解

大部分和 JPA 一样或类似。

#### @Key

类似联合索引，被 `@Key` 修饰的字段在新增时如果数据库已经存在，那么不会新增，而是会修改。

#### @EnableImplicitApi、@FetchBy、@DefaultFetcherOwner、@Api、@ApiIgnore

启动客户端能力的注解，自动为前端生成结构化代码。目前只支持 Spring。

- **@EnableImplicitApi**：启用客户端能力，使用此注解才会生效
- **@FetchBy**：声明抓取的自定义 Fetcher 形状，该形状默认需要在当前类中，若不在当前类，需要指明 `ownerType` 属性
- **@DefaultFetcherOwner**：条件如上，若定义的 Fetcher 形状不在当前类中，并且该类使用的 Fetcher
  形状都归于另一个类，可以在类上面使用此注解为当前类全部指定
- **@Api、@ApiIgnore**：这就很简单了，控制接口的分组和是否显示在接口文档中

示例：

```kotlin Fetrcher.kt
class Fetchers {
    /**
     * 定义自己需要的一个查询形状
     */
    companion object {
        val STUDENT_FETCHER = newFetcher(Student::class).by {
            fullName()
            gender()
            courseIds {
                courseName()
            }
        }
    }
}
```

```kotlin StudentController.kt
@RestController
@RequestMapping("/student")
// 如果此处不使用该注解，下面的 @FetchBy(ownerType = class) 必须指明 STUDENT_FETCHER 在哪个类中
// 如果该类中的多个接口查询的 Fetcher 在一个类中，使用该注解非常方便
// @DefaultFetcherOwner(Fetchers::class)
class StudentController(val studentService: StudentService) {

    @GetMapping("/page")
    fun getAllStudentFetchBy(
        @RequestParam pageIndex: Int,
        @RequestParam pageSize: Int
    ): Page<@FetchBy(value = "STUDENT_FETCHER", ownerType = Fetcher::class) Student> {
        return studentService.getAllStudentFetchBy(pageIndex, pageSize)
    }

    ...
}
```

#### @IdView

查询非表中数据字段集合，与实体无关。

