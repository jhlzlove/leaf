package com.example.system.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record MyUser(
        /**
         * 姓名
         */
        String name,
        /**
         * 出生日期
         */
        LocalDateTime birthday,
        /**
         * 身份证号
         */
        String identityCard,
        /**
         * 年龄
         */
        Integer age,
        /**
         * 居住地址
         */
        String address,
        /**
         * 联系电话
         */
        String phone,

        /**
         * 登录账户
         */
        String userName,
        /**
         * 密码
         */
        String password,
        /**
         * 最后登录时间
         */
        LocalDateTime lastLogin,
        /**
         * 登录设备
         */
        String loginDevice,
        /**
         * 昵称
         */
        String nickName,
        /**
         * 头像
         */
        String avatar,
        /**
         * 1？启用 : 禁用
         */
        Integer status,
        /**
         * 性别(0：保密，1：女，2：男)
         */
        Integer gender
) implements Serializable {
}
