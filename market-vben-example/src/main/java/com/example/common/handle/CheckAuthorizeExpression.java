package com.example.common.handle;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author clf
 * @time 2022/8/14 16:44
 * @desc: CheckAuthorizeExpression： 自定义权限校验
 */
@Component("ca")
public class CheckAuthorizeExpression {

    private boolean hasPermissions(Set<String> permissions, String permission) {
        return permissions.contains(permission);
    }
}
