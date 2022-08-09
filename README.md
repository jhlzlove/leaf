## 平台简介

该项目基于若依快速开发平台构建，可以在 [若依官网](http://www.ruoyi.vip) 详细了解。

##  

## 开发工具

大部分都和官网推荐保持一致，部分在开发中更换版本。

1. jdk >= 1.8
2. maven 3.8.4，按照若依官网描述，大于3.0.x应该就可以，浪子使用的 3.8.4 版本
3. MySQL > 8.0
4. Spring Boot 2.5.8
5. Redis > 3.x
6. Node.js >= 12，浪子使用的 16.15
7. Node.js 安装 vue-cli,最新版安装脚手架方式 `npm i -g @vue/cli`，如果使用了 uni-app 开发其它平台程序，请安装 4.x 版本。5.x 版本的脚手架运行 uniapp:h5 会报错。
8. 其他内容参照 [若依前后端分离版文档](http://doc.ruoyi.vip/ruoyi-vue/)

## 系统部署

### 后端部署

1. 确保Java运行的相关环境： JDK、MySQL、Redis服务存在并正常运行
2. 运行数据库文件，导入相关数据
3. 修改 market-admin 模块 resources 目录下的 application.yml 的相关配置
4. 修改 logback.xml 的日志存放目录
5. 启动后端项目，后端使用的默认端口8889，可以自行修改(如果修改了启动端口，market-ui模块下的 vue.config.js 文件中的代理访问路径端口也要对应修改，否则无法访问)

### 前端部署

1. 进入 market-ui 模块，执行命令 `npm -i`
2. 安装相关依赖完成后执行 `npm run dev`，默认端口 80.

前后端启动完成后，访问 `http://localhost:80`(默认账户/密码 admin/admin123)，若能正确显示登录页面，并能成功登录，菜单及页面显示正常，表明环境搭建成功。

```bash{.line-numbers}
// 打包正式环境
npm run build:prod
// 打包预发布环境：
npm run build:stage
```
