## 开发

请确保后端服务成功启动后再启动前端项目。

```bash
# 克隆项目
git clone https://github.com/jhlzlove/market.git

# 进入前端项目目录
cd market-ui

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

如果设置的有默认浏览器，程序启动成功后会直接使用默认的浏览器打开相关页面。如果没有可以使用浏览器访问 http://localhost:80

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```