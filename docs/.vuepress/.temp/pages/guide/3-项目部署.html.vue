<template><div><h1 id="项目部署" tabindex="-1"><a class="header-anchor" href="#项目部署" aria-hidden="true">#</a> 项目部署</h1>
<h2 id="一、后端部署" tabindex="-1"><a class="header-anchor" href="#一、后端部署" aria-hidden="true">#</a> 一、后端部署</h2>
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
<h2 id="二、前端部署" tabindex="-1"><a class="header-anchor" href="#二、前端部署" aria-hidden="true">#</a> 二、前端部署</h2>
<p>后续补充~</p>
</div></template>


