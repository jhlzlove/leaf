<template><div><h1 id="构建-部署" tabindex="-1"><a class="header-anchor" href="#构建-部署" aria-hidden="true">#</a> 构建 &amp; 部署</h1>
<h2 id="一、构建" tabindex="-1"><a class="header-anchor" href="#一、构建" aria-hidden="true">#</a> 一、构建</h2>
<h3 id="_1-开发工具" tabindex="-1"><a class="header-anchor" href="#_1-开发工具" aria-hidden="true">#</a> 1. 开发工具</h3>
<p>开始阅读本文档之前，请确保具有以下工具或者环境。</p>
<ul>
<li>JDK 17.0+</li>
<li>Gradle 8.x+</li>
<li>SpringBoot 3.1+</li>
<li>PostgreSQL 15.0+</li>
<li>Redis 5.x+</li>
</ul>
<div class="custom-container tip"><p class="custom-container-title">TIP</p>
<p>一般来说，像 IDE 这种工具的版本对写代码影响不大，VIM 都可以写代码，就别纠结这些了，选自己喜欢的。</p>
</div>
<h3 id="_2-项目结构" tabindex="-1"><a class="header-anchor" href="#_2-项目结构" aria-hidden="true">#</a> 2. 项目结构</h3>
<h4 id="_2-1-根目录" tabindex="-1"><a class="header-anchor" href="#_2-1-根目录" aria-hidden="true">#</a> 2.1 根目录</h4>
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
<h4 id="_2-2-系统模块-leaf-system" tabindex="-1"><a class="header-anchor" href="#_2-2-系统模块-leaf-system" aria-hidden="true">#</a> 2.2 系统模块（leaf-system）</h4>
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
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_3-idea-社区版推荐插件" tabindex="-1"><a class="header-anchor" href="#_3-idea-社区版推荐插件" aria-hidden="true">#</a> 3. IDEA 社区版推荐插件</h3>
<p>如果您使用 IDEA 社区版进行本项目的开发，安装以下插件或许有不错的体验：</p>
<ul>
<li><a href="https://plugins.jetbrains.com/plugin/9417-log-support-2" target="_blank" rel="noopener noreferrer">Log Support 2<ExternalLinkIcon/></a></li>
<li><a href="https://plugins.jetbrains.com/plugin/8579-translation" target="_blank" rel="noopener noreferrer">Translation<ExternalLinkIcon/></a></li>
</ul>
<h2 id="二、部署" tabindex="-1"><a class="header-anchor" href="#二、部署" aria-hidden="true">#</a> 二、部署</h2>
<h3 id="_1-后端部署" tabindex="-1"><a class="header-anchor" href="#_1-后端部署" aria-hidden="true">#</a> 1. 后端部署</h3>
<p>本项目使用 Gradle 作为依赖管理工具，但不推荐本地安装 Gradle，尤其是使用 JetBrains IDEA 的用户。</p>
<p>那么如何处理呢？直接添加环境变量 <code v-pre>GRADLE_USER_HOME</code>，设置为你想存储 Gradle 的路径位置，重启电脑。
然后在该路径下创建 <code v-pre>init.gradle.kts</code> 文件，添加的内容和下面的一样。</p>
<p>设置此环境变量后，IDEA 自动下载的所有 gradle 版本和相关的依赖都会下载到此位置。</p>
<p>如果不设置 <code v-pre>GRADLE_USER_HOME</code> 环境变量的话，创建 <code v-pre>~/.gradle/init.gradle.kts</code> 文件并添加以下内容：</p>
<div class="language-kotlin line-numbers-mode" data-ext="kt"><pre v-pre class="language-kotlin"><code><span class="token keyword">fun</span> RepositoryHandler<span class="token punctuation">.</span><span class="token function">enableMirror</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    all <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token keyword">this</span> <span class="token keyword">is</span> MavenArtifactRepository<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">val</span> originalUrl <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span>url<span class="token punctuation">.</span><span class="token function">toString</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">removeSuffix</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">"/"</span></span><span class="token punctuation">)</span>
            urlMappings<span class="token punctuation">[</span>originalUrl<span class="token punctuation">]</span><span class="token operator">?</span><span class="token punctuation">.</span><span class="token function">let</span> <span class="token punctuation">{</span>
                logger<span class="token punctuation">.</span><span class="token function">lifecycle</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">"Repository[</span><span class="token interpolation"><span class="token interpolation-punctuation punctuation">$</span><span class="token expression">url</span></span><span class="token string">] is mirrored to </span><span class="token interpolation"><span class="token interpolation-punctuation punctuation">$</span><span class="token expression">it</span></span><span class="token string">"</span></span><span class="token punctuation">)</span>
                <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">setUrl</span><span class="token punctuation">(</span>it<span class="token punctuation">)</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

<span class="token keyword">val</span> urlMappings <span class="token operator">=</span> <span class="token function">mapOf</span><span class="token punctuation">(</span>
    <span class="token string-literal singleline"><span class="token string">"https://repo.maven.apache.org/maven2"</span></span> <span class="token keyword">to</span> <span class="token string-literal singleline"><span class="token string">"https://mirrors.tencent.com/nexus/repository/maven-public/"</span></span><span class="token punctuation">,</span>
    <span class="token string-literal singleline"><span class="token string">"https://repo1.maven.apache.org/maven2"</span></span> <span class="token keyword">to</span> <span class="token string-literal singleline"><span class="token string">"https://mirrors.tencent.com/nexus/repository/maven-public/"</span></span><span class="token punctuation">,</span>
    <span class="token string-literal singleline"><span class="token string">"https://dl.google.com/dl/android/maven2"</span></span> <span class="token keyword">to</span> <span class="token string-literal singleline"><span class="token string">"https://mirrors.tencent.com/nexus/repository/maven-public/"</span></span><span class="token punctuation">,</span>
    <span class="token string-literal singleline"><span class="token string">"https://plugins.gradle.org/m2"</span></span> <span class="token keyword">to</span> <span class="token string-literal singleline"><span class="token string">"https://mirrors.tencent.com/nexus/repository/gradle-plugins/"</span></span>
<span class="token punctuation">)</span>

gradle<span class="token punctuation">.</span><span class="token function">allprojects</span> <span class="token punctuation">{</span>
    buildscript <span class="token punctuation">{</span>
        repositories<span class="token punctuation">.</span><span class="token function">enableMirror</span><span class="token punctuation">(</span><span class="token punctuation">)</span>
    <span class="token punctuation">}</span>
    repositories<span class="token punctuation">.</span><span class="token function">enableMirror</span><span class="token punctuation">(</span><span class="token punctuation">)</span>
<span class="token punctuation">}</span>

gradle<span class="token punctuation">.</span><span class="token function">beforeSettings</span> <span class="token punctuation">{</span>
    pluginManagement<span class="token punctuation">.</span>repositories<span class="token punctuation">.</span><span class="token function">enableMirror</span><span class="token punctuation">(</span><span class="token punctuation">)</span>
    dependencyResolutionManagement<span class="token punctuation">.</span>repositories<span class="token punctuation">.</span><span class="token function">enableMirror</span><span class="token punctuation">(</span><span class="token punctuation">)</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>这样 Gradle 就算配置完成了。</p>
<p>下载项目：</p>
<div class="language-bash line-numbers-mode" data-ext="sh"><pre v-pre class="language-bash"><code><span class="token function">git</span> clone https://github.com/jhlzlove/leaf.git
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><p>修改 <code v-pre>leaf/leaf-system/src/main/resources/application-dev.yml</code> 配置文件的内容，确保连接信息和自己的本机信息一致。</p>
<h3 id="_2-前端部署" tabindex="-1"><a class="header-anchor" href="#_2-前端部署" aria-hidden="true">#</a> 2. 前端部署</h3>
<p>后续补充~</p>
</div></template>


