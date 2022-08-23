package com.example.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回状态的定义
 * 有新的返回状态类型时，应当明确其错误码的范围
 */
public interface RespStatus {


    /**
     * 通用的错误码
     */
    @Getter
    @AllArgsConstructor
    enum Common implements RespStatus {
        SUCCESS(0, "成功"),
        ERROR_UNKNOWN(-1, "未知错误"),
        ERROR_SESSION_ERROR(-2, "因页面停留超时或账号发生变动，请重新登录。"),
        ERROR_SQL_RESULT_ERROR(-3, "数据操作错误"),
        ERROR_PARAM_NOT_VALID(-4, "请求参数不合法错误"),
        ERROR_SYSTEM(-5, "服务繁忙，请稍后重试"),
        NOT_FOUND(-6, "未找到资源"),
        ERROR_PASSWORD(-7, "原密码不正确"),
        ERROR_UPLOAD_FILE(-8, "上传文件报错"),
        ERROR_FORMAT_FILE(-9, "文件格式不正确"),
        ERROR_PARAM_NOT_NULL(-10, "请求参数不能为空"),
        NOT_NULL_SQL(-12, "SQL语句为空或格式不正确"),
        INVALIDATE_SQL(-13, "SQL语句不合法,存在恶意行为"),
        UPDATE_VALIDATE_SQL(-14, "更新语句存在恶意操作,被拒绝执行"),
        INSERT_VALIDATE_SQL(-15, "新增语句存在恶意操作,被拒绝执行"),
        NOT_FOUNT_USER(-16, "账号不存在"),
        NOT_FOUNT_BROWSER_UUID(-17, "浏览器唯一标识不能为空"),
        NOT_FOUNT_WECHAT_LIST(-18, "微信好友集合为空");;

        private int code;
        private String message;
    }


    /**
     * 返回码
     */
    int getCode();

    /**
     * 错误信息，返回码为0时，该值为空
     */
    String getMessage();
}
