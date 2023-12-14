import {defaultTheme} from "vuepress";

export default {
    base: '/leaf/',
    head: [['link', {rel: 'icon', href: '/images/logo.png'}]],
    // 文档多语言时主页显示标题和介绍
    locales: {
        // 键名是该语言所属的子路径
        // 作为特例，默认语言可以使用 '/' 作为其路径。
        '/': {
            lang: 'zh-CN',
            title: 'Leaf Project',
            description: '江湖浪子开源的一个小项目，使用 vuepress2 搭建的文档说明',
        },
        '/en': {
            lang: 'English',
            title: 'Leaf',
            description: 'jhlz\'s open-source project, use vuepress2 generator docs site',
        },
    },
    theme: defaultTheme({
        // public 文件路径，也可以设置为一个 URL，例如：https://gitlab.com/foo/image.jpg
        logo: '/images/logo.png',
        // GitHub 仓库，也可以设置为一个 URL，例如：https://gitlab.com/foo/bar
        repo: 'jhlzlove/leaf',
        // 源文件所在分支
        docsBranch: 'dev',
        // 源文件所在文件夹
        docsDir: 'docs',

        // 侧边栏
        sidebarDepth: 1,
        locales: {
            '/': {
                selectLanguageName: '简体中文',
                // 默认值： 'Edit this page'
                editLinkText: '帮助浪子修改此页！',
                // 默认值： 'Last Updated'
                lastUpdatedText: '最后修改于',
                // 默认值： 'Contributors'
                contributorsText: '本页贡献者',
                // 默认值： 'toggle color mode'
                toggleColorMode: '常夜切换',
                // 默认值： 'Back to home'
                backToHome: '返回首页',
                sidebar: [
                    {
                        text: '指南',
                        children: [
                            '/guide/',
                            '/guide/1-数据库结构.md',
                            '/guide/2-总结.md',
                        ],
                    },
                    {
                        text: '进阶',
                        children: [
                            '/advanced/1-Gradle.md',
                            '/advanced/2-Logback.md',
                            '/advanced/3-Jackson.md',
                            '/advanced/4-SpringDataJPA.md',
                            '/advanced/5-权限管理.md',
                        ],
                    },
                    {
                        text: '其它',
                        // link 需要写一个可以到达的路径
                        // link: '/advanced/常见问题.md',
                        // 默认 false，不折叠文章目录，为 true 时自动折叠，不可与 link 共存
                        // collapsible: true,
                        children: [
                            '/other/常见问题.md',
                            '/other/更新记录.md'
                        ],
                    },
                ],
            },

            // index.md README.md 可以不用写
            '/en/': {
                selectLanguageName: 'English',
                sidebar: [
                    {
                        text: 'Guide',
                        children: [
                            '/guide/',
                        ],
                    },
                ],
            }
        }
    }),

}