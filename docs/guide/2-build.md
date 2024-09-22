# 启动项目

本章节写了如何启动项目，但是不会手把手教环境搭建，只会点一下 [Gradle](https://gradle.org/) 的配置。

## 一、后端

:::code-group

```bash [学习或使用]
git clone --depth 1 https://github.com/jhlzlove/leaf.git 
```

```bash [参与完善和开发]
git clone https://github.com/jhlzlove/leaf.git 
```

:::

使用你喜欢的 IDE 打开该项目，修改 `leaf/leaf-system/src/main/resources/application-dev.yml` 配置文件的内容，确保连接信息和自己连接的目标信息一致。

- application-dev.yml：开发环境配置
- application-prod.yml：生产环境配置

如果过程中下载依赖错误，可以尝试以下方式：

1. `./gradlew --refresh-dependencies` 或者 `./gradlew -U`；
2. `./gradlew --stop`，然后删除 `~/.gradle/caches` 目录重新构建项目。如果定义了 `GRADLE_USER_HOME` 则删除该目录中的 **caches** 目录。

## 二、前端

暂时还没有哦~

## 三、代码规范

:::tip
代码规范可以帮助开发人员更好地理解和阅读代码，提高代码的可读性，并降低出现错误的概率。

同时，它还有助于提高代码的可维护性，使得其他开发人员能够轻松地理解和修改代码，而不需要花费大量时间去弄清楚代码的意图和逻辑。

不同的团队会有不同的规范，适合团队的、团队成员共同遵守的就是最好的！
:::

本项目的代码规范如下：

### 注释

真正好的注释是想办法不写注释。所以方法名最好见名知意，内部逻辑保持简单，非常考验程序员的水平。 注释只应该描述有关代码和设计的技术性信息，而不是通篇大论。

> [!NOTE]
> Java 中有自己特殊的注释，可以使用 `javadoc` 命令生成为 JavaDoc API 文档，i think you need read
> it: [https://www.geeksforgeeks.org/comments-in-java/](https://www.geeksforgeeks.org/comments-in-java/)。

### 编码及缩进

一律使用 `UTF-8` 编码和 4 空格缩进。

### 业务函数参数

如果业务中函数的参数有三个以上，全部封装为类入参。

### 代码行长度限制：120

每一行的长度在 120 个字符左右，如果超过必须换行。一般来说，常见的有 80、100、120。

> [!NOTE]
> IDEA 等常用 IDE 中含有分割线提示，非常方便！

### 包装类与基本类型

实体、收参、出参使用包装类，如果要严格控制不可空，还是推荐使用基础类型，尽早的暴露错误，可以编写健壮的代码的同时，也有利于团队的摸鱼和提升工作技能。局部变量尽量使用基础类型。

### 命名

1. 包名全部小写，如果有多个单词连着写，比如：`com.example.deepspace`；
2. 类名遵循 UpperCamelCase 风格；
3. 方法名都遵循 lowerCamelCase 风格；
4. 常量名全部大写，多个单词使用下划线分割；非常量遵循 lowerCamelCase 风格命名；
5. 尽量不要使用拼音命名；

### 全部使用 jsr310 日期

项目强制使用 LocalDate、LocalDateTime 等 java8 之后提供的新式 API。

### CURD

非强制，只是建议，根据实际情况确定是否使用。

| prefix          | meaning     |
|-----------------|-------------|
| add             | 新增          |
| update、up       | 更新          |
| remove、rm       | 逻辑删除(非永久删除) |
| delete、del      | 物理删除(永久删除)  |
| select、find、get | 单记录查询       |
| list            | 多记录/列表查询    |
| page            | 分页查询        |
| import          | 导入          |
| export          | 导出          |
| upload          | 上传          |
| download        | 下载          |
