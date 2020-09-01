package com.tk.vo.req;

import javax.validation.constraints.Min;

/**
 * ID request VO
 *
 * @ClassName IdReqVo.java
 * @author xingh
 * @version V1.0
 * @date 2018年7月9日
 */
public class IdReqVo {

    @Min(1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdReqVo [id=" + id + "]";
    }

}
