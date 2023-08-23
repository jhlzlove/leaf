package com.leaf.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


/**
 * 用户信息表(LeafUserDetail)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Entity(name = "leaf_user_detail")
@DynamicInsert
@DynamicUpdate
public class LeafUserDetail implements Serializable {
    @Serial
    private static final long serialVersionUID = 334244628484997516L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 姓氏
     */
    private String firstName;
    /**
     * 名称
     */
    private String lastName;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 民族
     */
    private String ethnic;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 性别 0 保密，1 女，2 男
     */
    private Integer gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 住址
     */
    private String address;
    /**
     * 故里
     */
    private String hometown;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 备用字段1
     */
    private String tab1;
    /**
     * 备用字段2
     */
    private String tab2;
    /**
     * 备用字段3
     */
    private String tab3;
    /**
     * 备用字段4
     */
    private String tab4;
    /**
     * 备用字段5
     */
    private String tab5;
    /**
     * 备用字段6
     */
    private String tab6;
    /**
     * 所属部门id
     */
    private Long deptId;


    public Long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Long userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTab1() {
        return tab1;
    }

    public void setTab1(String tab1) {
        this.tab1 = tab1;
    }

    public String getTab2() {
        return tab2;
    }

    public void setTab2(String tab2) {
        this.tab2 = tab2;
    }

    public String getTab3() {
        return tab3;
    }

    public void setTab3(String tab3) {
        this.tab3 = tab3;
    }

    public String getTab4() {
        return tab4;
    }

    public void setTab4(String tab4) {
        this.tab4 = tab4;
    }

    public String getTab5() {
        return tab5;
    }

    public void setTab5(String tab5) {
        this.tab5 = tab5;
    }

    public String getTab6() {
        return tab6;
    }

    public void setTab6(String tab6) {
        this.tab6 = tab6;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "LeafUserDetail{" +
                "userDetailId=" + userDetailId + "," +
                "userCode=" + userCode + "," +
                "firstName=" + firstName + "," +
                "lastName=" + lastName + "," +
                "realName=" + realName + "," +
                "ethnic=" + ethnic + "," +
                "mobile=" + mobile + "," +
                "gender=" + gender + "," +
                "age=" + age + "," +
                "address=" + address + "," +
                "hometown=" + hometown + "," +
                "idCard=" + idCard + "," +
                "tab1=" + tab1 + "," +
                "tab2=" + tab2 + "," +
                "tab3=" + tab3 + "," +
                "tab4=" + tab4 + "," +
                "tab5=" + tab5 + "," +
                "tab6=" + tab6 + "," +
                "deptId=" + deptId +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafUserDetail leafUserDetail = (LeafUserDetail) o;
        return
                Objects.equals(userDetailId, leafUserDetail.userDetailId) &&
                        Objects.equals(userCode, leafUserDetail.userCode) &&
                        Objects.equals(firstName, leafUserDetail.firstName) &&
                        Objects.equals(lastName, leafUserDetail.lastName) &&
                        Objects.equals(realName, leafUserDetail.realName) &&
                        Objects.equals(ethnic, leafUserDetail.ethnic) &&
                        Objects.equals(mobile, leafUserDetail.mobile) &&
                        Objects.equals(gender, leafUserDetail.gender) &&
                        Objects.equals(age, leafUserDetail.age) &&
                        Objects.equals(address, leafUserDetail.address) &&
                        Objects.equals(hometown, leafUserDetail.hometown) &&
                        Objects.equals(idCard, leafUserDetail.idCard) &&
                        Objects.equals(tab1, leafUserDetail.tab1) &&
                        Objects.equals(tab2, leafUserDetail.tab2) &&
                        Objects.equals(tab3, leafUserDetail.tab3) &&
                        Objects.equals(tab4, leafUserDetail.tab4) &&
                        Objects.equals(tab5, leafUserDetail.tab5) &&
                        Objects.equals(tab6, leafUserDetail.tab6) &&
                        Objects.equals(deptId, leafUserDetail.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDetailId, userCode, firstName, lastName, realName, ethnic, mobile, gender, age, address, hometown, idCard, tab1, tab2, tab3, tab4, tab5, tab6, deptId);
    }

}

