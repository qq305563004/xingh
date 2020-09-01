/** 
 * Copyright(C) 2016, WUHAN KOTEI INFORMATICS CO., LTD.	
 *
 * Modification  History:
 * Date          	Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2016年08月02日       chunlinw       1.0             1.0
 *
 *
 */
package com.tk.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

/**
 * Json工具类
 *
 * @ClassName JsonUtil.java
 * @author chunlinw
 * @version V1.0
 * @date 2016年08月02日
 */
public class JsonUtil {

	private JsonUtil() {
    }

    /**
	 * 对象转JSON
	 * 
	 * @param jsonName json名
	 * @param obj 对象
	 * @return
	 */
	public static String objectToJson(String jsonName, Object obj) {
		if (StringUtils.isEmpty(jsonName)|| obj == null) {
			return "";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(jsonName, obj);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}

	/**
	 * 将Java对象、数组或集合转换成json字符串。不支持Map。
	 * 
	 * @param obj 对象
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String objectToJson(Object obj) {
		if (obj == null) {
			return "";
		}
		Class cls = obj.getClass();
		if (cls.isArray() || obj instanceof Collection) {
			return JSONArray.fromObject(obj).toString();
		}
		return JSONObject.fromObject(obj).toString();
	}

	/**
	 * JSON转list
	 * 
	 * @param json json字符串
	 * @param t 转换对象
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List jsonToList(String json, Class t) {
		JSONArray jsonarray = JSONArray.fromObject(json);
		return (List) JSONArray.toCollection(jsonarray, t);
	}

	/**
	 * 将Json对象或数组的字符串转换成Java对象、数组或集合。不支持Map。
	 * 
	 * @param strjson json字符串
	 * @param cls 转换对象
	 * @param objType
	 *            0:Normal Object 1:Array 2:Collection
	 * @return
	 */
	public static <T> Object jsonToObj(String strjson, Class<T> cls, int objType) {
		if (StringUtils.isEmpty(strjson)) {
			return null;
		}
		if (objType == 1) {
			JSONArray jsonArray = JSONArray.fromObject(strjson);
			return jsonArray.toArray();
		}
		if (objType == 2) {
			JSONArray jsonArray = JSONArray.fromObject(strjson);
			return JSONArray.toCollection(jsonArray, cls);
		}
		return JSONObject.toBean(JSONObject.fromObject(strjson), cls);
	}

	/**
	 * JSON转map对象
	 * 
	 * @param strjson json字符串
	 * @param cls 对象
	 * @param map json中对象map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Object jsonToMapObj(String strjson, Class<T> cls, Map map) {
		if (StringUtils.isEmpty(strjson)) {
			return null;
		}

		return JSONObject.toBean(JSONObject.fromObject(strjson), cls, map);
	}


	/**
	 * 获取JSON字符串中指定字段
	 * 
	 * @param json json字符串
	 * @param key 指定key
	 * @return
	 */
	public static String getJsonParam(String json, String key) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (String) jsonObject.get(key);
	}

	/**
	 * 获取JSON字符串中指定字段
	 * 
	 * @param json json字符串
	 * @param key 指定key
	 * @return
	 */
	public static Integer getJsonParamInt(String json, String key) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (Integer) jsonObject.get(key);
	}
	
	/**
	 * 获取json中指定key的long型value值
	 * @param json json字符串
	 * @param key 指定key
	 * @return
	 */
	public static Long getJsonParamLong(String json, String key) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (Long) jsonObject.get(key);
	}
}
