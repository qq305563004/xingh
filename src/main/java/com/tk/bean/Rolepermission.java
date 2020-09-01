package com.tk.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`rolepermission`")
public class Rolepermission extends BaseEntity {
    @Column(name = "`roleid`")
    private Integer roleid;

    @Column(name = "`permissionid`")
    private Integer permissionid;

    @Column(name = "`updatetime`")
    private Date updatetime;

    @Column(name = "`createtime`")
    private Date createtime;

    @Column(name = "`createperson`")
    private String createperson;

    /**
     * @return roleid
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return permissionid
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * @param permissionid
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
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