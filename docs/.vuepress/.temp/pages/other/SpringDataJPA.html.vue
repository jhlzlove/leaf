<template><div><h2 id="_1-注解" tabindex="-1"><a class="header-anchor" href="#_1-注解" aria-hidden="true">#</a> 1. 注解</h2>
<h3 id="entity、-table、-id、-generatedvalue" tabindex="-1"><a class="header-anchor" href="#entity、-table、-id、-generatedvalue" aria-hidden="true">#</a> @Entity、@Table、@Id、@GeneratedValue</h3>
<p>使用 JPA 实体类需要添加 <code v-pre>@Entity</code> 声明该类是一个实体。该注解可以用一个 name
属性来标识对应的数据库的表名。当然也可以和另一个注解共同使用 <code v-pre>@Table</code> 实现同样的效果。</p>
<p>使用 <code v-pre>@Entity</code> 注解的类必须使用 <code v-pre>@Id</code> 注解，这两个注解 <strong>必须</strong> 同时出现。<code v-pre>@GeneratedValue</code> 指定 id
列的值的增长策略规范，默认为 <code v-pre>AUTO</code>，一般设置为 <code v-pre>@GeneratedValue(strategy = GenerationType.IDENTITY)</code>
，表示使用数据库的自增策略。除此之外，还有 <code v-pre>TABLE</code>、<code v-pre>SEQUENCE</code>、<code v-pre>UUID</code>。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token comment">// 下面两种写法选一种使用即可</span>
<span class="token annotation punctuation">@Entity</span><span class="token punctuation">(</span>name <span class="token operator">=</span> <span class="token string">"表名"</span><span class="token punctuation">)</span>
<span class="token comment">// OR</span>
<span class="token annotation punctuation">@Entity</span>
<span class="token annotation punctuation">@Table</span><span class="token punctuation">(</span><span class="token string">"表名"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">User</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Id</span>
    <span class="token annotation punctuation">@GeneratedValue</span><span class="token punctuation">(</span>strategy <span class="token operator">=</span> <span class="token class-name">GenerationType</span><span class="token punctuation">.</span><span class="token constant">IDENTITY</span><span class="token punctuation">)</span>
    <span class="token keyword">private</span> <span class="token class-name">Long</span> id<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="transient" tabindex="-1"><a class="header-anchor" href="#transient" aria-hidden="true">#</a> @Transient</h3>
<p>如果在实体类中出现了数据库中没有的字段，可以在该字段上使用 <code v-pre>@Transient</code> 注解，此注解表明该字段不参与数据持久化。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token comment">// omit other annotation</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">User</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Id</span>
    <span class="token keyword">private</span> <span class="token class-name">Long</span> id<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Transient</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> ignoreValue<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="onetoone、-onetomany、-manytoone、-manytomany、-manytoany" tabindex="-1"><a class="header-anchor" href="#onetoone、-onetomany、-manytoone、-manytomany、-manytoany" aria-hidden="true">#</a> @OneToOne、@OneToMany、@ManyToOne、@ManyToMany、@ManyToAny</h3>
<p>如果该实体有一对多的关系，使用集合需要在属性上添加 <code v-pre>@OneToMany</code>
注解。同理，还有一个 <code v-pre>@ManyToMany</code> 注解代表多对多的关系，其它类似。下面是最最最简单的使用，具体使用推荐看这几个注解的源码注释。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token comment">// omit other annotation</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">User</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Id</span>
    <span class="token keyword">private</span> <span class="token class-name">Long</span> id<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@OneToMany</span> <span class="token comment">// 一对多关系</span>
    <span class="token keyword">private</span> <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Role</span><span class="token punctuation">></span></span> roles<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@ManyToMany</span> <span class="token comment">// 多对多关系</span>
    <span class="token keyword">private</span> <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Condition</span><span class="token punctuation">></span></span> conditions<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="dynamicinsert、-dynamicupdate-spring6-0-已弃用" tabindex="-1"><a class="header-anchor" href="#dynamicinsert、-dynamicupdate-spring6-0-已弃用" aria-hidden="true">#</a> @DynamicInsert、@DynamicUpdate(Spring6.0 已弃用)</h3>
<p>@DynamicInsert：指定注释实体的SQL插入语句是动态生成的，只插入实体对象的非空属性列。如果实体在第一次持久化时可能具有许多空属性，那么这可能会提高性能。但是，在运行时生成SQL会产生一定的成本。
@DynamicUpdate：动态更新，只更新改变的列值，若不开启（false），调用更新接口会根据传入的对象的所有字段进行更新（对于没有传的字段，会以
null 值覆盖更新）。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token comment">// omit other annotation</span>
<span class="token annotation punctuation">@DynamicInsert</span>
<span class="token annotation punctuation">@DynamicUpdate</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">User</span> <span class="token punctuation">{</span>
    <span class="token comment">// ...</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="mappedsuperclass" tabindex="-1"><a class="header-anchor" href="#mappedsuperclass" aria-hidden="true">#</a> @MappedSuperclass</h3>
<p>抽取使用公共属性类时，需要在公共属性类上加入 @MappedSuperclass 注解。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code>
<span class="token annotation punctuation">@MappedSuperclass</span>
<span class="token keyword">public</span> <span class="token keyword">abstract</span> <span class="token keyword">class</span> <span class="token class-name">BaseEntity</span> <span class="token keyword">implements</span> <span class="token class-name">Serializable</span> <span class="token punctuation">{</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token keyword">final</span> <span class="token keyword">long</span> serialVersionUID <span class="token operator">=</span> <span class="token number">1L</span><span class="token punctuation">;</span>
    <span class="token doc-comment comment">/** 创建者 */</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> createBy<span class="token punctuation">;</span>

    <span class="token doc-comment comment">/**创建时间 */</span>
    <span class="token keyword">private</span> <span class="token class-name">LocalDateTime</span> createTime<span class="token punctuation">;</span>

    <span class="token doc-comment comment">/** 更新者 */</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> updateBy<span class="token punctuation">;</span>

    <span class="token doc-comment comment">/** 更新时间 */</span>
    <span class="token keyword">private</span> <span class="token class-name">LocalDateTime</span> updateTime<span class="token punctuation">;</span>

    <span class="token doc-comment comment">/** 备注 */</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> remark<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="pageabledefault" tabindex="-1"><a class="header-anchor" href="#pageabledefault" aria-hidden="true">#</a> @PageableDefault</h3>
<p>将 <code v-pre>Pageable</code> 注入控制器方法时设置默认值的注释，其默认值为 page = 0, size = 10。您也可以使用 <code v-pre>SortDefault</code>
或 <code v-pre>SortDefault.SortDefaults</code> 来代替配置 <code v-pre>sort()</code> 和 <code v-pre>direction()</code>。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code><span class="token keyword">class</span> <span class="token class-name">UserController</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 如果没有传入 Pageable 对象的 page、size 值，则默认设置为 page=0，size=20
     */</span>
    <span class="token annotation punctuation">@GetMapping</span>
    <span class="token keyword">public</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">listPage</span><span class="token punctuation">(</span><span class="token annotation punctuation">@PageableDefault</span><span class="token punctuation">(</span>page <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">,</span> size <span class="token operator">=</span> <span class="token number">20</span><span class="token punctuation">)</span> <span class="token class-name">Pageable</span> page<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> userService<span class="token punctuation">.</span><span class="token function">listPage</span><span class="token punctuation">(</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="entitylisteners、-enablejpaauditing" tabindex="-1"><a class="header-anchor" href="#entitylisteners、-enablejpaauditing" aria-hidden="true">#</a> @EntityListeners、@EnableJpaAuditing</h3>
<p>开启 JPA
审计功能，可以在我们的操作中自动的更新一些公共字段：创建者、更新者、创建时间、更新时间，这样我们无须在程序中手动设置。使用该功能，需要在 <code v-pre>Application</code>
启动类上加入 <code v-pre>@EnableJpaAuditing</code> 开启。
具体使用详见：https://www.baeldung.com/database-auditing-jpa</p>
<h3 id="modifying、-query" tabindex="-1"><a class="header-anchor" href="#modifying、-query" aria-hidden="true">#</a> @Modifying、@Query</h3>
<p>在 Spring Data Jpa 中，使用 <code v-pre>@Modifying</code> 注解的方法，自身或者调用方至少其中之一必须添加事务确保数据的四大特性，如果不添加事务控制则会输出以下内容且不执行该
SQL：</p>
<div class="language-bash line-numbers-mode" data-ext="sh"><pre v-pre class="language-bash"><code>Executing an update/delete query
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><h3 id="enablejparepositories、-repository" tabindex="-1"><a class="header-anchor" href="#enablejparepositories、-repository" aria-hidden="true">#</a> @EnableJpaRepositories、@Repository</h3>
<p>这两个注解和 MyBatis 的 @MapperScan 和 @Mapper 的关系是一样的，本项目使用的局部。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code>
<span class="token annotation punctuation">@SpringBootApplication</span>
<span class="token annotation punctuation">@EnableJpaRepositories</span><span class="token punctuation">(</span>basePackages <span class="token operator">=</span> <span class="token string">"com.leaf.system.repository"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">LeafApplication</span> <span class="token punctuation">{</span>
    <span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="_2-持久层" tabindex="-1"><a class="header-anchor" href="#_2-持久层" aria-hidden="true">#</a> 2. 持久层</h2>
<p>持久层类可以实现两个接口：<code v-pre>JpaRepository&lt;T, O&gt;</code>, <code v-pre>CrudRepository&lt;T, O&gt;</code>，开发中任意选择。<code v-pre>JpaRepository</code>
接口提供的功能更多，有分页、按字段排序等。本项目都使用 <code v-pre>JpaRepository</code>。</p>
<h2 id="_3-分页-pagerequest、pageable、page、pageimpl" tabindex="-1"><a class="header-anchor" href="#_3-分页-pagerequest、pageable、page、pageimpl" aria-hidden="true">#</a> 3. 分页(PageRequest、Pageable、Page、PageImpl)</h2>
<p>Pageable 是一个分页接口，PageRequest 是它的子类。我们可以使用 PageRequest 提供的几个 <code v-pre>of()</code> 方法手动构造分页对象，查询时传入此参数实现分页查询和排序。</p>
<p>Page 也是一个接口，PageImpl 是它的实现类，PageImpl 可以构造最终返回的分页列表信息。它的构造方法接收三个参数：结果集，Pageable，总记录数。</p>
<div class="language-java line-numbers-mode" data-ext="java"><pre v-pre class="language-java"><code>
<span class="token annotation punctuation">@Service</span>
<span class="token keyword">class</span> <span class="token class-name">UserServiceImpl</span> <span class="token keyword">implements</span> <span class="token class-name">UserService</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 第一种分页方法
     * <span class="token keyword">@param</span> <span class="token parameter">page</span>  接收的 Pageable 对象
     * <span class="token keyword">@return</span> 分页数据
     */</span>
    <span class="token keyword">public</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">page01</span><span class="token punctuation">(</span><span class="token class-name">Pageable</span> page<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> userRepository<span class="token punctuation">.</span><span class="token function">findAll</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">PageImpl</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span><span class="token punctuation">(</span>list<span class="token punctuation">,</span> page<span class="token punctuation">,</span> list<span class="token punctuation">.</span><span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token doc-comment comment">/**
     * 第二种分页方法
     * <span class="token keyword">@param</span> <span class="token parameter">page</span>  接收的 Pageable 对象
     * <span class="token keyword">@return</span> 分页数据
     */</span>
    <span class="token keyword">public</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">page02</span><span class="token punctuation">(</span><span class="token class-name">Pageable</span> page<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> userRepository<span class="token punctuation">.</span><span class="token function">findAll</span><span class="token punctuation">(</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token doc-comment comment">/**
     * 手动构造分页对象
     * <span class="token keyword">@return</span> 分页数据
     */</span>
    <span class="token keyword">public</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">page03</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">PageRequest</span> page <span class="token operator">=</span> <span class="token class-name">PageRequest</span><span class="token punctuation">.</span><span class="token function">of</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> userRepository<span class="token punctuation">.</span><span class="token function">findAll</span><span class="token punctuation">(</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token keyword">private</span> <span class="token keyword">final</span> <span class="token class-name">UserRepository</span> userRepository<span class="token punctuation">;</span>

    <span class="token keyword">public</span> <span class="token class-name">UserServiceImpl</span><span class="token punctuation">(</span><span class="token class-name">UserRepository</span> userRepository<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>userRepository <span class="token operator">=</span> userRepository<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="驱动版本" tabindex="-1"><a class="header-anchor" href="#驱动版本" aria-hidden="true">#</a> 驱动版本</h2>
</div></template>


