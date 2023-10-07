package com.leaf.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/17 10:32
 */
public class FreemarkerUtil {
    private static final Logger log = LoggerFactory.getLogger(FreemarkerUtil.class);
    private static final String FTL_PATH = "leaf-code-generation\\src\\main\\resources\\templates";
    private static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_32);

    static {
        CFG.setDefaultEncoding("utf-8");
        try {
            CFG.setDirectoryForTemplateLoading(new File(FTL_PATH));
        } catch (IOException e) {
            log.error("配置失败，该路径不存在！{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void generator(@Nullable String ftlName, Map<String, Object> data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fileWriter);) {
            Template temp = CFG.getTemplate(ftlName);
            temp.process(data, fileWriter);
            bw.flush();
        } catch (IOException e) {
            log.error("文件生成失败！{}", e.getMessage());
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            log.error("模板异常：{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
