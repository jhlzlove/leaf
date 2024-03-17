<template><div><h1 id="代码规范" tabindex="-1"><a class="header-anchor" href="#代码规范" aria-hidden="true">#</a> 代码规范</h1>
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


