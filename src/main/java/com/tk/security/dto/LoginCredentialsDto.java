package com.tk.security.dto;

import java.io.Serializable;

/**
 * 登录凭证DAO
 *
 * @ClassName LoginCredentialsDto.java
 * @author jingchaof
 * @version V1.0
 * @date 2019年3月28日
 */
public class LoginCredentialsDto implements Serializable {

    private static final long serialVersionUID = 148142774906455284L;

    /* Token盐值 */
    private String salt;

    /* 权限 */
    private String authorities;

    /* 登录时间 */
    private long loginTime;

    public LoginCredentialsDto(String authorities) {
        super();
        this.authorities = authorities;
    }

    public LoginCredentialsDto() {
        super();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginCredentialsDto [salt=" + salt + ", authorities=" + authorities + ", loginTime=" + loginTime + "]";
    }

}
