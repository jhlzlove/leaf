package com.leaf.domain;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;


/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Entity
public interface LeafUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId();

    /**
     * 用户名
     */
    String username();

    /**
     * 密码
     */
    String password();

    /**
     * 昵称
     */
    String nickName();

    /**
     * 头像地址
     */
    String avatar();

    /**
     * 状态：0 正常，1 禁用
     */
    Integer status();

    /**
     * 是否删除：0 正常；1 删除
     */
    Integer delFlag();

    String userCode();

}

