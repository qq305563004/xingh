package com.tk.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tk.constant.RetCodeConstant;
import com.tk.exception.WebBusinessException;
import com.tk.utils.MsgUtils;
import com.tk.utils.ResponseUtils;
import com.tk.vo.Code;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    public JWTAuthenticationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = null;
        try {
            authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        } catch (SignatureException | MalformedJwtException e) {
            // jwt 解析错误
            logger.info(MsgUtils.retLog(RetCodeConstant.JWT_PARSE_ERR));
            ResponseUtils.responseToJson((HttpServletResponse) response, RetCodeConstant.JWT_PARSE_ERR);
            return;
        } catch (ExpiredJwtException e) {
            // JWT 登录超时
            logger.info(MsgUtils.retLog(RetCodeConstant.JWT_TIMEOUT));
            ResponseUtils.responseToJson((HttpServletResponse) response, RetCodeConstant.JWT_TIMEOUT);
            return;
        } catch (WebBusinessException e) {
            ResponseUtils.responseToJson((HttpServletResponse) response, new Code<>(e.getMessage()));
            return;
        }

        // 未登录
        if (authentication == null) {
            logger.info(MsgUtils.retLog(RetCodeConstant.NOT_LOGIN));
            ResponseUtils.responseToJson((HttpServletResponse) response, RetCodeConstant.NOT_LOGIN);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }
}
