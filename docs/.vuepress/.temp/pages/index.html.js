export const data = JSON.parse("{\"key\":\"v-8daa1a0e\",\"path\":\"/\",\"title\":\"\",\"lang\":\"zh-CN\",\"frontmatter\":{\"home\":true,\"heroImage\":\"image/logo.png\",\"actions\":[{\"text\":\"开始探索之旅 →\",\"link\":\"/guide/README.md\"}],\"features\":[{\"title\":\"简洁至上\",\"details\":\"以 Markdown 为中心的项目结构，以最少的配置帮助你专注于写作。\"},{\"title\":\"Vue 驱动\",\"details\":\"享受 Vue 的开发体验，可以在 Markdown 中使用 Vue 组件，又可以使用 Vue 来开发自定义主题。\"},{\"title\":\"高性能\",\"details\":\"VuePress 会为每个页面预渲染生成静态的 HTML，同时，每个页面被加载的时候，将作为 SPA 运行。\"}],\"footerHtml\":true,\"footer\":\"<a href=\\\"https://jhlzlove.github.io\\\">[ Copyright © 2023-latest jhlz. X ]</a>\"},\"headers\":[{\"level\":2,\"title\":\"简介\",\"slug\":\"简介\",\"link\":\"#简介\",\"children\":[]},{\"level\":2,\"title\":\"Feature\",\"slug\":\"feature\",\"link\":\"#feature\",\"children\":[]},{\"level\":2,\"title\":\"Thanks\",\"slug\":\"thanks\",\"link\":\"#thanks\",\"children\":[]}],\"git\":{\"updatedTime\":1694074359000,\"contributors\":[{\"name\":\"jhlz\",\"email\":\"jhlz99520@163.com\",\"commits\":2}]},\"filePathRelative\":\"README.md\"}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updatePageData) {
    __VUE_HMR_RUNTIME__.updatePageData(data)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ data }) => {
    __VUE_HMR_RUNTIME__.updatePageData(data)
  })
}
