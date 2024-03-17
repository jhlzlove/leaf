<template><div><h1 id="常见问题" tabindex="-1"><a class="header-anchor" href="#常见问题" aria-hidden="true">#</a> 常见问题</h1>
<h2 id="一、spring-framework" tabindex="-1"><a class="header-anchor" href="#一、spring-framework" aria-hidden="true">#</a> 一、Spring Framework</h2>
<h3 id="_1-springboot-3-x" tabindex="-1"><a class="header-anchor" href="#_1-springboot-3-x" aria-hidden="true">#</a> 1. SpringBoot 3.x</h3>
<p>Jakarta EE 9是一个新的顶级包，取代了 Java EE 中的 javax 顶级包。例如，JakartaEE8 中的 Servlet 规范使用 <code v-pre>javax.servlet</code>
包，但在 EE9 中已更改为 <code v-pre>jakarta.servlet</code>。</p>
<p>一般来说，不可能在同一个项目中混合使用 Java EE 和 Jakarta EE API。您需要确保您自己的代码以及所有第三方库都使用 <code v-pre>jakarta.*</code>
包导入。大多数维护良好的库都在生成 Jakarta EE 9 兼容的变体。例如 Hibernate、Thymeleaf、Tomcat、Jetty 和 Undertow 都已经这样做了。</p>
<blockquote>
<p>以上机翻自 Spring 官网。</p>
</blockquote>
<h3 id="_2-使用构造注入" tabindex="-1"><a class="header-anchor" href="#_2-使用构造注入" aria-hidden="true">#</a> 2. <a href="https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/htmlsingle/#beans-setter-injection" target="_blank" rel="noopener noreferrer">使用构造注入？<ExternalLinkIcon/></a></h3>
<p>以下内容摘自 Spring 官网：</p>
<blockquote>
<p>The Spring team generally advocates constructor injection as it enables one to implement application components as
immutable objects and to ensure that required dependencies are not null. Furthermore constructor-injected components
are
always returned to client (calling) code in a fully initialized state. As a side note, a large number of constructor
arguments is a bad code smell, implying that the class likely has too many responsibilities and should be refactored
to
better address proper separation of concerns.</p>
</blockquote>
<p>机翻一下：
Spring团队通常提倡构造函数注入，因为它使人们能够将应用程序组件实现为不可变对象，并确保所需的依赖项不为空。此外，构造函数注入的组件总是以完全初始化的状态返回到客户端（调用）代码。顺便说一句，大量的构造函数参数是一种糟糕的代码气味，这意味着类可能有太多的责任，应该进行重构，以更好地解决关注点的适当分离。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>stereotype<span class="token punctuation">.</span></span><span class="token class-name">Service</span></span><span class="token punctuation">;</span>

<span class="token annotation punctuation">@Service</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">DemoServiceImpl</span> <span class="token keyword">implements</span> <span class="token class-name">DemoService</span> <span class="token punctuation">{</span>

    <span class="token keyword">private</span> <span class="token keyword">final</span> <span class="token class-name">DemoDao</span> demoDao<span class="token punctuation">;</span>

    <span class="token comment">// 这里的 @Autowired 注解可加可不加</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">public</span> <span class="token class-name">DemoServiceImpl</span><span class="token punctuation">(</span><span class="token class-name">DemoDao</span> demoDao<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>demoDao <span class="token operator">=</span> demoDao<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">// ...业务逻辑</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="custom-container tip"><p class="custom-container-title">TIP</p>
<p>可以使用 lombok 的注解来添加构造方法，不必手动添加。</p>
</div>
<h3 id="_3-spring-mvc-pathpattern、antpathmatcher" tabindex="-1"><a class="header-anchor" href="#_3-spring-mvc-pathpattern、antpathmatcher" aria-hidden="true">#</a> 3. <a href="https://spring.io/blog/2020/06/30/url-matching-with-pathpattern-in-spring-mvc" target="_blank" rel="noopener noreferrer">Spring MVC PathPattern、AntPathMatcher<ExternalLinkIcon/></a></h3>
<p><code v-pre>PathPattern</code> 是 Spring 5.0 提供的，在 Spring 6.x 中又有了改进。本项目使用 <code v-pre>PathPattern</code>，<code v-pre>AntPathMatcher</code>
是之前的路径匹配器。如果是新项目的话，推荐使用新的的 <code v-pre>PathPattern</code>
。如果项目中没有配置 <code v-pre>spring.mvc.pathmatch.matching-strategy</code> ，默认使用的也是 <code v-pre>PathPatternParser</code>。</p>
<p>Spring Security 5.7 之后的写法改变，包括路径的写法，无须显示调用 <code v-pre>antMatcher</code>、<code v-pre>mvcMatcher</code>，Security 会自适应调用。</p>
<blockquote>
<p>Spring Security 6.x 版本的写法又变了两版了，看起来像是一个过渡版本，RC 版。</p>
</blockquote>
<h3 id="_4-spring-security-6-x-子线程或异步线程获取用户信息" tabindex="-1"><a class="header-anchor" href="#_4-spring-security-6-x-子线程或异步线程获取用户信息" aria-hidden="true">#</a> 4. Spring Security 6.x 子线程或异步线程获取用户信息</h3>
<p>使用 Security 6.x
版本时，直接使用 <code v-pre>SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);</code>
开启用户信息在异步线程或者子线程中获取会导致用户无法正常通过验证。</p>
<p>所以如果需要在子线程中获取用户信息，可以考虑在主线程中把 SecurityContent 传递给子线程或者异步线程。</p>
<h3 id="_5-使用-responsebodyadvice-封装返回结果集" tabindex="-1"><a class="header-anchor" href="#_5-使用-responsebodyadvice-封装返回结果集" aria-hidden="true">#</a> 5. 使用 ResponseBodyAdvice 封装返回结果集</h3>
<p>前后端分离项目中，后端一般都会把结果封装成一定结构的特殊体返回给前端，大致结构如下：</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token punctuation">{</span>
        <span class="token string">"code"</span><span class="token operator">:</span><span class="token number">111</span><span class="token punctuation">,</span>
        <span class="token string">"msg"</span><span class="token operator">:</span><span class="token string">""</span><span class="token punctuation">,</span>
        <span class="token string">"data"</span><span class="token operator">:</span><span class="token punctuation">{</span>obj<span class="token punctuation">}</span><span class="token punctuation">,</span>
        <span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>追求简单的话可能会使用 <code v-pre>ResponseBodyAdvice</code> 接口来对 controller 层的返回值做统一封装。此时，假如在 controller
层直接返回系统定义的类而不是使用特定结构体封装的结果，
直接把 swagger url 导入 Apifox 等接口工具中的话，那么这些工具的模型校验会失败，工具验证的是 json
格式的结果，而实际导入的是一个对象类型。做自动化测试的时候需要手动调整，并且导出相关文档时也会产生不想要的结果。</p>
<p>另外，对于使用这个注解封装的时候，还会发生其它的问题，比如访问 swagger 地址的时候被拦截，出现异常。不过解决方法也有多种。</p>
<p>所以对于喜欢使用接口工具做自动化测试的小伙伴 <strong>推荐</strong> controller 中返回封装后的特定结构体，不要图省事，可以确保后续的使用中减少出现的问题。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code>
<span class="token annotation punctuation">@RestControllerAdvice</span><span class="token punctuation">(</span><span class="token string">"*.*.*.controller"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ResponseHandler</span> <span class="token keyword">implements</span> <span class="token class-name">ResponseBodyAdvice</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Object</span><span class="token punctuation">></span></span> <span class="token punctuation">{</span>
    <span class="token comment">// 省略其它 ...</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Object</span> <span class="token function">beforeBodyWrite</span><span class="token punctuation">(</span><span class="token class-name">Object</span> body<span class="token punctuation">,</span> <span class="token class-name">MethodParameter</span> returnType<span class="token punctuation">,</span> <span class="token class-name">MediaType</span> selectedContentType<span class="token punctuation">,</span>
                                  <span class="token class-name">Class</span> selectedConverterType<span class="token punctuation">,</span> <span class="token class-name">ServerHttpRequest</span> request<span class="token punctuation">,</span> <span class="token class-name">ServerHttpResponse</span> response<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>body <span class="token keyword">instanceof</span> <span class="token class-name">String</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">return</span> body<span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">return</span> <span class="token class-name">ResultResponse</span><span class="token punctuation">.</span><span class="token function">success</span><span class="token punctuation">(</span>body<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

<span class="token annotation punctuation">@Tag</span><span class="token punctuation">(</span>name <span class="token operator">=</span> <span class="token string">"用户模块管理"</span><span class="token punctuation">)</span>
<span class="token annotation punctuation">@RestController</span>
<span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/user"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">UserController</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * swagger 文档导入到 apifox 等自动化测试的软件中实际的实体模型为 User，可能会影响测试结果
     * 所以如果需要的话，建议此处返回值为 R（自封装结果）
     */</span>
    <span class="token annotation punctuation">@GetMapping</span><span class="token punctuation">(</span><span class="token string">"/{id}"</span><span class="token punctuation">)</span>
    <span class="token annotation punctuation">@ApiOperation</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"获取指定用户"</span><span class="token punctuation">,</span> notes <span class="token operator">=</span> <span class="token string">"根据 id 获取指定用户信息，get 方法"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">User</span> <span class="token function">queryById</span><span class="token punctuation">(</span><span class="token annotation punctuation">@PathVariable</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token class-name">Long</span> id<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> userService<span class="token punctuation">.</span><span class="token function">queryById</span><span class="token punctuation">(</span>id<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></div></template>


