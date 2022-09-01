# instructions

代码功能以及风格的一些说明

## Feature

## TODO

* [ ] 生成jwt
* [ ] 登录验证码
* [ ] 加入redis缓存

## 说明

### 1. 数据库

- 确定互斥的逻辑使用 `bit` 类型，该类型有如下特征：`> 0 ? true : false`，所以在实体中使用 `boolean` 与之对应，在 SQL
  语句操作时，bit 类型的属性可以用 `true/false` 赋值，数据库会自动转为 `1/0`。例如：逻辑删除标识字段 `del_flag`：
  `1` 为删除(true)，`0` 为未删除(false);再如启用标识字段 `enabled`: `1` 为启用，`0` 为未启用。

  如果 使用 `bit(M) M>1` 来表示数据，数据大小不仅可以表示 0 或 1，也可以表示大于 1 的数，映射到 Java 的数据类型 Boolean 时，
  0对应为false，非0的数据都将映射为true。

### 2. 注入方式

项目使用构造注入，该方法可能会造成代码冗余过多的情况。从 Spring4.3 之后，如果一个类中只有一个构造函数，那么 Spring
根据构造函数自动注入。所以在 `xxxServiceImpl` 里看到以下信息不要惊讶。

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    // ...业务逻辑

    private final DemoDao demoDao;

    // 这里的注解可加可不加
    @Autowired
    public DemoServiceImpl(DemoDao demoDao) {
        this.demoDao = demoDao;
    }
}
```

为了看代码比较方便，类中所有需要注入的对象全部放在该类的最后。

### 项目结构

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
