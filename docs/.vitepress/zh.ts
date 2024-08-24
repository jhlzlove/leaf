// 中文配置项
import {DefaultTheme, defineConfig} from "vitepress";

export const zh = defineConfig({
    lang: 'zh-CN',
    description: '一个 Java 编写的简单的前后端分离框架',

    // 主题配置
    themeConfig: {
        // 页脚
        footer: {
            message: '请遵循 <a href="https://github.com/vuejs/vitepress/blob/main/LICENSE">MIT License</a> 协议',
            copyright: '<a href="https://jhlzlove.github.io">[ Copyright © 2023-latest jhlz. X ]</a>'
        },
        // 编辑链接
        editLink: {
            pattern: 'https://github.com/jhlzlove/leaf/edit/dev/docs/:path',
            text: '帮助完善本页！'
        },
        // 文章页脚上下页切换
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
                {text: "常见问题", link: "other/常见问题"},
                {text: "更新记录", link: "other/更新记录"},
            ]
        },
    ]
}

function nav(): DefaultTheme.NavItem[] {
    return []
}
