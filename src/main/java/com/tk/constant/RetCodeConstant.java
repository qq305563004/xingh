package com.tk.constant;

/**
 * 返回码常量
 *
 * @ClassName RetCodeConstant.java
 * @author jingchaof
 * @version V1.0
 * @date 2018年6月12日
 */
public class RetCodeConstant {

    /*-------------------- Common ---------------------*/

    /** 正常 **/
    public static final int SUCCESS = 0;

    /** 失败 **/
    public static final int FAILED = -1;

    /** 请求参数错误 **/
    public static final int PARAMETER_ERR = 2;

    /** 用户未登录 **/
    public static final int NOT_LOGIN = 4;

    /** 拒绝访问 **/
    public static final int ACCESS_DENIED_ERR = 5;

    /** JWT解析错误 **/
    public static final int JWT_PARSE_ERR = 6;

    /** JWT登录超时 **/
    public static final int JWT_TIMEOUT = 7;

    /** 登录超时 **/
    public static final int LOGIN_TIMEOUT = 8;

    /** 账户已在其它地方登录 **/
    public static final int LOGIN_IN_ELSEWHERE = 9;

    /*-------------------- Login ---------------------*/
    /** 用户名或密码错误 **/
    public static final int LOGIN_PASSWORD_ERR = 20101;

    /*-------------------- 检查 pcbaCode ---------------------*/
    /** 工单已经存在 **/
    public static final int JOBCODE_ALREADY_EXISTS = 20301;

    /** 没有对应的PN对照信息 **/
    public static final int COMPARE_NOT_EXISTS = 20302;

    /** PCBA物料号不匹配 **/
    // public static final int PCBA_NOT_MATCH = 20303;

    /** 未绑定Box配置信息 **/
    public static final int UNBOUND_BOXCONFIG = 20304;

    /** 日期错误 **/
    public static final int DATE_ERROR = 20305;

    /*-------------------- PSN关联 ---------------------*/
    /** PSN1不存在 **/
    public static final int PSN1_NOT_EXISTS = 20401;

    /** PSN2不存在 **/
    public static final int PSN2_NOT_EXISTS = 20402;

    /** PSN1已关联 **/
    public static final int PSN1_HAS_RELATION = 20403;

    /** PSN2已关联 **/
    public static final int PSN2_HAS_RELATION = 20404;

    /** 工单号不一致 **/
    public static final int JOBCODE_DISACCORD = 20405;

    /** SecureBootKey未上传 **/
    public static final int SBK_NOT_EXISTS = 20406;

    /*-------------------- 获取SN ---------------------*/
    /** PSN不存在 **/
    public static final int PSN_NOT_EXISTS = 20501;

    /** PSN未关联 **/
    public static final int PSN_NOT_RELATION = 20502;

    /** 产品类型不匹配 **/
    public static final int PRODUCTTYPE_MISMATCH = 20503;

    /** 工单类型与产品类型不匹配 **/
    public static final int JOBTYPE_PRODUCTTYPE_MISMATCH = 20504;

    /** 一个工单不能包含多个产品 **/
    public static final int TWO_PRODUCTION = 20505;

    /*-------------------- 获取Box配置信息 ---------------------*/
    /** SN不存在 **/
    public static final int SN_NOT_EXISTS = 20601;

    /** vvin已存在 **/
    public static final int VVIN_EXISTS = 20602;

    /*-------------------- 上传Box信息 ---------------------*/
    /** SN已注册 **/
    public static final int SN_HAS_REGISTERED = 20701;

    /** vin重复 **/
    public static final int VIN_REPEATED = 20702;

    /** vin不匹配 **/
    public static final int VIN_NOT_MATCH = 20703;

    /** RFKey1重复 **/
    public static final int RFKEY1_REPEATED = 20704;

    /** RFKey为空 **/
    public static final int RFKEY_EMTPY = 20705;

    /** Box未关联工单 **/
    public static final int BOX_JOB_NOT_RELATION = 20706;

    /** RFKey2重复 **/
    public static final int RFKEY2_REPEATED = 20707;

    /*-------------------- 获取BSN ---------------------*/
    /** 已被包装 **/
    public static final int HAVE_BEEN_PACKED = 20801;

    /** 该工单未绑定产品 **/
    public static final int JOB_UNBOUND_PRODUCTION = 20802;

    /** SN未注册 **/
    public static final int SN_NOT_REGISTERED = 20803;
    
    /**该产品未被包装**/
    public static final int PACKED_NOT_EXISTS = 20804;

    /*-------------------- 获得Box信息 ---------------------*/
    /** VIN不存在 **/
    public static final int VIN_NOT_EXISTS = 20901;

    /*-------------------- 上传日志文件 ---------------------*/
    /** 文件上传云失败 **/
    public static final int UPLOAD_CLOUD_FAILURE = 21001;

    /** 云删除文件失败 **/
    public static final int DELETE_CLOUD_FAILURE = 21002;

    /*-------------------- 获取包装数量 ---------------------*/
    /** 工单不存在 **/
    public static final int JOBCODE_NOT_EXISTS = 21101;

    /*-------------------- 获取BSN详情 ---------------------*/
    /** SN未被包装 **/
    public static final int SN_NOT_PACKED = 21301;

    /** BSN不存在 **/
    public static final int BSN_NOT_EXISTS = 21302;

    /*-------------------- 生成Box凭证 ---------------------*/
    /** ESN不存在 **/
    public static final int ESN_NOT_EXISTS = 35101;

    /** ESN已经在IOT注册，但权限与请求的类型不符 **/
    public static final int ESN_REGISTERED_AND_AUTH_ERROR = 35102;

    /** 证书已存在 **/
    public static final int CERT_EXISTS = 35103;

    /** ESN注册错误 **/
    public static final int ESN_REGISTERED_ERROR = 35104;

    /** 生成证书错误 **/
    public static final int GENERATE_CERT_ERROR = 35105;

    /** 下载证书错误 **/
    public static final int DOWNLOAD_CERT_ERROR = 35106;

    /*-------------------- Web ---------------------*/
    /** 用户不存在 **/
    public static final int USER_NOT_EXISTS = 10301;

    /** 用户已存在 **/
    public static final int USER_EXISTS = 10302;

    /** 密码错误 **/
    public static final int PASSWORD_ERROR = 10303;

    /*-------------------- 角色管理 ---------------------*/
    /** 角色不存在 **/
    public static final int NO_ROLE = 10601;

    /** 角色已存在 **/
    public static final int ROLE_ALREADY_EXISTS = 10602;

    /** 角色被使用，不能删除 **/
    public static final int ROLE_USE = 10603;

    /*-------------------- Box管理 ---------------------*/
    /** Box不存在 **/
    public static final int BOX_NOT_EXISTS = 10801;

    /*-------------------- Box配置管理 ---------------------*/
    /** Box配置信息不存在 **/
    public static final int CONFIG_NOT_EXISTS = 10901;

    /** Box配置信息已存在 **/
    public static final int CONFIG_EXISTS = 10902;

    /** Box配置已被使用 **/
    public static final int CONFIG_USE = 10903;

    /** 防盗阈值错误 **/
    public static final int THRESHOLD_ERROR = 10904;

    /** Box配置无法升级 **/
    public static final int CONFIG_NOT_UPGRADE = 10905;

    /*-------------------- 产品对照管理 ---------------------*/
    /** PN对照信息不存在 **/
    public static final int PN_NOT_EXISTS = 11101;

    /** PN对照信息不存在 **/
    public static final int PN_EXISTS = 11102;

    /** PN对照信息已被绑定 **/
    public static final int PN_USE = 11103;

    /** PCBA物料号长度错误 **/
    public static final int PCBA_SIZE_ERROR = 11104;

    /** PCBA物料号已存在 **/
    public static final int PCBA_ALREADY_EXISTS = 11105;

    /** PCBA物料号重复 **/
    public static final int PCBA_REPEAT = 11106;

    /** PCBA物料号为空 **/
    public static final int PCBA_IS_EMPTY = 11107;

    /*-------------------- 工单管理 ---------------------*/
    /** 工单号已存在 **/
    public static final int JOB_EXISTS = 11201;

    /** 工单不已存在 **/
    public static final int JOB_NOT_EXISTS = 11202;

    /** 工单已被使用 **/
    public static final int JOB_USE = 11203;

    /*-------------------- 售后管理 ---------------------*/
    /** 该产品型号不对应 **/
    public static final int TYPE_WRONG = 11204;

    /** 该产品是废品 **/
    public static final int WASTE_TYPE = 11205;

    /** PSN维修次数超过2次 **/
    public static final int PSN_LIMIT = 11206;

}
