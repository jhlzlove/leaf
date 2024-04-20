import {defineConfig} from "vitepress";

/**
 * 使用 defineConfig 可以触发 IDE 对 ts 的智能支持（IDE 支持的情况下）
 */
export default defineConfig({
    base: '/leaf/',
    // 简洁的 url https://vitepress.dev/zh/guide/routing#generating-clean-url
    cleanUrls: true,
    // favicon 将 favicon.ico 放在公共目录中，如果设置了 base，则使用 /base/favicon.ico
    head: [['link', {rel: 'icon', href: '/leaf/images/logo.png'}]],
    // md 配置
    markdown: {
        lineNumbers: true,
        // 单语言站点非常好用
        // container: {
        //     tipLabel: '提示',
        //     warningLabel: '警告',
        //     dangerLabel: '危险',
        //     infoLabel: '信息',
        //     detailsLabel: '详细信息'
        // }
    },
    lastUpdated: true,
    // 网站国际化的配置 https://vitepress.dev/zh/guide/i18n
    locales: {
        root: {
            label: "简体中文",
            lang: 'zh-CN',
            // 网站标题
            title: 'Leaf Project',
            description: '江湖浪子开源的一个小项目，使用 vuepress2 搭建的文档说明',

            // 主题配置
            themeConfig: {
                search: {
                    provider: 'algolia',
                    options: {
                        appId: 'da8a0db612dbccec2d70cd2ba595063c',
                        apiKey: 'f6b0e657b1196c0d9e9ac8adee43d9ea',
                        indexName: 'jhlzlove-blog'
                    },
                    locales: {
                        placeholder: "搜索文档",
                    }
                },
                // 项目标题旁的 logo
                logo: '/images/logo.png',
                // 页脚
                footer: {
                    message: '请遵循 <a href="https://github.com/vuejs/vitepress/blob/main/LICENSE">MIT License</a> 协议',
                    copyright: '<a href="https://jhlzlove.github.io">[ Copyright © 2023-latest jhlz. X ]</a>'
                },
                // 导航栏 社交链接
                socialLinks: [
                    {icon: 'github', link: 'https://github.com/jhlzlove/leaf'},
                    // 也可以为无障碍添加一个自定义标签 (可选但推荐):
                    {
                        icon: {
                            svg: '<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Dribbble</title><path d="M12...6.38z"/></svg>'
                        },
                        link: '...',
                        // 也可以为无障碍添加一个自定义标签 (可选但推荐):
                        ariaLabel: 'cool link'
                    }
                ],
                //
                lastUpdated: {
                    text: '最后更新',
                    formatOptions: {
                        dateStyle: 'short',
                        timeStyle: 'medium'
                    }
                },
                editLink: {
                    pattern: 'https://github.com/jhlzlove/leaf/edit/dev/docs/:path',
                    text: '帮助完善本页！'
                },
                docFooter: {
                    prev: '上一页',
                    next: '下一页'
                },
                // 目录显示层级和标题
                outline: {label: "本文目录"},
                darkModeSwitchTitle: "深色",
                lightModeSwitchTitle: "亮色",
                sidebar: [
                    {
                        text: "指南",
                        items: [
                            {text: "Why?", link: "/guide/1-about"},
                            {text: "构建 & 部署", link: "/guide/2-build"},
                            {text: "数据库结构", link: "/guide/3-database"},
                            {text: "项目总结", link: "/guide/4-summary"},
                        ],
                    },
                    {
                        text: '进阶',
                        items: [
                            {text: "Gradle", link: "/advanced/1-gradle"},
                            {text: "Logback", link: "/advanced/2-logback"},
                            {text: "Jackson", link: "/advanced/3-jackson"},
                            {text: "SpringDataJPA", link: "/advanced/4-spring-data-jpa"},
                            {text: "权限管理", link: "/advanced/5-permission"},
                            {text: "Jimmer", link: "/advanced/6-jimmer"},
                        ],
                    },
                    {
                        text: '其它',
                        collapsed: true,
                        items: [
                            {text: "常见问题", link: "/other/常见问题"},
                            {text: "更新记录", link: "/other/更新记录"},
                        ],
                    },
                ],
            }
        },
        en: {
            label: "English",
            lang: 'en-US',
            title: 'Leaf',
            description: 'jhlz\'s open-source project, use vuepress2 generator docs site',
            themeConfig: {
                logo: '/images/logo.png',
                search: {
                    provider: 'algolia',
                    options: {
                        appId: 'da8a0db612dbccec2d70cd2ba595063c',
                        apiKey: 'f6b0e657b1196c0d9e9ac8adee43d9ea',
                        indexName: 'jhlzlove-blog'
                    },
                    locales: {
                        placeholder: "Search...",
                    },
                    sidebar: [
                        {
                            text: 'Guide',
                            items: [
                                {text: "guide", link: "/guide/"},
                            ],
                        },
                    ],
                }
            },
        }
    })
