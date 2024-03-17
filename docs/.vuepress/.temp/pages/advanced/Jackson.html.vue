<template><div><h1 id="jackson" tabindex="-1"><a class="header-anchor" href="#jackson" aria-hidden="true">#</a> Jackson</h1>
<h3 id="valid-validated" tabindex="-1"><a class="header-anchor" href="#valid-validated" aria-hidden="true">#</a> @Valid @Validated</h3>
<ul>
<li>@Valid 是 jakarta 包下的，而 @Validated 是 Spring 提供的；</li>
<li>@Valid 不支持分组验证，@Validated 支持，@Validated 是 @Valid 的扩展；</li>
<li>@Valid 使用在对象属性中，可以递归校验对象属性是否符合要求；</li>
</ul>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Subject</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@NotEmpty</span><span class="token punctuation">(</span>message <span class="token operator">=</span> <span class="token string">"学科名称不能为空"</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> teacherName<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Min</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token number">1</span><span class="token punctuation">,</span> message <span class="token operator">=</span> <span class="token string">"学科类型从1开始计算"</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token keyword">int</span> type<span class="token punctuation">;</span>
<span class="token punctuation">}</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">StudentBean</span> <span class="token keyword">implements</span> <span class="token class-name">Serializable</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@NotBlank</span><span class="token punctuation">(</span>message <span class="token operator">=</span> <span class="token string">"用户名不能为空"</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> name<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Email</span><span class="token punctuation">(</span>message <span class="token operator">=</span> <span class="token string">"邮箱格式错误"</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> email<span class="token punctuation">;</span>

    <span class="token comment">// 加入该注解才会验证 Subject 里面的内容，否则只验证 NotNull Size</span>
    <span class="token annotation punctuation">@Valid</span>
    <span class="token annotation punctuation">@NotNull</span><span class="token punctuation">(</span>message <span class="token operator">=</span> <span class="token string">"所学科目不能为空"</span><span class="token punctuation">)</span>
    <span class="token annotation punctuation">@Size</span><span class="token punctuation">(</span>min <span class="token operator">=</span> <span class="token number">1</span><span class="token punctuation">,</span> message <span class="token operator">=</span> <span class="token string">"至少学习一个科目"</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Subject</span><span class="token punctuation">></span></span> subjectList<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="jsonview" tabindex="-1"><a class="header-anchor" href="#jsonview" aria-hidden="true">#</a> @JsonView</h3>
<p>可以在已经存在的实体的属性中选择性的创建返回的对象视图。</p>
</div></template>


