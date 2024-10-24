# Logback

Logback 的使用较为简单，可以参考官方文档：https://logback.qos.ch/manual/index.html

以下是常见的打印日志的格式：

- `%d{HH:mm:ss.SSS} `– 包含小时、分钟、秒和毫秒的时间戳
- `[%thread]` – 生成日志消息的线程名称，用方括号括起来
- `%-5level` – 日志记录事件的级别，填充为 5 个字符
- `%logger{36}` – 记录器的名称，截断为 35 个字符
- `%msg%n `– 日志消息后跟与平台相关的行分隔符
- `[%method,%line]` - 在哪个方法的第几行调用了日志打印

`logback` 分为三个模块：`logback-core`、`logback-classic` 和 `logback-access`。
其中，core 是核心模块，classic 可以看作是 core 的进阶版本（完整实现了 `slf4j-api`），access 模块与 Servlet 容器集成提供通过
Http 来访问日志；

## 一、Appender

记录器将 LoggingEvents 传递给 Appender。追加者执行日志记录的实际工作。我们通常认为日志记录是进入文件或控制台的东西，但
Logback 的功能远不止于此。Logback-core 提供了几个有用的 appender。

### ConsoleAppender

### FileAppender

FileAppender 将消息追加到文件中。它支持广泛的配置参数。

```xml

<configuration debug="true">
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoders are assigned the type
             ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>tests.log</file>
        <append>true</append>
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>

    <logger name="com.leaf.logback" level="INFO"/>
    <logger name="com.leaf.logback.tests" level="WARN">
        <appender-ref ref="FILE"/>
    </logger>

    <root level="debug">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

FileAppender 通过 `<file>` 配置文件名。`<append>` 标签指示 Appender 添加到现有文件，而不是截断文件。如果我们多次运行测试，就会发现日志输出被追加到同一个文件中。

如果我们重新运行上面的测试，`com.leaf.logback.tests` 的消息将同时输出到控制台和 `tests.log` 的文件。子日志记录器（logger）同时继承根日志记录器
ConsoleAppender 与 FileAppender 的配置。Appenders 的效果是累加的。

### RollingFileAppender（常用）

通常情况下，我们希望根据时间、日志文件大小或两者的组合来 "滚动 "文件。

```xml logback.xml

<configuration>
    <property name="LOG_FILE" value="LogFile"/>
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_FILE}.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.gz</fileNamePattern>

            <!-- keep 30 days' worth of history capped at 3GB total size -->
            <maxHistory>30</maxHistory>
            <totalSizeCap>3GB</totalSizeCap>
        </rollingPolicy>
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>
</configuration>
```

RollingFileAppender 有一个 RollingPolicy（滚动策略）。在此示例配置中，是基于时间的滚动策略（TimeBasedRollingPolicy）。

与 FileAppender 类似，我们在配置该应用程序时也使用了 `file`。我们声明了一个属性并使用了它，因为我们将在后面中重复使用此文件名。

我们在 RollingPolicy 中定义了
fileNamePattern。该模式不仅定义了文件名，还定义了滚动文件的频率。基于时间的滚动策略（TimeBasedRollingPolicy）会检查该模式，并在最精确定义的时间段进行滚动。

:::tip
官网 Policy 说明：https://logback.qos.ch/manual/appenders.html#onRollingPolicies
:::

### 自定义 Appender

参考该文章：https://www.baeldung.com/custom-logback-appender

## 二、常见的日志级别

1. **OFF**：
   最高等级，关闭所有日志记录。如果将日志级别设置为此级别，那么不会有任何日志消息被记录。

2. **FATAL** / **CRITICAL** / **EMERGENCY**：
   表示非常严重的错误，可能导致应用程序崩溃或无法继续运行。

3. **ERROR** / **SEVERE**：
   表示发生了错误，但应用程序仍能继续运行。这类消息通常用于记录异常和其他非预期行为。

4. **WARN** / **WARNING**：
   表示潜在的问题，可能不会立即影响应用程序，但值得引起注意。

5. **INFO**：
   提供一般性的信息，如服务启动、停止、状态变化等。这些消息对了解应用程序的整体行为有所帮助。

6. **DEBUG**：
   提供详细的调试信息，主要用于开发过程中排查问题。在生产环境中，通常只有在诊断故障时才会启用此级别。

7. **TRACE**：
   提供非常详细的跟踪信息，通常只在分析极复杂的问题时使用。记录的信息可能包括大量的堆栈跟踪和其他详细的技术数据。

8. **ALL**：
   最低等级，记录所有级别的日志消息。通常只在开发期间用于全面监控应用程序的行为。

以上日志级别并非所有日志框架都会完全支持，某些框架可能会使用略有差异的命名习惯。

## 3. 根据不同的操作系统使用不同的路径存放日志

```java com.leaf.config.LogbackHomeConfig.java
public class LogbackHomeConfig extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        // 获取用户名
        String username = System.getProperty("user.name");
        // 获取操作系统
        String os = System.getProperty("os.name");
        // 路径常量可以放到常量类维护，这里说明问题即可（目录放在jar包的同级目录）
        return os.toLowerCase().contains("window") ? "./logs" : "/home/" + username + "/logs";
    }
}
```

然后在 `logback.xml` 中配置一个属性，在后面具体的日志中使用 `${log.path}` 引用即可

```xml logback.xml

<define name="log.path" class="com.leaf.config.LogbackHomeConfig"/>
```

> 关于 slf4 和 Java 中的其它日志框架的关系，引用 [Rust 语言圣经](https://course.rs/logs/log.html) 里的一段话：
>
> slf4j 是 Java 的日志门面库，日志门面不是说排场很大的意思，而是指相应的日志 API
> 已成为事实上的标准，会被其它日志框架所使用。通过这种统一的门面，开发者就可以不必再拘泥于日志框架的选择，未来大不了再换一个日志框架就是。

## Log4j2

```xml
<property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} %highlight{%-5level}{ERROR=Bright RED, WARN=Bright Yellow, INFO=Bright Green, DEBUG=Bright Cyan, TRACE=Bright White} %style{ [%t] %c{1.}-%M:%L}{black}: %msg%n"/>
```
