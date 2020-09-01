package com.tk.controller;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Base Controller
 *
 * @ClassName BaseController.java
 * @author jingchaof
 * @version V1.0
 * @date 2018年6月28日
 */
public class BaseController {

    /**
     * 获取登录用户名
     * 
     * @return
     */
    protected String getUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
