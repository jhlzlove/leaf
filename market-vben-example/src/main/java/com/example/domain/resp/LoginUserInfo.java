package com.example.domain.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;

/**
 * @author jhlz
 * @time 2022/9/7 12:39
 * @desc: LoginUserInfo
 * 登录返回前端的用户信息
 */
@Data
@Accessors(chain = true)
public class LoginUserInfo {
    private Long id;
    private String token;
    private String nickName;
    private String userName;
    List<String> rolesInfo = Arrays.asList("admin");
}
