package com.tk.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`permission`")
public class Permission extends BaseEntity {
	@Column(name = "`parentid`")
	private Integer parentid;

	@Column(name = "`level`")
	private Integer level;

	@Column(name = "`mark`")
	private String mark;

	@Column(name = "`description`")
	private String description;

	/**
	 * ״̬��0��ͣ�á�1�����ã�
	 */
	@Column(name = "`status`")
	private Boolean status;

	/**
	 * ���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
	 */
	@Column(name = "`type`")
	private Boolean type;

	@Column(name = "`action`")
	private String action;

	@Column(name = "`updatetime`")
	private Date updatetime;

	@Column(name = "`createtime`")
	private Date createtime;

	@Column(name = "`createperson`")
	private String createperson;

	/**
	 * @return parentid
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * @param parentid
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取״̬��0��ͣ�á�1�����ã�
	 *
	 * @return status - ״̬��0��ͣ�á�1�����ã�
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 设置״̬��0��ͣ�á�1�����ã�
	 *
	 * @param status ״̬��0��ͣ�á�1�����ã�
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 获取���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
	 *
	 * @return type - ���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
	 */
	public Boolean getType() {
		return type;
	}

	/**
	 * 设置���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
	 *
	 * @param type ���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
	 */
	public void setType(Boolean type) {
		this.type = type;
	}

	/**
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param updatetime
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @return createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return createperson
	 */
	public String getCreateperson() {
		return createperson;
	}

	/**
	 * @param createperson
	 */
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
}