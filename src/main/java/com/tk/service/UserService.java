package com.tk.service;

import java.util.Map;

import com.tk.security.dto.UserDto;
import com.tk.vo.req.AddUserReqVo;
import com.tk.vo.req.UpdateUserReqVo;
import com.tk.vo.req.UserReqPageVo;

/**
 * 用户Service
 *
 * @ClassName UserService.java
 * @author jingchaof
 * @version V1.0
 * @date 2019年3月28日
 */
public interface UserService {

	/**
	 * 获取用户与权限信息
	 * 
	 * @param name 用户名
	 * @return
	 */
	UserDto getUserAndAuthority(String name);
	
	/**
	 * 添加用户
	 * 
	 * @param userName 添加用户的管理员
	 */
	void saveUser(AddUserReqVo reqVo,String userName);
	
	/**
	 * 删除用户
	 */
	void deleteUser(Integer id);
	
	/**
	 * 修改用户
	 */
	void updateUser(UpdateUserReqVo reqVo);
	
	/**
	 * 用户分页列表
	 */
	Map<String, Object> userList(UserReqPageVo reqVo,String userName);


}
