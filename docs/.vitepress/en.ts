// 英文配置项
import {DefaultTheme, defineConfig} from "vitepress";

export const en = defineConfig({
    lang: "en-US",
    description: "A simple front-end/back-end separation framework written in Java.",

    themeConfig: {
        sidebar: {
            "/": {base: "/", items: sidebarEn()},
        },
    },

});

function sidebarEn(): DefaultTheme.SidebarItem[] {
    return [
        {
            text: "Guide",
            base: "/guide/",
            items: [
                {text: "guide", link: "index"},
            ]
        }
    ]
}