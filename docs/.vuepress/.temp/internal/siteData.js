export const siteData = JSON.parse("{\"base\":\"/leaf/\",\"lang\":\"en-US\",\"title\":\"\",\"description\":\"\",\"head\":[[\"link\",{\"rel\":\"icon\",\"href\":\"/image/logo.png\"}]],\"locales\":{\"/\":{\"lang\":\"zh-CN\",\"title\":\"小叶子\",\"description\":\"江湖浪子开源的一个小项目，使用 vuepress2 搭建的文档说明\"},\"/en\":{\"lang\":\"English\",\"title\":\"Leaf\",\"description\":\"jhlz's open-source project, use vuepress2 generator docs site\"}}}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updateSiteData) {
    __VUE_HMR_RUNTIME__.updateSiteData(siteData)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ siteData }) => {
    __VUE_HMR_RUNTIME__.updateSiteData(siteData)
  })
}
