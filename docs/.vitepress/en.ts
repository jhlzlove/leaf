import {defineConfig} from "vitepress";

export const en = defineConfig({
    lang: 'en-US',
    title: 'Leaf',
    description: 'jhlz\'s open-source project, use vuepress2 generator docs site',
    themeConfig: {
        sidebar: [
            {
                text: 'Guide',
                items: [
                    {text: "guide", link: "/guide/"},
                ],
            },
        ],
    },

});
