# 简介

为了更好的了解一些技术的使用以及原理、甚至是一些问题，新开一个模块结合前端框架 [Vben Admin](https://vvbin.cn/doc-next/)
一起写一个简单的例子。

- [项目结构和介绍](./market-vben-example/introduce.md)
- [项目使用工具清单](./dev-tools.md)
- [日志](./market-vben-example/dev-log.md)

# 开发理念

- 新
  - 不多说，全部使用新的语法糖，多么简单直白！用就完事儿。
  - 依赖不冲突前提全部使用最新版本，个人项目玩是首要，稳定次要。

- 少
    - 尽量减少第三方库的依赖、减少工具类的封装，使用 JDK 或者项目中必须使用的依赖库以及框架自带的工具类。比如
      Base64 既可以使用 `java.util` 包下的工具类，也可以使用
      Spring 框架提供的 `Base64Utils` 工具类等。

# 部署

后续完善

```bash
# 下载源代码
# 后端
git clone https://github.com/jhlzlove/market.git
# 前端 也可以直接 clone 后切入 market 分支，main 分支用于合并原项目
git clone -b market https://github.com/jhlzlove/vue-vben-admin.git

# 前端安装依赖
cd vue-vben-admin
pnpm install
# 启动
pnpm serve
```

# 致谢

感谢：  
[Vben Admin](https://vvbin.cn/doc-next/) 社区开发的一款优秀的前端框架。  
[JetBrains](https://jb.gg/OpenSourceSupport) 为开源项目提供免费的 IntelliJ IDEA 等 IDE 的授权。  
<img style="width:200px" src="https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png" alt="JetBrains Logo (Main) logo.">
