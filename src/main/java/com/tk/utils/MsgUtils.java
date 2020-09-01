package com.tk.utils;

import com.tk.config.MsgPropertiesConfig;
import com.tk.constant.Constant;

public class MsgUtils {

    static {
        msgPropertiesConfig = (MsgPropertiesConfig) ApplicationUtil.getBean("msgPropertiesConfig");
    }

    private static MsgPropertiesConfig msgPropertiesConfig;

    private MsgUtils() {
    }

    public static String getMsg(int retCode) {
        return msgPropertiesConfig.getRetCode().get(String.format("%05d", retCode));
    }

    public static String getMsg(String retCode) {
        return msgPropertiesConfig.getRetCode().get(retCode);
    }

    public static String retLog(String retCode) {
        return retCode + Constant.COLON + getMsg(retCode);
    }

    public static String retLog(int retCode) {
        String formatCode = String.format("%05d", retCode);
        return formatCode + Constant.COLON + getMsg(retCode);
    }

    public static String retLog(String retCode, String retMsg) {
        return retCode + Constant.COLON + getMsg(retCode) + Constant.COLON + retMsg;
    }

    public static String retLog(int retCode, String retMsg) {
        String formatCode = String.format("%05d", retCode);
        return formatCode + Constant.COLON + msgPropertiesConfig.getRetCode().get(formatCode) + Constant.COLON + retMsg;
    }

}
