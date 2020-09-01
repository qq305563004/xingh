package com.tk.vo.res;

import java.util.Arrays;
import java.util.List;

public class LoginResVo {

    private String token;

    private List<String> authorityList;

    public LoginResVo(String token, List<String> authorityList) {
        super();
        this.token = token;
        this.authorityList = authorityList;
    }

    public LoginResVo(String token, String authorities) {
        this.token = token;
        this.authorityList = Arrays.asList(authorities.split(","));
    }

    public LoginResVo() {
        super();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<String> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String toString() {
        return "LoginResVo [token=" + token + ", authorityList=" + authorityList + "]";
    }

}
