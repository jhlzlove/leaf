# 关于 Quarkus

为什么要迁移到 Quarkus 呢？个人玩具其实没有什么好说的。非要说的话，国内网上有很多对比的、推荐的、谩骂的文章博客，除了自己玩玩，都是属于叫好不叫座的。

不出意外的话，本文应该会把所有本项目使用 Quarkus 的相关问题都放在这里。

## 注解

```java
// JAX-RS 请求注解
@GET
@POST
@PUT
@DELETE

// controller 访问路径，即 web api 访问路径
@Path("/")
```
