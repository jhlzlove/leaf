import {DefaultTheme, defineConfig} from "vitepress";

export const zh = defineConfig({

    lang: 'zh-CN',
    // 网站标题
    title: 'Leaf Project',
    description: '江湖浪子开源的一个小项目，使用 vuepress2 搭建的文档说明',

    // 主题配置
    themeConfig: {

        // 页脚
        footer: {
            message: '请遵循 <a href="https://github.com/vuejs/vitepress/blob/main/LICENSE">MIT License</a> 协议',
            copyright: '<a href="https://jhlzlove.github.io">[ Copyright © 2023-latest jhlz. X ]</a>'
        },

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

        nav: nav(),
        sidebar: {
            '/': {base: "/", items: sidebarGuide()},
        }
    }

});

function sidebarGuide(): DefaultTheme.SidebarItem[] {
    return [
        {
            text: '简介',
            base: "/guide/",
            collapsed: false,
            items: [
                {text: "Why?", link: "1-about"},
                {text: "构建 & 部署", link: "2-build"},
                {text: "数据库结构", link: "3-database"},
                {text: "项目总结", link: "4-summary"},
            ]
        },
        {
            text: '进阶',
            base: "/advanced/",
            collapsed: false,
            items: [
                {text: "Gradle", link: "1-gradle"},
                {text: "Logback", link: "2-logback"},
                {text: "Jackson", link: "3-jackson"},
                {text: "SpringDataJPA", link: "4-spring-data-jpa"},
                {text: "权限管理", link: "5-permission"},
                {text: "Jimmer", link: "6-jimmer"},
            ]
        },
        {
            text: '其它',
            collapsed: true,
            items: [
                {text: "常见问题", link: "/other/常见问题"},
                {text: "更新记录", link: "/other/更新记录"},
            ]
        },
    ]
}

function nav(): DefaultTheme.NavItem[] {
    return []
}

export const search: DefaultTheme.AlgoliaSearchOptions['locales'] = {
    zh: {
        placeholder: '搜索文档',
        translations: {
            button: {
                buttonText: '搜索文档',
                buttonAriaLabel: '搜索文档'
            },
            modal: {
                searchBox: {
                    resetButtonTitle: '清除查询条件',
                    resetButtonAriaLabel: '清除查询条件',
                    cancelButtonText: '取消',
                    cancelButtonAriaLabel: '取消'
                },
                startScreen: {
                    recentSearchesTitle: '搜索历史',
                    noRecentSearchesText: '没有搜索历史',
                    saveRecentSearchButtonTitle: '保存至搜索历史',
                    removeRecentSearchButtonTitle: '从搜索历史中移除',
                    favoriteSearchesTitle: '收藏',
                    removeFavoriteSearchButtonTitle: '从收藏中移除'
                },
                errorScreen: {
                    titleText: '无法获取结果',
                    helpText: '你可能需要检查你的网络连接'
                },
                footer: {
                    selectText: '选择',
                    navigateText: '切换',
                    closeText: '关闭',
                    searchByText: '搜索提供者'
                },
                noResultsScreen: {
                    noResultsText: '无法找到相关结果',
                    suggestedQueryText: '你可以尝试查询',
                    reportMissingResultsText: '你认为该查询应该有结果？',
                    reportMissingResultsLinkText: '点击反馈'
                }
            }
        }
    }
}