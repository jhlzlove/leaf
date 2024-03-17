export const themeData = JSON.parse("{\"logo\":\"/image/logo.png\",\"repo\":\"jhlzlove/leaf\",\"docsBranch\":\"dev\",\"docsDir\":\"docs\",\"sidebarDepth\":1,\"locales\":{\"/\":{\"selectLanguageName\":\"简体中文\",\"editLinkText\":\"帮助浪子修改此页！\",\"lastUpdatedText\":\"最后修改于\",\"contributorsText\":\"本页贡献者\",\"toggleColorMode\":\"常夜切换\",\"backToHome\":\"返回首页\",\"sidebar\":[{\"text\":\"指南\",\"children\":[\"/guide/\",\"/guide/1-数据库结构.md\"]},{\"text\":\"进阶\",\"children\":[\"/advanced/Jackson.md\",\"/advanced/SpringDataJPA.md\",\"/advanced/权限管理.md\",\"/advanced/项目总结.md\"]},{\"text\":\"其它\",\"children\":[\"/other/常见问题.md\",\"/other/更新记录.md\"]}]},\"/en/\":{\"selectLanguageName\":\"English\",\"sidebar\":[{\"text\":\"Guide\",\"children\":[\"/guide/\"]}]}},\"colorMode\":\"auto\",\"colorModeSwitch\":true,\"navbar\":[],\"selectLanguageText\":\"Languages\",\"selectLanguageAriaLabel\":\"Select language\",\"sidebar\":\"auto\",\"editLink\":true,\"editLinkText\":\"Edit this page\",\"lastUpdated\":true,\"lastUpdatedText\":\"Last Updated\",\"contributors\":true,\"contributorsText\":\"Contributors\",\"notFound\":[\"There's nothing here.\",\"How did we get here?\",\"That's a Four-Oh-Four.\",\"Looks like we've got some broken links.\"],\"backToHome\":\"Take me home\",\"openInNewWindow\":\"open in new window\",\"toggleColorMode\":\"toggle color mode\",\"toggleSidebar\":\"toggle sidebar\"}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updateThemeData) {
    __VUE_HMR_RUNTIME__.updateThemeData(themeData)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ themeData }) => {
    __VUE_HMR_RUNTIME__.updateThemeData(themeData)
  })
}
