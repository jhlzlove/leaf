<template><div><h1 id="权限管理" tabindex="-1"><a class="header-anchor" href="#权限管理" aria-hidden="true">#</a> 权限管理</h1>
<p>权限系统可以保护某些接口不被其它人滥用，从而提升系统的安全性。你也可以简单理解为专门为某一部分人开放的特权，都是可以的。现在的权限管理基本都是基于
RBAC（Role Base Access Control）或者 RBAC 的变体，但其本质相差不大，落到实地的话就是表之间的关联关系较多较杂。</p>
<h2 id="为什么-rbac-这么好用" tabindex="-1"><a class="header-anchor" href="#为什么-rbac-这么好用" aria-hidden="true">#</a> 为什么 RBAC 这么好用</h2>
<p>二八定律阐明了高级用户与其他用户的数量，那么基于此就有了 RBAC。</p>
<p>高级权限、特别权限、定制权限只是少部分人才能拥有的。但是像浪子一样的普通用户有很多，基数较大，拥有的权限并无太大的变化。当新用户注册的时候，每次手动给用户授权，开放一个一个的权限则会浪费很多的时间（一个一个是因为某些系统的权限系统粒度较小）。当然这部分也可以每次授权的时候选择默认值，然后根据不同的用户再进行不同权限的选择，这样仍然较为麻烦。</p>
<p>RBAC 模型就提供了一种较好的实现：先把对应的权限（比如访问路径、操作菜单等）赋给一个角色，用户需要什么权限，就关联一个角色。如果用户需要更改权限，直接修改用户-角色的关联关系即可自动继承角色对应的权限。不仅节省时间，还利于维护。</p>
<p>所以这样看起来，RBAC 也是一种代理模式，角色充当了多个权限的代理，用户通过这个代理可以访问对应的资源。</p>
<p>固定权限 + 定制权限：一般对于系统来讲，我们需要分部门，部门拥有的权限都是固定的，然后对于里面的成员处于不同的岗位将会拥有不一样的权限。这样就多出了两个分支：部门、岗位。
我们可以把部门视作用户组，而岗位就是把用户组的用户再细分一次。这就是 RBAC 模型的变种之一。</p>
<p>举例子说废话：</p>
<p>体育部有两个人：風逍遥和李逍遥，風逍遥是体育部部长，李逍遥是体育部成员。加入体育部便拥有该部门的基本权限，相对来说，部长拥有一些成员没有的权限，例如可以对体育部架构和人员进行修改、调动。</p>
<p>广播部也有两个人：素还真和史艳文，素还真是广播部部长，史艳文是广播部成员。广播的内容是需要部长拍板定砖的，史艳文广播的内容部长选定的稿子。</p>
<p>以上只是学校中的两个简单部门，可能还有很多其它的部门，每个部门都有部长、成员甚至是其它的岗位，那么有必要为每个部门都设置一个具体的角色？这样的话显然要造出很多的角色，这些角色只是管理的模块不同。</p>
<p>所以呢</p>
<div class="language-mermaid line-numbers-mode" data-ext="mermaid"><pre v-pre class="language-mermaid"><code><span class="token keyword">graph</span> LR
user1<span class="token text string">((user1))</span> <span class="token arrow operator">--></span> 部门1 <span class="token arrow operator">--></span> 岗位1 <span class="token arrow operator">--></span> 角色1 <span class="token arrow operator">--></span> 权限列表1

u2<span class="token text string">((user2))</span> <span class="token arrow operator">--></span> 部门1 <span class="token arrow operator">--></span> 岗位2 <span class="token arrow operator">--></span> 角色2 <span class="token arrow operator">-></span> 权限列表2

u3<span class="token text string">((user3))</span> <span class="token arrow operator">--></span> 部门2 <span class="token arrow operator">--></span> 岗位1 <span class="token arrow operator">--></span> 角色3 <span class="token arrow operator">-></span> 权限列表2
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>据此，我们可以插入一个大的级别：部门，每个部门创建的时候直接和该部门的基础权限绑定，加入部门的成员自动继承这些权限。对于该部门的领导之类的新建不同的角色即可。</p>
</div></template>


