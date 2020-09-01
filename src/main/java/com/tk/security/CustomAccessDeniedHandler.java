package com.tk.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.tk.constant.RetCodeConstant;
import com.tk.utils.MsgUtils;
import com.tk.utils.ResponseUtils;

/**
 * 自定义访问拒绝处理程序
 *
 * @ClassName CustomAccessDeniedHandler.java
 * @author jingchaof
 * @version V1.0
 * @date 2018年6月29日
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        if (!response.isCommitted()) {
            // 拒绝访问
            logger.info(MsgUtils.retLog(RetCodeConstant.ACCESS_DENIED_ERR));
            ResponseUtils.responseToJson(response, RetCodeConstant.ACCESS_DENIED_ERR);
        }
    }

}
