/** 
 * Copyright(C) 2016, WUHAN KOTEI INFORMATICS CO., LTD.	
 *
 * Modification  History:
 * Date          	Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2018年1月3日       zhiweix       1.0             1.0
 *
 *
 */
package com.tk.utils;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/** 
 * Aes Key生成类
 * @ClassName:	RandomKeyUtils.java
 * @author:		zhiweix  
 * @version:	V1.0 
 * @date:		2018年1月3日
 */
public class RandomKeyUtils {

    private RandomKeyUtils(){
        
    }
    
    /**
     * 生成随机16位key
     * @return
     */
    public static String generate16() {
        return generate(16);
    }
    
    /**
     * 生成指定长度随机key
     * @param length key长度
     * @return
     */
    public static String generate(int length) {
        String source = UUID.randomUUID().toString().replaceAll("-", "");
        return StringUtils.substring(source, 0, length);
    }
}
