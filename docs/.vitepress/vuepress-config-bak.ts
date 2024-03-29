// import {defaultTheme} from "@vuepress/theme-default";
// import viteBundler from "@vuepress/bundler-vite";

export default {
    base: '/leaf/',
    // favicon
    head: [['link', {rel: 'icon', href: '/images/logo.png'}]],
    // 网站支持的不同语言的配置
    locales: {
        // 作为特例，/ 为网站默认使用的语言。
        '/': {
            lang: 'zh-CN',
            title: 'Leaf Project',
            description: '江湖浪子开源的一个小项目，使用 vuepress2 搭建的文档说明',
        },
        '/en/': {
            lang: 'en-US',
            title: 'Leaf',
            description: 'jhlz\'s open-source project, use vuepress2 generator docs site',
        },
    },
    // bundler: viteBundler(),
    // defaultTheme
    theme: ({
        // 项目 logo 位于项目名称旁边
        // 也可以设置为一个 URL，例如：https://gitlab.com/foo/image.jpg
        logo: '/images/logo.png',
        // GitHub 仓库，也可以设置为一个 URL，例如：https://gitlab.com/foo/bar
        repo: 'jhlzlove/leaf',
        // 源文件所在分支
        docsBranch: 'dev',
        // 源文件所在仓库的目录
        docsDir: 'docs',

        // 侧边栏显示深度到 <h2>，其它不显示
        sidebarDepth: 1,
        // 多语言主题配置
        locales: {
            '/': {
                selectLanguageText: '选择语言',
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
                // 自定义容器的提示词 https://ecosystem.vuejs.press/zh/themes/default/markdown.html#%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AE%B9%E5%99%A8
                tip: '提示',
                warning: '注意',
                danger: '警告',
                // 侧边栏目录
                sidebar: [
                    {
                        text: '指南',
                        children: [
                            '/guide/',
                            '/guide/3-database.md',
                            '/guide/4-summary.md',
                        ],
                    },
                    {
                        text: '进阶',
                        children: [
                            '/advanced/1-gradle.md',
                            '/advanced/2-logback.md',
                            '/advanced/3-jackson.md',
                            '/advanced/4-spring-data-jpa.md',
                            '/advanced/5-permission.md',
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
            // 英文配置，不可能有英文哒
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