package com.tk.constant;

public class Constant {
	/************* RETURN CODE *****************/

	public static final int RESPONSE_CODE_SUCCESS = 200;

	public static final int RESPONSE_CODE_FAIL = -1;

	public static final String RESPONSE_MESSAGE_SUCCESS = "SUCCESS";

	public static final String RESPONSE_MESSAGE_FAIL = "FAIL";

	public static final int RESPONSE_CODE_DEVICE_NOT_EXIST = 1;

	public static final int RESPONSE_CODE_DEVICE_EXIST = 2;

	public static final int RESPONSE_CODE_NO_MSG = 3;

	public static final int RESPONSE_CODE_PARAM_EMPTY = 4;

	public static final int RESPONSE_CODE_VIERSION = 5;

	public static final String RESPONSE_MESSAGE_VIERSION = "The current version is too low";

	public static final String RESPONSE_MESSAGE_PARAM_EMPTY = "Parameters are empty.";

	public static final String RESPONSE_MESSAGE_NO_MSG = "No message was received";

	public static final String RESPONSE_MESSAGE_DEVICE_NOT_EXIST = "Device Not Exist";

	public static final String RESPONSE_MESSAGE_DEVICE_IS_EXIST = "Device Is Exist In IOT , But Auth Error";

	public static final String RESPONSE_MESSAGE_SYSTEM_ERROR = "System Error";

	public static final String RESPONSE_MESSAGE_PARAM_ERROR = "Parameter Error";

	public static final String RESPONSE_MESSAGE_JSON_FORMAT = "Json Format Error";

	public static final String ARRIVED_MESSAGE_BUSINESS_ERROR = "Arrived Message Business Error";

	public static final String ARRIVED_MESSAGE_SERVER_ACK_ERROR = "Arrived Message Server Ack Error";

	public static final String PUBLISH_MESSAGE_ERROR = "Publish Message Error";

	public static final String IOTHUB_CONNECTION_STRING = "iothubConnectionString";

	public static final String SPRING_APPLICATION = "application";

	/* event type */
	public static final int EVENT_TYPE_ALERT_CYCLING_REPORT = 1;
	public static final int EVENT_TYPE_RESPONSE_SCOOTER_LOCK_STATE = 2;
	public static final int EVENT_TYPE_RESPONSE_CHANGE_STATE_RESULT = 3;
	public static final int EVENT_TYPE_ALERT_CHANGE_STATE = 4;
	public static final int EVENT_TYPE_ALERT_UPDATE_CBOX_FIRMWARE = 5;
	public static final int EVENT_TYPE_RESPONSE_SCOOTER_STATE = 6;
	public static final int EVENT_TYPE_RESPONSE_MOTOR_STATE = 7;
	public static final int EVENT_RESPONSE_GET_CHANGE_STATE = 8;
	public static final int EVENT_TYPE_ALERT_SCOOTER_SN_REPORT = 9;

	/* command type */
	public static final String COMMAND_TYPE_CONTROL_LOCK = "controlLock";
	public static final String COMMAND_TYPE_RACE_MODE = "raceMode";
	public static final String COMMAND_TYPE_SILENT_MODE = "silentMode";
	public static final String COMMAND_TYPE_DASHBOARD_MODE = "dashboardMode";
	public static final String COMMAND_TYPE_SPEACKER_ACTIVATION = "speackerActivation";
	public static final String COMMAND_TYPE_TRUNK_LOCK = "trunkLock";
	public static final String COMMAND_TYPE_UPDATE_CBOX_FIRMWARE = "updateCboxFirmware";
	public static final String COMMAND_TYPE_GET_SCOOTER_STATE = "getScooterState";
	public static final String COMMAND_TYPE_GET_MOTOR_STATE = "getMotorState";
	public static final String COMMAND_TYPE_GET_CHANGE_STATE = "getChangeState";

	/* command value */
	public static final String CONTROL_TYPE_LOCK_SCOOTER = "0";
	public static final String CONTROL_TYPE_UNLOCK_SCOOTER = "1";
	public static final String CONTROL_TYPE_OPEN_TRUNK = "2";
	public static final String DASHBOARD_MODE2 = "2";
	public static final String DASHBOARD_MODE3 = "3";

	/** 问号 */
	public static final String QUESTION_MARK = "?";

	/**
	 * 日期格式
	 */
	public static final String DATETIME_FORMAT_DB_HH = "yyyy-MM-dd HH";
	public static final String TIME_FORMAT = "yyyyMMddHHmmssSSS";
	public static final String TIME_FORMAT2 = "yyyyMMddHHmmss";
	public static final String TIME_FORMAT3 = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
	public static final String DATE_FORMAT_YYYYMMDDHHMM2 = "yyyyMMddHH:mm";
	public static final String DATE_FORMAT_YYYYMMDDHHMM3 = "yyyy-MM-ddHH:mm";
	public static final String DATE_FORMAT_HHMM = "HHmm";
	public static final String DATE_FORMAT_YEAR = "yyyy";
	public static final String DATE_FORMAT_MONTH = "MM";
	public static final String DATE_FORMAT_DAY = "dd";
	public static final String DATE_FORMAT_HHMM_WITH_COLON = "HH:mm";
	public static final String DATE_FORMAT_HHMMSS_WITH_COLON = "HH:mm:ss";
	public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
	public static final String DATE_FORMAT_YYYYMM_WITH_HYPHEN = "yyyy-MM";
	public static final String DATE_FORMAT_YYYYMMDD_WITH_HYPHEN = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
	public static final String DATE_FORMAT_YY_MM_DD = "yy/MM/dd";
	public static final String DATE_FORMAT_YY = "yy";
	public static final String DEPARTURE_DATE_FORMAT = "yyyyMMdd";
	public static final String DEPARTURE_DATETIME_FORMAT = DEPARTURE_DATE_FORMAT + "HHmm";
	public static final String DEPARTURE_DATETIME_FORMAT_NO_SECOND = DATE_FORMAT_YYYYMMDD_WITH_HYPHEN + " "
			+ DATE_FORMAT_HHMM_WITH_COLON;
	public static final String DB_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/* production-cert constant */
	public static final int AUTHENTICATION_TYPE_CERT = 1;
	public static final int AUTHENTICATION_TYPE_TOKEN = 2;

	/** 冒号 **/
	public static final String COLON = " : ";

	/** System super administrator id **/
	public static final int SUPER_ADMIN_ID = 1;

	/** 统一页码（前台初始页码为1，数据库初始页码为0） */
	public static final int UNIFIED_PAGE_NUM = 1;

	/** 登录错误 */
	public static final String LOGIN_ERROR = "loginError";

	/** 默认密码 */
	public static final String PRE_PASSWORD = "Kotei$88";
	/*-------------------- Common Constant---------------------*/

	/** 名称默认长度 */
	public static final int NAME_SIZE = 30;

	/** 名称默认长度 */
	public static final int PASSWORD_MIN_SIZE = 6;

	/** 名称长度 */
	public static final int MAX_NAME_SIZE = 50;

	/** 文本默认长度 */
	public static final int TEXT_SIZE = 255;

	/** 文本长度 */
	public static final int MAX_TEXT_SIZE = 511;

	/** 电话号码长度 */
	public static final int PHONE_NUM_SIZE = 11;

	/** 工号长度 */
	public static final int WORK_NUM_SIZE = 10;

	/** 工单号长度 */
	public static final int JOB_CODE_SIZE = 11;

	/** SN长度 */
	public static final int SN_SIZE = 17;

	/** ESN长度 */
	public static final int ESN_SIZE = 20;

	/** PCBA长度 */
	public static final int PCBACODE_SIZE = 8;

	/** PSN长度 */
	public static final int PSN_SIZE = 19;

	/** Secure Boot Key 长度 */
	public static final int SECURE_BOOT_KEY_SIZE = 8;

	/** aesKey 长度 */
	public static final int AES_KEY_SIZE = 16;

	/** VIN长度 */
	public static final int VIN_SIZE = 18;

	/** BOM PN长度 */
	public static final int BOM_PN_SIZE = 10;

	/** 厂家代码长度 */
	public static final int PRODUCTCODE_SIZE = 1;

	/** 供应商代码长度 */
	public static final int SUPPLIER_CODE_SIZE = 8;

	/** 客户代码长度 */
	public static final int CUSTOMER_CODE_SIZE = 5;

	/** 客户产品型号长度 */
	public static final int CUSTOMER_PRODUCT_TYPE_SIZE = 16;

	/** 光庭产品型号长度 */
	public static final int KOTEI_PRODUCT_TYPE_SIZE = 9;

	/** BSN长度 */
	public static final int BSN_SIZE = 19;

	/** 硬件版本长度 */
	public static final int HARDVERSION_SIZE = 6;

	/** iot软件版本长度 */
	public static final int IOT_SOFTVERSION_SIZE = 15;

	/** bcm软件版本长度 */
	public static final int BCM_SOFTVERSION_SIZE = 17;

	/** 生产日期长度 */
	public static final int PRODUCTION_DATE_SIZE = 8;

	/*-------------------- Redis Constant---------------------*/

	/** Redis Token Key **/
	public static final String REDIS_TOKEN_KEY = "TokenInfo";

	/*-------------------- DetectionLog Constant---------------------*/
	/** DetectionLog存云的路径名 **/
	public static final String DETECTIONLOG = "DetectionLog/";

	/** PrivateKey存云的路径名 **/
	public static final String PRIVATE_KEY_BOLB = "PrivateKey/";

	/** CBox AES Key **/
	public static final String REDIS_CBOX_AES_KEY = "cboxaeskeyinfo";

}
