package com.tk.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.tk.constant.Constant;
import com.tk.security.dto.LoginCredentialsDto;
import com.tk.security.dto.UserDto;
import com.tk.service.UserService;
import com.tk.utils.PBKDF2Util;

/**
 * 自定义身份认证验证组件
 *
 * @ClassName CustomAuthenticationProvider.java
 * @author jingchaof
 * @version V1.0
 * @date 2019年3月28日
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(JWTLoginFilter.class);

    private UserService userService;

    public CustomAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDto userDto = userService.getUserAndAuthority(name);

        AbstractAuthenticationToken authenticationToken = null;
        // 认证逻辑
        try {
            if (userDto != null && PBKDF2Util.authenticate(password, userDto.getPassword(), userDto.getSalt())) {
                // 生成令牌
                authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
                authenticationToken.setDetails(new LoginCredentialsDto(generateAuthority(userDto.getAuthorityList())));
                return authenticationToken;
            } else {
                // 登录错误
                throw new BadCredentialsException(Constant.LOGIN_ERROR);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("PBKDF2 authenticate error.", e);
        }

        return authenticationToken;
    }

    private static String generateAuthority(List<String> authorityList) {
        StringBuilder sb = new StringBuilder();
        for (String authority : authorityList) {
            sb.append(authority).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    

}