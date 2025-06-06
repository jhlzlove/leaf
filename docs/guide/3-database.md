# 数据库结构

:::tip

- 数据库的时间字段使用不带时区的 timestamp 类型(
  如果程序需要支持多个不同时区的国家，强烈推荐使用带时区的时间类型，本系统不需要，还没有国际业务)。
- 本项目全部采用 **物理删除** 的模式，毕竟人生总要做好断舍离。
- 记录状态采用数字表示表示法：0 代表正常、启用、未删除、显示等，1 为异常、禁用、已删除、不显示等情况。且默认值统一为 0 正常。
- 使用 PG 的 `serial` 要做好序列不连续（序列断裂）的准备：使用该类自增方式，在事务出现回滚等异常情况时，当前的序列号不会回滚，直接使用下一个 id，这样数据库的处理效率高。因此一般在自增情况下更加推荐使用 `bigserial`（等同于 `serial8`）类型。
- 本框架全部使用外键。
- http://dbadailystuff.com/deferred-constraints-in-postgresql
- https://www.roji.org/storing-timezones-in-the-db
- https://codeblog.jonskeet.uk/2019/03/27/storing-utc-is-not-a-silver-bullet/

:::

## 一、 表字段

### 1.1 通用字段

除关联表以外的其它信息表 **基本** 都含有这几个字段（视具体情况而定，有些表只需创建人和创建时间）。

| 名称   | 数据库字段       | 数据库类型      | 是否可空 | Java字段     | Java类型        | 说明    |
|------|-------------|------------|------|------------|---------------|-------|
| ID   | id          | serial8    | N    | id         | long          | 主键 id |
| 创建者  | create_id   | int8       | N    | createId   | Long          |       |
| 更新者  | update_id   | int8       | N    | updateId   | Long          |       |
| 创建时间 | create_time | timestampz | N    | createTime | LocalDateTime |       |
| 更新时间 | update_time | timestampz | N    | updateTime | LocalDateTime |       |
| 备注   | remark      | varchar    | Y    | remark     | String        |       |

### 1.2 用户表（leaf_user）

| 名称     | 数据库字段          | 数据库类型    | 是否可空 | Java字段       | Java类型  | 说明                      |
|--------|----------------|----------|------|--------------|---------|-------------------------|
| 账号     | username       | varchar  | N    | username     | String  |                         |
| 密码     | password       | varchar  | N    | password     | String  |                         |
| 昵称     | nick_name      | varchar  | N    | nickName     | String  | 用户昵称                    |
| 手机号    | phone          | char(11) | Y    | phone        | String  | 绑定手机号                   |
| 邮箱     | email          | varchar  | Y    | email        | String  | 绑定邮箱                    |
| 头像地址   | avatar         | varchar  | N    | avatar       | String  | 图片地址                    |
| 状态     | status         | int2     | N    | status       | Integer | 状态：0正常，1禁用              |
| 部门id   | dept_id        | int8     | N    | deptId       | Long    | 外键，leaf_dept 表主键        |
| 用户信息id | user_detail_id | int8     | Y    | userDetailId | Long    | 外键，leaf_user_detail 表主键 |

### 1.3 用户信息表（leaf_user_detail）

| 名称   | 数据库字段      | 数据库类型   | 是否可空 | Java字段    | Java类型  | 说明                      |
|------|------------|---------|------|-----------|---------|-------------------------|
| 姓氏   | first_name | varchar | N    | firstName | String  |                         |
| 名称   | last_name  | varchar | N    | lastName  | String  |                         |
| 民族   | ethnic     | varchar | N    | ethnic    | String  | 民族                      |
| 性别   | gender     | varchar | N    | gender    | String  | SECRECY保密，FEMALE女，MALE男 |
| 年龄   | age        | int2    | N    | age       | Integer | 人生七十古来稀                 |
| 住址   | address    | varchar | N    | address   | String  | 现住址                     |
| 故乡   | hometown   | varchar | N    | hometown  | String  |                         |
| 身份证号 | id_card    | varchar | N    | idCard    | String  |                         |

### 1.4 角色表（leaf_role）

| 名称   | 数据库字段     | 数据库类型   | 是否可空 | Java字段   | Java类型  | 说明         |
|------|-----------|---------|------|----------|---------|------------|
| 角色名称 | role_name | varchar | N    | roleName | String  |            |
| 角色编码 | role_code | varchar | N    | roleCode | String  |            |
| 状态   | status    | int2    | N    | status   | Integer | 状态：0正常，1禁用 |
| 排序   | sortable  | int2    | N    | sortable | Integer |            |

### 1.5 部门表（leaf_dept）

| 名称      | 数据库字段       | 数据库类型   | 是否可空 | 实体字段        | 实体类型    | 说明         |
|---------|-------------|---------|------|-------------|---------|------------|
| 部门名称    | dept_name   | varchar | N    | deptName    | String  |            |
| 父级部门id  | parent_id   | int8    | Y    | parent_Id   | Long    |            |
| 祖级列表    | ancestors   | varchar | N    | ancestors   | String  | json 数组    |
| 部门负责人id | leader_id   | int8    | N    | leaderId    | Long    |            |
| 状态      | status      | int2    | N    | status      | Integer | 状态：0正常，1禁用 |
| 排序      | sortable    | int2    | N    | sortable    | Integer |            |

### 1.6 菜单表（leaf_menu)

| 名称     | 数据库字段          | 数据库类型   | 是否可空 | 实体字段          | 实体类型    | 说明               |
|--------|----------------|---------|------|---------------|---------|------------------|
| 菜单名称   | menu_name      | varchar | Y    | menuName      | String  |                  |
| 父级菜单id | parent_id      | int8    | Y    | parentId      | Long    |                  |
| 菜单类型   | menu_type      | int2    | N    | menuType      | Integer | 菜单类型：1目录，2菜单，3按钮 |
| 权限字符   | permission     | varchar | N    | permission    | String  |                  |
| 路由路径   | route_path     | varchar | N    | routePath     | String  |                  |
| 组件路径   | component_path | varchar | N    | componentPath | String  |                  |
| 组件名称   | component_name | varchar | N    | componentName | String  |                  |
| 图标     | icon           | varchar | N    | icon          | String  |                  |
| 是否外链   | is_external    | int2    | N    | isExternal    | Integer | 0外链，1非外链         |
| 是否隐藏   | is_hidden      | int2    | N    | isHidden      | Integer | 0显示，1隐藏          |
| 状态     | status         | int2    | N    | status        | Integer | 状态：0正常，1禁用       |
| 显示顺序   | sortable       | int2    | N    | sortable      | Integer | 菜单显示顺序，默认 1      |

### 1.7 字典表（leaf_dict）

| 名称   | 数据库字段     | 数据库类型   | 是否可空 | 实体字段      | 实体类型    | 说明         |
|------|-----------|---------|------|-----------|---------|------------|
| 字典类型 | dict_type | varchar | N    | dictKey   | String  |            |
| 类型名称 | dict_name | varchar | N    | dictValue | String  |            |
| 状态   | status    | int2    | N    | status    | Integer | 状态：0正常，1禁用 |
| 排序   | sortable  | int2    | N    | sortable  | Integer | 默认1        |

### 1.8 字典属性表(leaf_dict_item)

| 名称    | 数据库字段      | 数据库类型   | 是否可空 | 实体字段      | 实体类型    | 说明         |
|-------|------------|---------|------|-----------|---------|------------|
| 字典键   | item_key   | varchar | N    | itemKey   | String  |            |
| 字典值   | item_value | varchar | N    | itemValue | String  |            |
| 字典表主键 | dict_id    | int8    | N    | dictType  | Long    |            |
| 排序    | sortable   | int2    | N    | sortable  | Integer | 默认1        |
| 状态    | status     | int2    | N    | status    | Integer | 状态：0正常，1禁用 |

### 1.9 用户-角色关联表（leaf_user_role）

| 名称   | 数据库字段   | 数据库类型 | 是否可空 | Java字段 | Java类型 | 说明 |
|------|---------|-------|------|--------|--------|----|
| 用户ID | user_id | int8  | N    | userId | Long   |    |
| 角色ID | role_id | int8  | N    | roleId | Long   |    |

### 1.10 菜单-角色关联表（leaf_menu_role）

| 名称   | 数据库字段   | 数据库类型 | 是否可空 | 实体字段   | 实体类型 | 说明 |
|------|---------|-------|------|--------|------|----|
| 角色id | role_id | int8  | N    | roleId | Long |    |
| 菜单id | menu_id | int8  | N    | menuId | Long |    |

## 二、PG

### pg_dump

windows 中使用 `pg_dump --help` 将会打印以下内容：

```bash
pg_dump 把一个数据库转储为纯文本文件或者是其它格式.

使用方法:                                          
pg_dump [选项]... [数据库名字]

一般选项:
-f, --file=FILENAME          输出文件或目录名
-F, --format=c|d|t|p         输出文件格式 (定制, 目录, tar, 明文 (默认值))
-j, --jobs=NUM               执行多个并行任务进行备份转储工作
-v, --verbose                详细模式
-V, --version                输出版本信息, 然后退出
-Z, --compress=METHOD[:DETAIL]
compress as specified
--lock-wait-timeout=TIMEOUT  在等待表锁超时后操作失败
--no-sync                    不用等待变化安全写入磁盘
-?, --help                   显示此帮助, 然后退出

控制输出内容选项:
-a, --data-only              只转储数据,不包括模式
-b, --large-objects          include large objects in dump
--blobs                      (same as --large-objects, deprecated)
-B, --no-large-objects       exclude large objects in dump
--no-blobs                   (same as --no-large-objects, deprecated)
-c, --clean                  在重新创建之前，先清除（删除）数据库对象
-C, --create                 在转储中包括命令,以便创建数据库
-e, --extension=PATTERN      仅转储指定的扩展名
-E, --encoding=ENCODING      转储以ENCODING形式编码的数据
-n, --schema=PATTERN         只转储指定的模式
-N, --exclude-schema=PATTERN 不转储指定的模式
-O, --no-owner               在明文格式中, 忽略恢复对象所属者
-s, --schema-only            只转储模式, 不包括数据
-S, --superuser=NAME         在明文格式中使用指定的超级用户名
-t, --table=PATTERN          dump only the specified table(s)
-T, --exclude-table=PATTERN  不转储指定的表
-x, --no-privileges          不要转储权限 (grant/revoke)
--binary-upgrade             只能由升级工具使用
--column-inserts             以带有列名的INSERT命令形式转储数据
--disable-dollar-quoting     取消美元 (符号) 引号, 使用 SQL 标准引号
--disable-triggers           在只恢复数据的过程中禁用触发器
--enable-row-security        启用行安全性（只转储用户能够访问的内容）
--exclude-table-and-children=PATTERN
do NOT dump the specified table(s), including
child and partition tables
--exclude-table-data=PATTERN 不转储指定的表中的数据
--exclude-table-data-and-children=PATTERN
do NOT dump data for the specified table(s),
including child and partition tables
--extra-float-digits=NUM     覆盖extra_float_digits的默认设置
--if-exists                  当删除对象时使用IF EXISTS
--include-foreign-data=PATTERN
包含外部服务器上与模式匹配的
外部表的数据
--inserts                    以INSERT命令，而不是COPY命令的形式转储数据
--load-via-partition-root    通过根表加载分区
--no-comments                不转储注释
--no-publications            不转储发布
--no-security-labels         不转储安全标签的分配
--no-subscriptions           不转储订阅
--no-table-access-method     do not dump table access methods
--no-tablespaces             不转储表空间分配信息
--no-toast-compression       不转储TOAST压缩方法
--no-unlogged-table-data     不转储没有日志的表数据
--on-conflict-do-nothing     将ON CONFLICT DO NOTHING添加到INSERT命令
--quote-all-identifiers      所有标识符加引号，即使不是关键字
--rows-per-insert=NROWS      每个插入的行数；意味着--inserts
--section=SECTION            备份命名的节 (数据前, 数据, 及 数据后)
--serializable-deferrable    等到备份可以无异常运行
--snapshot=SNAPSHOT          为转储使用给定的快照
--strict-names               要求每个表和(或)schema包括模式以匹配至少一个实体
--table-and-children=PATTERN dump only the specified table(s), including
child and partition tables
--use-set-session-authorization
使用 SESSION AUTHORIZATION 命令代替
ALTER OWNER 命令来设置所有权

联接选项:
-d, --dbname=DBNAME      对数据库 DBNAME备份
-h, --host=主机名        数据库服务器的主机名或套接字目录
-p, --port=端口号        数据库服务器的端口号
-U, --username=名字      以指定的数据库用户联接
-w, --no-password        永远不提示输入口令
-W, --password           强制口令提示 (自动)
--role=ROLENAME          在转储前运行SET ROLE

如果没有提供数据库名字, 那么使用 PGDATABASE 环境变量的数值.

臭虫报告至<pgsql-bugs@lists.postgresql.org>.
PostgreSQL 主页: <https://www.postgresql.org/>
```

使用 pg_dump 导出 `leaf_main` 的数据库备份（不含建库命令，恢复备份时，在执行脚本之前需要确保 `leaf_main` 数据库已经存在）:

```bash
pg_dump -h 127.0.0.1 -p 5432 -U postgres -d leaf_main -c -F p -f backup.sql
```

当然，如果想要 **包含创建数据库** 命令的脚本也是可以的（只需加上 `-C` 选项）：

```bash
pg_dump -h 127.0.0.1 -p 5432 -U postgres -d leaf_main -C -c -F p -f backup.sql
```

### SERIAL、SERIAL8

- SERIAL：相当于 SERIAL4
- SERIAL8：相当于 BIGSERIAL

两者都创建一个整数列，serial 是自增的，而 int、int8 只是整数列，并不会自增。

SERIAL 列是序列号。server 会记录前一个值（前一个最大值），每次请求一个值时，该值都会递增。无论 id 是否被永久保存，这种递增都会发生。如果获取 id 的事务回滚，那么 id 就会 "丢失"，SERIAL 中就会出现 “漏洞”（例如，未使用 id 的间隙）。如果你只是将它们作为唯一 ID 使用，那么有空隙也不会有什么问题。

PG 这样实现序列是为了提高效率。server 只需跟踪一个值（先前的最大值）即可唯一生成 id，它可以在多个连接中缓存这些 id，以加快序列生成速度，而且通过允许间隙，服务器在生成序列时无需事务锁定序列对象。这使得它们非常高效，并发性也很高。
