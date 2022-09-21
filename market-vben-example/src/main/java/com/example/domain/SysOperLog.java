package com.example.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author jhlz
 * @since 2022-09-11 16:49:02
 */
@Data
@Entity
@Accessors(chain = true)
public class SysOperLog {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType;
    /**
     * 方法名称
     */
    private String reqMethod;
    /**
     * 请求方式
     */
    private String reqType;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer clientType;
    /**
     * 操作人员
     */
    private String operName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 请求URL
     */
    private String reqUrl;
    /**
     * ip地址
     */
    private String ipAddress;
    /**
     * 操作地点
     */
    private String ipLocation;
    /**
     * 请求参数
     */
    private String reqParam;
    /**
     * 返回参数
     */
    private String jsonResult;
    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 操作时间
     */
    private LocalDateTime operTime;
    /**
     * 操作描述
     */
    private String operDesc;

}

