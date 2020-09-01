package com.tk.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tk.bean.Permission;
import com.tk.bean.User;
import com.tk.bean.Userrole;
import com.tk.constant.ConstantEnum;
import com.tk.constant.RetCodeConstant;
import com.tk.exception.WebBusinessException;
import com.tk.mapper.PermissionMapper;
import com.tk.mapper.UserMapper;
import com.tk.mapper.UserroleMapper;
import com.tk.security.dto.UserDto;
import com.tk.service.UserService;
import com.tk.utils.PBKDF2Util;
import com.tk.vo.req.AddUserReqVo;
import com.tk.vo.req.UpdateUserReqVo;
import com.tk.vo.req.UserReqPageVo;
import com.tk.vo.res.UserResPageVo;

/**
 * 用户管理
 *
 * @ClassName UserServiceImpl.java
 * @author xingh
 * @version V1.0
 * @date 2019年10月14日
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private UserroleMapper userroleMapper;

	@Override
	public UserDto getUserAndAuthority(String name) {
		User userInfo = userMapper.findUserByName(name);
		if (userInfo == null) {
			return null;
		}
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userInfo, dto);
		List<String> authorityList = new ArrayList<>();
		dto.setAuthorityList(authorityList);
		// 获取权限信息
		for (Permission permission : permissionMapper.findPermissionByName(userInfo.getName())) {
			authorityList.add(permission.getMark());
		}
		return dto;
	}
	
	@Transactional
	@Override
	public void saveUser(AddUserReqVo reqVo, String userName) {
		if (userMapper.findUserByName(reqVo.getName()) != null) {
			throw new WebBusinessException(RetCodeConstant.USER_EXISTS);
		}
		User user = new User();
		BeanUtils.copyProperties(reqVo, user);
		try {
			String salt = PBKDF2Util.generateSalt();
			user.setSalt(salt);
			user.setStatus(ConstantEnum.userStatus.ENABLE.getValue());
	        user.setType(ConstantEnum.userType.ADMIN.getValue());
			user.setPassword(PBKDF2Util.getEncryptedPassword(reqVo.getPassword(), salt));
			user.setCreatetime(new Date());
	        user.setCreateperson(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		userMapper.insert(user);
		Userrole userrole = new Userrole();
		userrole.setUserid(user.getId());
		userrole.setRoleid(reqVo.getRoleid());
		userroleMapper.insert(userrole);
	}
	
	@Transactional
	@Override
	public void deleteUser(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		userMapper.delete(user);
		userroleMapper.deleteUserRole(user.getId());
	}

	@Transactional
	@Override
	public void updateUser(UpdateUserReqVo reqVo) {		
		User user = new User();
		BeanUtils.copyProperties(reqVo, user);
		userMapper.updateByPrimaryKeySelective(user);
		Userrole userrole = userroleMapper.findByUserId(reqVo.getId());
		userrole.setRoleid(reqVo.getRoleid());
		userroleMapper.updateByPrimaryKey(userrole);
	}

	@Override
	public Map<String, Object> userList(UserReqPageVo reqVo,String userName) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(reqVo.getCurrentPage(),reqVo.getPageRows());
		List<UserResPageVo>list = userMapper.listPagingInfo(reqVo);				
		map.put("data", list);
		map.put("total", new PageInfo(list).getTotal());
		return map;
	}
}
