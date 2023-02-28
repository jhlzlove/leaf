package com.leaf.common.business;

/**
 * 业务模块枚举说明
 *
 * @author: jhlz
 * @since: 2022/12/10 16:03:57
 */
public enum BusinessEnum {
    UNKNOWN("未知", 0, "默认未知操作"),
    LOGIN("登录模块", 1, "用户登录"),
    LOGOUT("登录模块", 1, "用户登出"),
    MENU("菜单模块", 0, "菜单列表"),
    // ---------------------- 用户 ---------------------------
    LIST_USER("系统用户管理", 0, "用户分页列表信息"),
    GET_USER("系统用户管理", 0, "根据 id 获取用户"),
    ADD_USER("系统用户管理", 1, "添加用户"),
    UPDATE_USER("系统用户管理", 2, "更新用户"),
    DELETE_USER("系统用户管理", 3, "删除用户"),
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

    @Override
    public String toString() {
        return "BusinessEnum{" +
                "module='" + module + '\'' +
                ", type=" + type +
                ", desc='" + desc + '\'' +
                '}';
    }
}
