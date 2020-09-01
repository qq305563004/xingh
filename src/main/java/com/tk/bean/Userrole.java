package com.tk.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`userrole`")
public class Userrole extends BaseEntity {
    @Column(name = "`userid`")
    private Integer userid;

    @Column(name = "`roleid`")
    private Integer roleid;

    @Column(name = "`updatetime`")
    private Date updatetime;

    @Column(name = "`createtime`")
    private Date createtime;

    @Column(name = "`createperson`")
    private String createperson;

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

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