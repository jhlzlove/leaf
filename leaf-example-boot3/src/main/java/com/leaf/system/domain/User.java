package com.leaf.system.domain;

import jakarta.persistence.Entity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息表(User)实体类
 *
 * @author jhlz
 * @since 2022-12-11 13:46:28
 */
@Entity(name = "user")
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity implements Serializable {

    /**
     * 姓名
     */
    private String name;
    /**
     * 出生日期
     */
    private LocalDateTime birthday;
    /**
     * 身份证号
     */
    private String identityCard;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 居住地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String phone;

    /**
     * 登录账户
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;
    /**
     * 登录设备
     */
    private String loginDevice;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 1？启用 : 禁用
     */
    private Integer status;
    /**
     * 性别(0：保密，1：女，2：男)
     */
    private Integer gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("User{name='" + name + "', ")
                .append("birthday='" + birthday + "', ")
                .append("identityCard='" + identityCard + "', ")
                .append("age='" + age + "', ")
                .append("address='" + address + "', ")
                .append("phone='" + phone + "', ")
                .append("userName='" + userName + "', ")
                .append("password='" + password + "', ")
                .append("lastLogin='" + lastLogin + "', ")
                .append("loginDevice='" + loginDevice + "', ")
                .append("nickName='" + nickName + "', ")
                .append("avatar='" + avatar + "', ")
                .append("gender='" + gender + "'}")
                .toString();
    }
}

