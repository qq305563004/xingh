package com.tk.vo;

import com.tk.utils.MsgUtils;

public class Code<T> {

	/**
	 * 状态码
	 */
	private int status;

	/**
	 * 响应信息
	 */
	private String message;

	/**
	 * 值对象
	 */
	private T data;

	public Code() {
		super();
	}

	public Code(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Code(int status, T data) {
		this.status = status;
		this.data = data;
	}

	public Code(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Code(int retCode) {
		this.status = retCode;
		this.message = MsgUtils.getMsg(retCode);
	}

	public Code(String retCode) {
		this.status = Integer.parseInt(retCode);
		this.message = MsgUtils.getMsg(retCode);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Code [status=" + status + ", message=" + message + "]";
	}

}
