package net.rckd.entity;

import java.util.Date;

/**
 * 注册用户实体类
 *
 * @author hanyi
 * @date 2017年04月08日
 */
public class User {
    private Integer id;
    /**
     * 帐号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最近登录时间
     */
    private Date lastLoginTime;
    /**
     * 荣誉积分
     */
    private Integer creditScore;
    /**
     * 地区主键
     */
    private Integer regionCode;
    /**
     * 系统积分
     */
    private Integer systemIntegral;
    /**
     * 会员积分
     */
    private Integer memberIntegral;
    /**
     * 状态
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getSystemIntegral() {
        return systemIntegral;
    }

    public void setSystemIntegral(Integer systemIntegral) {
        this.systemIntegral = systemIntegral;
    }

    public Integer getMemberIntegral() {
        return memberIntegral;
    }

    public void setMemberIntegral(Integer memberIntegral) {
        this.memberIntegral = memberIntegral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
