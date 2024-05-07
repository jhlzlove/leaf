import {defineConfig} from "vitepress";
import {search} from "./zh";

export const shared = defineConfig({
    base: '/leaf/',
    // 简洁的 url https://vitepress.dev/zh/guide/routing#generating-clean-url
    cleanUrls: true,
    // favicon 将 favicon.ico 放在公共目录中，如果设置了 base，则使用 /base/favicon.ico
    head: [['link', {rel: 'icon', href: '/leaf/images/logo.png'}]],
    // md 配置
    markdown: {
        lineNumbers: true,
    },
    lastUpdated: true,

    themeConfig: {
        logo: '/images/logo.png',

        socialLinks: [
            {icon: 'github', link: 'https://github.com/jhlzlove/leaf'},
        ],

        search: {
            provider: 'algolia',
            options: {
                appId: 'CMHUOB9KPX',
                apiKey: 'da8a0db612dbccec2d70cd2ba595063c',
                indexName: 'jhlzlove-blog',
                locales: {
                    ...search,
                }
            },
        },
    },

});

