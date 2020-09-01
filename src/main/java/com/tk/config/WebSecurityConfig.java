package com.tk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tk.security.CustomAccessDeniedHandler;
import com.tk.security.CustomAuthenticationProvider;
import com.tk.security.JWTAuthenticationFilter;
import com.tk.security.JWTLoginFilter;
import com.tk.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        super();
        this.userService = userService;
    }

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                // 所有 / 的所有请求 都放行
                .antMatchers("/").permitAll()
                //.antMatchers("/index").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated().and()
                // 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
                .addFilter(new JWTLoginFilter(authenticationManager()))
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
    }
    
    //解决静态资源被拦截的问题
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/css/**","/js/**","/**.html");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userService));
    }

}
