package com.leaf.domain.record;

import java.io.Serializable;

/**
 * 登录用户参数信息
 *
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/6 21:23
 */
public record LoginUserRecord(String username, String password, String nickName) implements Serializable {
}
