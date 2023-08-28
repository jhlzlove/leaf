module.exports = {
    base: "/leaf/",
    themeConfig: {
        repo: "jhlzlove/leaf",
        // 假如文档不是放在仓库的根目录下：
        docsDir: "docs",
        docsBranch: "pages",
        lastUpdated: '最后更新于 ',
        // 默认是 false, 设置为 true 来启用
        editLinks: true,
        // 默认为 "Edit this page"
        editLinkText: '帮助我们改善此页面！',
        displayAllHeaders: true,
        nav: [
            {
                text: "Languages",
                items: [
                    {text: "1.0.0", link: ""},
                    {text: "2.0.0", link: ""}
                ]
            }
        ],
        sidebar: [
            {
                title: "简介",
                path: "/",
                children: [
                    "/",
                    "/dev-tools"
                ]
            },
            {
                title: "部署",
                path: "/项目部署",
                children: [
                    "/项目部署",
                    "/数据库设计"
                ]
            },
            {
                title: "项目总结",
                path: "/总结/Jackson",
                sidebarDepth: 1,
                collapsable: true,
                children: [
                    "/总结/Jackson",
                    "/总结/SpringDataJPA",
                    "/总结/权限管理"
                ]
            },
        ]
    }
}