# 数据库结构

:::tip

- id 为预留字段，可以根据不同业务需要采用不同的 id 生成算法。
- 数据库的时间字段使用不带时区的 timestamp 类型(如果程序需要支持多个不同时区的国家，强烈推荐使用带时区的时间类型)。
- PostgreSQL 如果没有设置主键，那么会默认以 `id` 、类型为整数（integer）的列作为主键，该字段并不显示。
- 本项目全部采用物理删除的模式，删除要彻底，就像人生要做好断舍离。
- 使用 PG 的 `serial` 要做好序列不连续（序列断裂）的准备，使用这种自增很容易出现这种情况（更新、删除、事务回滚等）。

:::

## 一、 表字段

### 1.1 通用字段

除关联表以外的其它表基本都含有这几个字段，不过也应视具体情况而定。

| 名称   | 数据库字段       | 数据库类型     | Java字段     | Java类型        | 说明 |
|------|-------------|-----------|------------|---------------|----|
| 创建者  | create_by   | varchar   | createBy   | String        |    |
| 更新者  | update_by   | varchar   | updateBy   | String        |    |
| 创建时间 | create_time | timestamp | createTime | LocalDateTime |    |
| 更新时间 | update_time | timestamp | updateTime | LocalDateTime |    |
| 备注   | remark      | varchar   | remark     | String        |    |

### 1.2 用户登录信息表（leaf_user）

| 名称       | 数据库字段           | 数据库类型     | Java字段        | Java类型        | 说明         |
|----------|-----------------|-----------|---------------|---------------|------------|
| userID   | user_id         | serial8   | userId        | Long          |            |
| 账号       | username        | varchar   | username      | String        |            |
| 密码       | password        | varchar   | password      | String        |            |
| 昵称       | nick_name       | varchar   | nickName      | String        | 用户昵称       |
| 手机号      | phone           | char      | phone         | String        | 绑定手机号      |
| 邮箱       | email           | varchar   | email         | String        | 绑定邮箱       |
| 头像地址     | avatar          | varchar   | avatar        | String        | 图片地址       |
| 状态       | status          | int2      | status        | Integer       | 状态：1正常，0禁用 |
| 最后一次登录时间 | last_login_time | timestamp | lastLoginTime | LocalDateTime |            |
| 用户信息id   | user_detail_id  | int8      | userDetailId  | Long          | 用户信息 ID    |

### 1.3 用户信息详情表（leaf_user_detail）

| 名称             | 数据库字段          | 数据库类型   | Java字段       | Java类型  | 说明                         |
|----------------|----------------|---------|--------------|---------|----------------------------|
| user_detail_id | user_detail_id | serial8 | userDetailId | Long    |                            |
| 部门id           | dept_id        | int8    | deptId       | Long    |                            |
| 岗位id           | post_id        | int8    | postId       | Long    |                            |
| 姓氏             | first_name     | varchar | firstName    | String  |                            |
| 名称             | last_name      | varchar | lastName     | String  |                            |
| 民族             | ethnic         | varchar | ethnic       | String  | 民族                         |
| 性别             | gender         | varchar | gender       | String  | secrecy 保密，FEMALE 女，MALE 男 |
| 年龄             | age            | int2    | age          | Integer | 人生七十古来稀                    |
| 住址             | address        | varchar | address      | String  | 现住址                        |
| 故乡             | hometown       | varchar | hometown     | String  |                            |
| 身份证号           | id_card        | varchar | idCard       | String  |                            |

### 1.4 角色表（leaf_role）

| 名称     | 数据库字段     | 数据库类型   | Java字段   | Java类型  | 说明      |
|--------|-----------|---------|----------|---------|---------|
| roleID | role_id   | serial8 | roleId   | Long    |         |
| 角色名称   | role_name | varchar | roleName | String  |         |
| 角色编码   | role_code | varchar | roleCode | String  |         |
| 状态     | status    | int2    | status   | Integer | 1正常，0禁用 |

### 1.5 用户-角色关联表（leaf_user_role）

| 名称   | 数据库字段   | 数据库类型 | Java字段 | Java类型 | 说明 |
|------|---------|-------|--------|--------|----|
| 用户ID | user_id | int8  | userId | Long   |    |
| 角色ID | role_id | int8  | roleId | Long   |    |

### 1.6 部门表（leaf_dept）

| 名称      | 数据库字段       | 数据库类型   | 实体字段        | 实体类型    | 说明      |
|---------|-------------|---------|-------------|---------|---------|
| deptID  | dept_id     | serial8 | deptId      | Long    |         |
| 父级部门id  | parent_id   | int8    | parent_Id   | Long    |         |
| 部门编码    | dept_code   | varchar | deptCode    | String  |         |
| 部门名称    | dept_name   | varchar | deptName    | String  |         |
| 部门负责人id | leader_id   | int8    | leaderId    | Long    |         |
| 部门描述    | description | varchar | description | String  |         |
| 状态      | status      | int2    | status      | Integer | 1正常，0禁用 |
| 角色ID    | role_id     | int8    | roleId      | Long    |         |

### 1.7 角色-菜单关联表（leaf_menu_role）

| 名称   | 数据库字段   | 数据库类型 | 实体字段   | 实体类型 | 说明 |
|------|---------|-------|--------|------|----|
| 角色id | role_id | int8  | roleId | Long |    |
| 菜单id | menu_id | int8  | menuId | Long |    |

### 1.8 菜单表（leaf_menu)

| 名称     | 数据库字段      | 数据库类型   | 实体字段       | 实体类型    | 说明               |
|--------|------------|---------|------------|---------|------------------|
| menuID | menu_id    | serial8 | menuId     | Long    |                  |
| 菜单名称   | menu_name  | varchar | menuName   | String  |                  |
| 菜单类型   | menu_type  | varchar | menuType   | String  | 菜单类型：D目录，M菜单，B按钮 |
| 父级菜单id | parent_id  | int8    | parentId   | Long    |                  |
| 显示顺序   | sortable   | int2    | orderNum   | Integer | 菜单显示顺序           |
| 权限字符   | permission | varchar | permission | String  |                  |
| 状态     | status     | int2    | status     | Integer | 1正常，0停用          |

### 1.9 字典类型表（leaf_dict）

| 名称     | 数据库字段     | 数据库类型   | 实体字段     | 实体类型    | 说明      |
|--------|-----------|---------|----------|---------|---------|
| dictID | dict_id   | serial8 | dictId   | Long    |         |
| 字典类型   | dict_type | varchar | dictType | String  |         |
| 字典类型名称 | dict_name | varchar | dictName | String  |         |
| 状态     | status    | int2    | status   | Integer | 1正常，0禁用 |

### 1.10 字典详情表(leaf_dict_item)

| 名称     | 数据库字段      | 数据库类型   | 实体字段      | 实体类型    | 说明      |
|--------|------------|---------|-----------|---------|---------|
| dictID | dict_id    | serial8 | dictId    | Long    |         |
| 字典键    | dict_key   | varchar | dictKey   | String  |         |
| 字典值    | dict_value | varchar | dictValue | String  |         |
| 字典类型   | dict_type  | varchar | dictType  | String  |         |
| 状态     | status     | int2    | status    | Integer | 1正常，0禁用 |

### 1.11 岗位表（leaf_post）

| 名称     | 数据库字段     | 数据库类型   | 实体字段     | 实体类型   | 说明 |
|--------|-----------|---------|----------|--------|----|
| postId | post_id   | serial8 | postId   | Long   |    |
| 岗位编码   | post_code | varchar | postCode | String |    |
| 岗位名称   | post_name | varchar | postName | String |    |
| 所属部门ID | dept_id   | int8    | deptId   | Long   |    |

### 1.12 用户-岗位关联表（leaf_user_post）

| 名称   | 数据库字段   | 数据库类型 | 实体字段   | 实体类型 | 说明 |
|------|---------|-------|--------|------|----|
| 岗位ID | post_id | int8  | postId | Long |    |
| 用户ID | user_id | int8  | userId | Long |    |

### 1.13 用户-部门关联表

| 名称   | 数据库字段   | 数据库类型 | 实体字段   | 实体类型 | 说明 |
|------|---------|-------|--------|------|----|
| 部门ID | dept_id | int8  | deptId | Long |    |
| 用户ID | user_id | int8  | userId | Long |    |

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

如果没有提供数据库名字, 那么使用 PGDATABASE 环境变量
的数值.

臭虫报告至<pgsql-bugs@lists.postgresql.org>.
PostgreSQL 主页: <https://www.postgresql.org/>
```

使用 pg_dump 导出 `leaf_main` 的数据库备份（不含建库命令，恢复备份时，在执行脚本之前需要确保 `leaf_main`
数据库已经存在）:

```bash
pg_dump -h 127.0.0.1 -p 5432 -U postgres -d leaf_main -c -F p -f backup.sql
```

当然，如果你想要包含创建数据库的脚本也是可以的（只需加上 `-C` 选项）：

```bash
pg_dump -h 127.0.0.1 -p 5432 -U postgres -d leaf_main -C -c -F p -f backup.sql
```

### SERIAL、serial8

SERIAL：相当于 SERIAL4
serial8：相当于 SERIAL8（bigint）

两者都创建一个整数列。

SERIAL 列是序列号。server 会记录前一个值（前一个最大值），每次请求一个值时，该值都会递增。无论 id 是否被永久保存，这种递增都会发生。如果获取
id 的事务回滚，那么 id 就会 "丢失"，SERIAL 中就会出现“漏洞”（例如，未使用 id 的间隙）。这并没有什么问题，如果你只是将它们作为唯一
ID 使用，那么有空隙也不会有什么问题。

这样实现序列是为了提高效率。server 只需跟踪一个值（先前的最大值）即可唯一生成 id，它可以在多个连接中缓存这些
id，以加快序列生成速度，而且通过允许间隙，服务器在生成序列时无需事务锁定序列对象。这使得它们非常高效，并发性也很高。
