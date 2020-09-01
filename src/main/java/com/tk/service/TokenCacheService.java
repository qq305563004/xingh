package com.tk.service;

import com.tk.security.dto.LoginCredentialsDto;

/**
 * Token Cache Service
 *
 * @ClassName TokenCacheService.java
 * @author jingchaof
 * @version V1.0
 * @date 2019年3月29日
 */
public interface TokenCacheService {

    /**
     * 获取登录凭证
     * 
     * @param userName
     *            用户名
     * @return
     */
    LoginCredentialsDto getLoginCredentials(String userName);

    /**
     * 缓存登录凭证
     * 
     * @param userName
     *            用户名
     * @param loginCredentials
     *            登录凭证
     */
    void cacheLoginCredentials(String userName, LoginCredentialsDto loginCredentials);

}
