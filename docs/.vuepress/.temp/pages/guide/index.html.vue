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
<h2 id="三、代码规范" tabindex="-1"><a class="header-anchor" href="#三、代码规范" aria-hidden="true">#</a> 三、代码规范</h2>
<div class="custom-container tip"><p class="custom-container-title">TIP</p>
<p>代码规范可以帮助开发人员更好地理解和阅读代码，提高代码的可读性，并降低出现错误的概率。</p>
<p>同时，它还有助于提高代码的可维护性，使得其他开发人员能够轻松地理解和修改代码，而不需要花费大量时间去弄清楚代码的意图和逻辑。</p>
<p>不同的团队会有不同的规范，适合团队的、团队成员共同遵守的就是最好的！染于苍则苍，染于黄则黄</p>
</div>
<p>本项目的代码规范如下：</p>
<h3 id="注释" tabindex="-1"><a class="header-anchor" href="#注释" aria-hidden="true">#</a> 注释</h3>
<p>真正好的注释是想办法不写注释。所以方法名最好见名知意，内部逻辑保持简单，非常考验程序员的水平。</p>
<p>另外，注释只应该描述有关代码和设计的技术性信息，而不是通篇大论。</p>
<p>Java 中有自己特殊的注释，可以使用 <code v-pre>javadoc</code> 命令生成为 JavaDoc API 文档，i think you need read
it: https://www.geeksforgeeks.org/comments-in-java/</p>
<h3 id="编码及缩进" tabindex="-1"><a class="header-anchor" href="#编码及缩进" aria-hidden="true">#</a> 编码及缩进</h3>
<p>一律使用 <code v-pre>UTF-8</code> 编码和 4 空格缩进。</p>
<h3 id="业务函数参数" tabindex="-1"><a class="header-anchor" href="#业务函数参数" aria-hidden="true">#</a> 业务函数参数</h3>
<p>如果业务中函数的参数有三个以上，全部封装为类入参。</p>
<h3 id="代码行长度限制-120" tabindex="-1"><a class="header-anchor" href="#代码行长度限制-120" aria-hidden="true">#</a> 代码行长度限制：120</h3>
<p>每一行的长度在 120 个字符左右，如果超过必须换行。一般来说，常见的有 80、100、120。</p>
<blockquote>
<p>IDEA 等常用 IDE 含有分割线提示，非常方便！</p>
</blockquote>
<h3 id="包装类与基本类型" tabindex="-1"><a class="header-anchor" href="#包装类与基本类型" aria-hidden="true">#</a> 包装类与基本类型</h3>
<p>实体、收参、出参使用包装类；局部变量尽量使用基础类型。</p>
<h3 id="命名" tabindex="-1"><a class="header-anchor" href="#命名" aria-hidden="true">#</a> 命名</h3>
<ol>
<li>包名全部小写，如果有多个单词连着写，比如：<code v-pre>com.example.deepspace</code>；</li>
<li>类名遵循 UpperCamelCase 风格；</li>
<li>方法名都遵循 lowerCamelCase 风格；</li>
<li>常量名全部大写，多个单词使用下划线分割；非常量遵循 lowerCamelCase 风格命名；</li>
<li>尽量不要使用拼音命名；</li>
</ol>
<h3 id="工具类" tabindex="-1"><a class="header-anchor" href="#工具类" aria-hidden="true">#</a> 工具类</h3>
<p>减少依赖，降低工具类泛滥。非业务框架不应该封装过多工具，够用就好，具体使用什么应该交由用户决定。 本项目只是简单的基于 JDK 或者
Spring 中使用的 API 封装了几个工具类，后续使用可以自行选择自己喜欢的第三方库，封装的清单如下：</p>
<ul>
<li>基于 ObjectMapper 封装了 JSON 工具；</li>
<li>基于 JDK 的 HttpClient、HttpRequest、HttpResponse 封装的网络工具；</li>
<li>基于 JDK jsr310 日期封装的 LocalDateUtil 工具；</li>
<li>SpringUtil、SecurityUtil、ServletUtil；</li>
<li>下拉树菜单工具；</li>
</ul>
<h3 id="optional" tabindex="-1"><a class="header-anchor" href="#optional" aria-hidden="true">#</a> Optional</h3>
<p>本项目强制在返回值、级联对象调用（obj.getObjA().getObjB()）时使用该类。</p>
<ul>
<li>在返回值中，无论返回的 <code v-pre>null</code> 是否有意义（有用），或是抛出异常，或是构造新的空值对象类都能满足；</li>
<li>在获取级联对象时，可以减少 if 的嵌套代码，使代码看起来更简短；</li>
</ul>
<h3 id="全部使用-jsr310-日期" tabindex="-1"><a class="header-anchor" href="#全部使用-jsr310-日期" aria-hidden="true">#</a> 全部使用 jsr310 日期</h3>
<p>项目强制不允许使用 Date，使用LocalDate、LocalDateTime 等 java8 提供的新式 API。</p>
</div></template>


