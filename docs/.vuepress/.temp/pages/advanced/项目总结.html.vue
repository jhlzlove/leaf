<template><div><h1 id="项目总结" tabindex="-1"><a class="header-anchor" href="#项目总结" aria-hidden="true">#</a> 项目总结</h1>
<p>浪子觉得总结不一定必须在最后写，在过程中写也是一样的。简单谈谈自己开发下来的感受。</p>
<h3 id="_1-spring-xml-配置与-java-配置" tabindex="-1"><a class="header-anchor" href="#_1-spring-xml-配置与-java-配置" aria-hidden="true">#</a> 1. Spring xml 配置与 Java 配置</h3>
<p>从 Spring4.x 版本开始，Spring 已经不推荐使用 xml 配置了，而是推荐 Java 配置，Java 配置也是 Spring Boot
推荐的配置方式。不过很多前辈、大牛，都很了解 xml 配置这种方式，这种方式对新手不是那么容易接受，至少浪子刚开始的时候确实如此。</p>
<p>不过得益于时代发展和技术更新，浪子工作的时候基本都是 Spring Boot 项目，还有更多都是要求掌握 Spring Cloud 了。(
Cloud也没什么，就是组件多了而已，<s>其实是维护排查问题还有数据同步问题困难、麻烦</s>)。</p>
<p>对于 <code v-pre>xml</code> 配置的方式进行项目开发接触不是太多。后面随着学习的深入，再看到这种项目浪子觉得 <code v-pre>xml</code>
是一个非常好的组件清单（你可以把它看成一个文档）;维护者接手这个项目只要看一眼这个 <code v-pre>xml</code>
就能搞清楚系统的组件的“架构（包括依赖关系）”。不过 <code v-pre>xml</code>
文件没有类型检查，如果导入了一个错误的类，可能你需要找很长时间的错误(不过我们有智能 IDE！但字符串拼写还是有可能漏查的)。</p>
<h3 id="_2-orm" tabindex="-1"><a class="header-anchor" href="#_2-orm" aria-hidden="true">#</a> 2. ORM</h3>
<p>说实话，Java 项目中如果不使用 lombok 那是相当难受的。如果采用敏捷开发，很多时候数据库属性不会设计的很完美，在开发的过程中需要频繁的添加或者修改字段。
那将非常的浪费<s>摸鱼的</s> （学习的）时间。
所以选择一个合适的 ORM 框架是比较好的。
如果是使用的 mybatis，那就可能需要我们去维护 mapper 中的 SQL。在使用 lombok 的情况下我们对实体所做的就是添加属性，如果自定义的响应（例如
DTO、VO）或者手写的 SQL 语句中需要用到新增的字段属性，那么这些类也需要修改。</p>
<p>手写的 SQL 如果特别多的话，后期维护也是比较头疼的一件事。可能有人说，如果 SQL 较多的话我使用多个 <code v-pre>sqlMapper.xml</code>
文件按照功能分开，让它们的 <code v-pre>namespace</code> 都指向同一个 Dao 接口不也是可以的？没错，是可以，但是上面频繁的修改依旧是免不了的；如果映射做的不好，漏了哪个字段还需要修改、重启多次去测试。</p>
<p>使用 MP(Mybatis Plus) 的话是一个不错的选择，如果你的 SQL 能力比较强，这两种方式无论使用哪种都是可以的。切记，实际工作中技术选型要考虑到团队的写作，选大家都熟悉的。</p>
<p>最终，浪子选用了 Spring Data JPA，毕竟 Spring 项目嘛，一家人就是要整整齐齐！使用起来还不错！ 😄 如果要更换或者加入其它
ORM
框架的时候也很方便，引入 Mybatis 或者 Mybatis-Plus 也不难。</p>
<h2 id="学习类库" tabindex="-1"><a class="header-anchor" href="#学习类库" aria-hidden="true">#</a> 学习类库</h2>
<p>这些类库在项目中都没有用过，为了简洁、减少依赖，这里单独拎出来写。这些东西都是开发过程中在网上获取资料时发现的，看起来挺不错的。可以酌情在项目中使用。</p>
<ul>
<li>
<p>集合库：<a href="https://www.eclipse.org/collections/" target="_blank" rel="noopener noreferrer">eclipse collections<ExternalLinkIcon/></a></p>
<p>官网指路：https://www.eclipse.org/collections/</p>
<p>使用请看这篇文章：https://www.baeldung.com/eclipse-collections</p>
</li>
</ul>
</div></template>


