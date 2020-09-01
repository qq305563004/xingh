package com.tk.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tk.constant.Constant;
import com.tk.constant.RetCodeConstant;
import com.tk.security.dto.LoginCredentialsDto;
import com.tk.service.TokenCacheService;
import com.tk.utils.ApplicationUtil;
import com.tk.utils.MsgUtils;
import com.tk.utils.RandomKeyUtils;
import com.tk.utils.ResponseUtils;
import com.tk.vo.Code;
import com.tk.vo.res.LoginResVo;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTLoginFilter.class);

    public JWTLoginFilter(AuthenticationManager authManager) {
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {

        // JSON反序列化成 AccountCredentials
        AccountCredentials creds = null;
        AbstractAuthenticationToken authenticationToken = null;
        try {
            creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
            authenticationToken = new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回一个验证令牌
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth)
            throws IOException, ServletException {

        String userName = auth.getName();
        LoginCredentialsDto loginCredentials = (LoginCredentialsDto) auth.getDetails();
        String salt = RandomKeyUtils.generate(32);
        String jwt = TokenAuthenticationService.addAuthentication(userName, salt);
        loginCredentials.setSalt(salt);
        loginCredentials.setLoginTime(System.currentTimeMillis() + TokenAuthenticationService.LOGIN_TIMEOUT);

        // Redis 缓存登录凭证
        TokenCacheService tokenCacheService = (TokenCacheService) ApplicationUtil.getBean("tokenCacheService");
        tokenCacheService.cacheLoginCredentials(userName, loginCredentials);

        // 将 JWT 写入 body
        LoginResVo loginResVo = new LoginResVo(jwt, loginCredentials.getAuthorities());

        ResponseUtils.responseToJson(response, new Code<>(RetCodeConstant.SUCCESS, loginResVo));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {

        if (failed.getMessage().equals(Constant.LOGIN_ERROR)) {
            logger.info(MsgUtils.retLog(RetCodeConstant.LOGIN_PASSWORD_ERR));
            ResponseUtils.responseToJson(response, RetCodeConstant.LOGIN_PASSWORD_ERR);
        }
    }

}