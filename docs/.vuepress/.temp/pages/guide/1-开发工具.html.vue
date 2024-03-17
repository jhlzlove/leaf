<template><div><h1 id="开发工具" tabindex="-1"><a class="header-anchor" href="#开发工具" aria-hidden="true">#</a> 开发工具</h1>
<h2 id="一、工具版本" tabindex="-1"><a class="header-anchor" href="#一、工具版本" aria-hidden="true">#</a> 一、工具版本</h2>
<ul>
<li>JDK 17.0+</li>
<li>Gradle 8.x+</li>
<li>SpringBoot 3.1+</li>
<li>PostgreSQL 15.0+</li>
<li>Redis 5.x+</li>
</ul>
<div class="custom-container tip"><p class="custom-container-title">TIP</p>
<p>一般来说，像 IDE 这种工具的版本对写代码影响不大，VIM 都可以写代码，就别纠结这些了。</p>
</div>
<h2 id="二、项目结构" tabindex="-1"><a class="header-anchor" href="#二、项目结构" aria-hidden="true">#</a> 二、项目结构</h2>
<h3 id="_2-1-根目录" tabindex="-1"><a class="header-anchor" href="#_2-1-根目录" aria-hidden="true">#</a> 2.1 根目录</h3>
<div class="language-bash line-numbers-mode" data-ext="sh"><pre v-pre class="language-bash"><code>├── build.gradle.kts        <span class="token comment"># 父项目 gradle.kts 脚本</span>
├── buildSrc                <span class="token comment"># kt 构建相关文件，*.gradle.kts 依赖版本控制 等</span>
│   ├── build.gradle.kts
│   └── src
├── cz.config.js            <span class="token comment"># czg 配置文件</span>
├── docs                    <span class="token comment"># 相关文档</span>
├── leaf-system             <span class="token comment"># 系统模块</span>
│   ├── build.gradle.kts
│   └── src
├── package.json            <span class="token comment"># npm 脚本文件</span>
└── settings.gradle.kts     <span class="token comment"># 项目多模块设置</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="custom-container warning"><p class="custom-container-title">build.gradle.kts</p>
<p><code v-pre>build.gradle.kts</code> 的依赖版本管理模块。目前（2023.8.20） <code v-pre>kts</code> 还不支持类似 <code v-pre>ext</code> 的方式，可以使用 extra 和 buildSrc
的方式，本项目使用后者。</p>
</div>
<h3 id="_2-2-系统模块-leaf-system" tabindex="-1"><a class="header-anchor" href="#_2-2-系统模块-leaf-system" aria-hidden="true">#</a> 2.2 系统模块（leaf-system）</h3>
<div class="language-bash line-numbers-mode" data-ext="sh"><pre v-pre class="language-bash"><code>├── main
│   ├── <span class="token function">java</span>                                <span class="token comment"># Java 文件</span>
│   │   └── com
│   │       └── leaf
│   │           ├── LeafApplication.java
│   │           ├── common
│   │           │   ├── annotation
│   │           │   ├── business
│   │           │   ├── config              <span class="token comment"># 项目配置</span>
│   │           │   ├── constant            <span class="token comment"># 项目常量</span>
│   │           │   ├── exception           <span class="token comment"># 项目异常</span>
│   │           │   ├── filter              <span class="token comment"># 过滤器</span>
│   │           │   ├── interceptor         <span class="token comment"># 拦截器</span>
│   │           │   ├── log                 <span class="token comment"># 日志</span>
│   │           │   ├── response            <span class="token comment"># 响应</span>
│   │           │   └── util                <span class="token comment"># 工具类</span>
│   │           └── system                  <span class="token comment"># 系统管理入口</span>
│   │               ├── controller
│   │               ├── domain
│   │               ├── repository
│   │               └── <span class="token function">service</span>
│   ├── Kotlin                              <span class="token comment"># Kotlin 文件</span>
│   │   └── com
│   │       └── leaf
│   │           └── util
│   └── resources                           <span class="token comment"># 资源配置文件</span>
│       ├── application-dev.yml
│       ├── application-prod.yml
│       ├── application.yml
│       ├── banner.txt
│       ├── log4j2.xml
│       ├── logback.xml
│       └── static
└── <span class="token builtin class-name">test</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="三、idea-社区版推荐插件" tabindex="-1"><a class="header-anchor" href="#三、idea-社区版推荐插件" aria-hidden="true">#</a> 三、IDEA 社区版推荐插件</h2>
<p>如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：</p>
<ul>
<li><a href="https://plugins.jetbrains.com/plugin/9417-log-support-2" target="_blank" rel="noopener noreferrer">Log Support 2<ExternalLinkIcon/></a></li>
<li><a href="https://plugins.jetbrains.com/plugin/8579-translation" target="_blank" rel="noopener noreferrer">Translation<ExternalLinkIcon/></a></li>
</ul>
</div></template>


