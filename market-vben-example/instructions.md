# instructions

## Feature

## TODO

* [ ] 生成jwt
* [ ] 登录验证码
* [ ] 加入redis缓存

## 说明

### 1. 数据库

- 确定互斥的逻辑使用 `bit` 类型，选取 `1` 为 `是/确定`，选取 `0` 为 `否/否定`。例如：逻辑删除标识字段 `del_flag`：
  `1` 为删除，`0` 为未删除;再如启用标识字段 `enabled`: `1` 为启用，`0` 为未启用。
  使用 `bit` 时，在 SQL 语句中对应的字段可以写 true/false，数据库会自动转为 1/0。

  如果 使用bit(M) M>1 来表示数据，数据大小不仅可以表示0或1，也可以表示大于1的数，映射到Java的数据类型Boolean时，
  0对应为false，非0的数据都将映射为true。

### 2. 注入方式

项目使用构造注入，该方法可能会造成代码冗余过多的情况。从 Spring4.3 之后，如果一个类中只有一个构造函数，那么 Spring
根据构造函数自动注入。所以在 `xxxServiceImpl` 里看到以下信息不要惊讶。

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private final DemoDao demoDao;

    // 这里的注解可加可不加
    @Autowired
    public DemoServiceImpl(DemoDao demoDao) {
        this.demoDao = demoDao;
    }
}
```

