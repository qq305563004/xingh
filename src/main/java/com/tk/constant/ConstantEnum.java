package com.tk.constant;

/**
 * 枚举常量
 *
 * @ClassName ConstantEnum.java
 * @author jinghongw
 * @version V1.0
 * @date 2018年6月29日
 */
public class ConstantEnum {
    
    /**
     * Box 新旧版本
     */
    public static enum VersionFlag {
        /**新版本**/
        NEW(1),
        
        /**旧版本**/
        OLD(2);
        
        private VersionFlag(int value) {
            this.value = value; 
        }
        
        private int value;
        
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * PSN、VIN 使用状态
     */
    public static enum EnableState {
        /** 可使用 **/
        ENABLE(1),
        /** 不可使用 **/
        DISABLE(2);

        private int value;

        private EnableState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 检测类型枚举
     */
    public static enum DetectionLog {
        /* 检测类型 */
        FCT(1), FVT(2), FQC(3), OQC(4);
        private int value;

        private DetectionLog(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 产品类型枚举
     */
    public static enum productType {
        BOX(1), HMI(2);
        private int value;

        private productType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 用户状态
     */
    public static enum userStatus {
        /** 可使用 **/
        ENABLE(1),
        /** 不可使用 **/
        DISABLE(0);

        private int value;

        private userStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 用户类型
     */
    public static enum userType {
        /** 普通管理员 **/
        ADMIN(1),
        /** 超级管理员 **/
        SUPER(2);

        private int value;

        private userType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 权限状态
     */
    public static enum permissionStatus {
        /** 可使用 **/
        ENABLE(1),
        /** 不可使用 **/
        DISABLE(0);

        private int value;

        private permissionStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 权限类型
     */
    public static enum permissionType {
        /** Web权限 **/
        WEB(1),
        /** Tool权限 **/
        TOOL(2);

        private int value;

        private permissionType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 角色类型
     */
    public static enum roleType {
        /** Web角色 **/
        WEB(1),
        /** Tool角色 **/
        TOOL(2);

        private int value;

        private roleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 角色类型
     */
    public static enum roleLevel {
        /** 可显示 **/
        DISPLAY(1),
        /** 不可显示 **/
        BLANK(2);

        private int value;

        private roleLevel(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * Box配置状态
     */
    public static enum boxConfigStatus {
        /** 可修改、可删除 **/
        MODIFY_AND_DELETE(1),
        /** 不可修改 **/
        NOT_MODIFY(2),
        /** 可修改、不可删除 **/
        MODIFY(3);

        private int value;

        private boxConfigStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * Box配置版本
     */
    public static enum boxConfigVersion {
        /** 新版本 **/
        NEW(1),
        /** 就版本 **/
        OLD(2);

        private int value;

        private boxConfigVersion(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * PN对照状态
     */
    public static enum pnCompareStatus {
        /** 可修改 **/
        MODIFY(1),
        /** 不可修改 **/
        NOT_MODIFY(2),
        /** 已关联Box配置信息 **/
        RELATION(3);

        private int value;

        private pnCompareStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 工单状态
     */
    public static enum jobStatus {
        /** 可修改 **/
        MODIFY(1),
        /** 不可修改 **/
        NOT_MODIFY(2);

        private int value;

        private jobStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * PCBA类型
     */
    public static enum pcbaType {
        /** pcba1 **/
        PCBA1(1),
        /** pcba2 **/
        PCBA2(2);

        private int value;

        private pcbaType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 产品售后类型
     */
    public static enum productAfterSaleType {
        /** 正品 **/
        GENUINE(1),
        /** 售后备件 **/
        AFTER_SALE(2),
        /** 废品 **/
        WASTE(3);

        private int value;

        private productAfterSaleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 工单售后类型
     */
    public static enum jobAfterSaleType {
        /** 正品 **/
        GENUINE(1),
        /** 售后备件 **/
        AFTER_SALE(2);

        private int value;

        private jobAfterSaleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
