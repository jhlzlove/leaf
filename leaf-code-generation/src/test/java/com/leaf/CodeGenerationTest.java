package com.leaf;

import com.leaf.util.FreemarkerUtil;
import freemarker.template.Template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/5 10:38
 */
public class CodeGenerationTest {
    private static Template template = null;
    Map<String, Object> dataMap = new HashMap<String, Object>();

    public void buildData() {
        dataMap.put("package", this.getClass().getPackage() + ";");
        dataMap.put("className", "Test");
        dataMap.put("serviceClassName", "Test");
        dataMap.put("lowerClassName", "test");
        FreemarkerUtil.generator("controller.ftl", dataMap, "leaf-code-generation\\src\\main\\java\\com\\leaf\\TestController.java");
    }

    public static void main(String[] args) {
        CodeGenerationTest codeGeneration = new CodeGenerationTest();
        // codeGeneration.buildData();
    }


}
