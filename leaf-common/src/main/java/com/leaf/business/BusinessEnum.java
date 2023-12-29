package com.leaf.business;

/**
 * 业务模块枚举，这样便于维护吧。但是如果业务很多，文件会很长；但是接口打日志可以直接使用，统一管理
 * 任何事情都有两面性，欸嘿~
 *
 * @author jhlz
 * @version 1.0.0
 * @since 2022/12/10 16:03
 */
public enum BusinessEnum {
    UNKNOWN("未知", BusinessType.OTHER, "默认未知操作"),
    LOGIN("登录模块", BusinessType.LOGIN, "用户登录"),
    LOGOUT("登录模块", BusinessType.LOGOUT, "用户登出"),
    MENU("菜单模块", BusinessType.ALL, "菜单列表"),
    // ---------------------- 用户 ---------------------------
    LIST_USER("系统用户管理", BusinessType.ALL, "用户分页列表信息"),
    GET_USER("系统用户管理", BusinessType.SELECT, "根据 id 获取用户"),
    ADD_USER("系统用户管理", BusinessType.ADD, "添加用户"),
    UPDATE_USER("系统用户管理", BusinessType.UPDATE, "更新用户"),
    DELETE_USER("系统用户管理", BusinessType.DELETE, "删除用户"),
    ;

    /**
     * 模块标题
     */
    private String module;
    /**
     * 操作类型（0其它 1新增 2修改 3删除）
     */
    private BusinessType type;
    /**
     * 说明
     */
    private String desc;

    BusinessEnum(String module, BusinessType type, String desc) {
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

    public BusinessType getType() {
        return type;
    }

    public void setType(BusinessType type) {
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

    /**
     * 简单的东西写在一起，便于维护，如果后期添加的多了，可以考虑移出去
     */
    enum BusinessType {
        /**
         * 登录
         */
        LOGIN,
        /**
         * 退出
         */
        LOGOUT,
        /**
         * 列表
         */
        ALL,
        /**
         * 查询
         */
        SELECT,
        /**
         * 添加
         */
        ADD,
        /**
         * 修改
         */
        UPDATE,
        /**
         * 删除
         */
        DELETE,
        /**
         * 导出
         */
        EXPORT,
        /**
         * 导入
         */
        IMPORT,
        /**
         * 其它，默认值
         */
        OTHER,
    }
}
