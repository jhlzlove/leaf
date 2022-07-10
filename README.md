## 平台简介

该项目基于若依快速开发平台构建，可以在 [若依官网](http://www.ruoyi.vip) 详细了解。

## 功能开发中

1. [x] 商品管理
2. [x] 客户管理
3. [x] 销售管理

## 开发工具

1. jdk >= 1.8
2. maven 3.8.4，按照若依官网描述，大于3.0.x应该就可以，浪子使用的 3.8.4 版本
3. MySQL > 8.0
4. Spring Boot 2.5.8
5. Redis > 3.x
6. Node.js 安装 vue-cli
7. 其他内容参照 [官网内容](http://doc.ruoyi.vip/ruoyi-vue/)

## 系统部署

后端部署

1. 确保Java运行的相关环境： JDK、MySQL、Redis服务存在并正常运行
2. 运行数据库文件，导入相关数据
3. 修改 market-admin 模块 resources 目录下的 application.yml 的相关配置
4. 修改 logback.xml 的日志存放目录
5. 启动后端项目，后端使用的默认端口8889，可以自行修改(如果修改了启动端口，market-ui模块下的 vue.config.js 文件中的 target 也要修改为对应的端口，否则无法访问)

前端部署：

1. 进入 market-ui 模块，执行命令 `npm -i`
2. 安装相关依赖完成后执行 `npm run dev`，默认端口 80.

前后端启动完成后，访问 `http://localhost:80`(默认账户/密码 admin/admin123)，若能正确显示登录页面，并能成功登录，菜单及页面显示正常，表明环境搭建成功。

```bash{.line-numbers}
// 打包正式环境
npm run build:prod
// 打包预发布环境：
npm run build:stage
```
