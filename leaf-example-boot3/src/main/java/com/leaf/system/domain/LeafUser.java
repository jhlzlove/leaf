package com.leaf.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Entity(name = "leaf_user")
@DynamicInsert
@DynamicUpdate
public class LeafUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 433113171858975273L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录绑定手机号
     */
    private String phone;
    /**
     * 登录绑定邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 用户详情id
     */
    private Long userDetailId;
    /**
     * 状态：1正常，0禁用
     */
    private Integer status;
    /**
     * 是否删除：true(b'1')已删除，false(b'0')正常
     */
    private Boolean delFlag;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    private String remark;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Long userDetailId) {
        this.userDetailId = userDetailId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LeafUser{" +
                "userId=" + userId + "," +
                "username=" + username + "," +
                "password=" + password + "," +
                "phone=" + phone + "," +
                "email=" + email + "," +
                "nickName=" + nickName + "," +
                "avatar=" + avatar + "," +
                "userDetailId=" + userDetailId + "," +
                "status=" + status + "," +
                "delFlag=" + delFlag + "," +
                "createBy=" + createBy + "," +
                "createTime=" + createTime + "," +
                "updateBy=" + updateBy + "," +
                "updateTime=" + updateTime + "," +
                "remark=" + remark +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafUser leafUser = (LeafUser) o;
        return
                Objects.equals(userId, leafUser.userId) &&
                        Objects.equals(username, leafUser.username) &&
                        Objects.equals(password, leafUser.password) &&
                        Objects.equals(phone, leafUser.phone) &&
                        Objects.equals(email, leafUser.email) &&
                        Objects.equals(nickName, leafUser.nickName) &&
                        Objects.equals(avatar, leafUser.avatar) &&
                        Objects.equals(userDetailId, leafUser.userDetailId) &&
                        Objects.equals(status, leafUser.status) &&
                        Objects.equals(delFlag, leafUser.delFlag) &&
                        Objects.equals(createBy, leafUser.createBy) &&
                        Objects.equals(createTime, leafUser.createTime) &&
                        Objects.equals(updateBy, leafUser.updateBy) &&
                        Objects.equals(updateTime, leafUser.updateTime) &&
                        Objects.equals(remark, leafUser.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, phone, email, nickName, avatar, userDetailId, status, delFlag, createBy, createTime, updateBy, updateTime, remark);
    }

}

