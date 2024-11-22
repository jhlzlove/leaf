package com.leaf.system.service;

import com.leaf.framework.annotation.Log;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.domain.LeafUserTable;
import jakarta.enterprise.context.ApplicationScoped;
import org.babyfish.jimmer.sql.JSqlClient;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Log
@ApplicationScoped
public class LoginService {

    private final JSqlClient sqlClient;
    LeafUserTable table = LeafUserTable.$;

    public LoginService(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    /**
     * 登录接口
     *
     * @param leafUser 对象
     * @return jwt
     */
    public String login(LeafUser leafUser) {
        LeafUser user = sqlClient.createQuery(table)
                .where(
                        table.username().eq(leafUser.username()),
                        table.password().eq(leafUser.password())
                )
                .select(table)
                .fetchOneOrNull();
        System.out.println("login successful: ");
        return user.username();
    }

    /**
     * 获取登录用户的信息
     * @return 用户的具体信息
     */
    @Log(module = "获取用户信息")
    public LeafUser userInfo() {
        return null;
    }

    /**
     * 注册用户信息
     * @param leafUser  用户信息
     */
    public void register(LeafUser leafUser) {
    }
}
