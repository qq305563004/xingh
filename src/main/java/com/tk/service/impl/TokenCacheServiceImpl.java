package com.tk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tk.constant.Constant;
import com.tk.exception.WebBusinessException;
import com.tk.redis.RedisClient;
import com.tk.security.dto.LoginCredentialsDto;
import com.tk.service.TokenCacheService;

/**
 * Token Cache Service
 *
 * @ClassName TokenCacheServiceImpl.java
 * @author jingchaof
 * @version V1.0
 * @date 2019年3月29日
 */
@Service("tokenCacheService")
public class TokenCacheServiceImpl implements TokenCacheService {

    private static final Logger logger = LoggerFactory.getLogger(TokenCacheServiceImpl.class);
//    @Autowired
//    private RedisUtil redisUtil;
    
    @Autowired
	private RedisClient redisClinet;

    @Override
    public LoginCredentialsDto getLoginCredentials(String userName) {
        String dto = null;
        try {
            dto = (String) redisClinet.hget(Constant.REDIS_TOKEN_KEY, userName);
            logger.info("Get redis token success : " + dto);
        } catch (Exception e) {
            logger.error("Get cache token error! userName:" + userName, e);
            throw new WebBusinessException(e);
        }
        return JSON.parseObject(dto, LoginCredentialsDto.class);
    }

    @Override
    public void cacheLoginCredentials(String userName, LoginCredentialsDto loginCredentials) {
        try {
        	redisClinet.hset(Constant.REDIS_TOKEN_KEY, userName, JSON.toJSONString(loginCredentials));
            logger.info("Set redis token success : " + userName);
        } catch (Exception e) {
            logger.error("Save cache token error! userName:" + userName, e);
            throw new WebBusinessException(e);
        }
    }

}
