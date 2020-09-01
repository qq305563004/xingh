package com.tk.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`role`")
public class Role extends BaseEntity {
    @Column(name = "`rolename`")
    private String rolename;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "`level`")
    private Integer level;

    @Column(name = "`updatetime`")
    private Date updatetime;

    @Column(name = "`createtime`")
    private Date createtime;

    @Column(name = "`createperson`")
    private String createperson;

    /**
     * @return rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 获取���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
     *
     * @return type - ���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
     *
     * @param type ���ͣ�1��WebȨ�ޡ�2��IntfȨ�ޣ�
     */
    public void setType(Integer type) {
        this.type = type;
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