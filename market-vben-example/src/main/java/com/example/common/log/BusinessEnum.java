package com.example.common.log;

/**
 * 业务模块枚举说明
 *
 * @author: jhlz
 * @since: 2022/12/10 16:03:57
 */
public enum BusinessEnum {
    UNKNOWN("未知", 0, "默认未知操作"),
    LOGIN("登录模块", 1, "用户登录"),
    MENU("菜单模块", 0, "菜单列表"),
    ;

    /**
     * 模块标题
     */
    private String module;
    /**
     * 操作类型（0其它 1新增 2修改 3删除）
     */
    private Integer type;
    /**
     * 说明
     */
    private String desc;

    BusinessEnum(String module, Integer type, String desc) {
        this.module = module;
        this.type = type;
        this.desc = desc;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}