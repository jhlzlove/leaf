## spring-boot3.0

命名空间 javax -> jakarta 的改变
在Jakarta EE 9中，无论您在哪里接触Servlet API，JPA，Bean Validation等，都会发现这个改变.

Jakarta EE 9是一个新的顶级包，取代了 Java EE 中的 javax 顶级包。例如，JakartaEE8 中的 Servlet 规范使用 `javax.servlet`
包，但在EE9中已更改为 `jakarta.servlet`。
一般来说，不可能在同一个项目中混合使用 Java EE 和 Jakarta EE API。您需要确保您自己的代码以及所有第三方库都使用 `jakarta.*`
包导入。
好消息是，大多数维护良好的库都在生成Jakarta EE 9兼容的变体。例如 Hibernate、Thymeleaf、Tomcat、Jetty 和 Undertow 都已经这样做了。
