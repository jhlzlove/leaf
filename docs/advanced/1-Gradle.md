# Gradle

目前，在 idea 中使用 gradle 作为版本管理时，新建模块时会在父模块中自动新建 `src` 目录，创建完删除即可，不影响项目。

:::tip
推荐使用最新版的 IDEA（2023.3 ~ latest），对于 Gradle 的开发体验较好，本地安装的 Gradle
的用处终于显现出来啦！（以前安装本地感觉没什么用）如果不能支持正版，可以使用 [IDEA Community](https://github.com/JetBrains/intellij-community)
，安装一些免费插件使用即可，如果必须使用旗舰版的功能，那就 emmm。
:::

## gradle.properties

该文件可以声明环境变量，进而覆盖 gradle 的默认配置。

## 允许从 http 下载依赖

gradle 默认是不允许使用 http 协议下载依赖的，如果需要，按照下面的方式修改 `build.gradle.kts`

```kotlin build.gradle.kts
repositories {
    maven {
        url = uri("http://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
        isAllowInsecureProtocol = true
    }
}
```
