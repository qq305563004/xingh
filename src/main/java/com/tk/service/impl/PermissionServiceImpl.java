package com.tk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tk.bean.Permission;
import com.tk.bean.User;
import com.tk.constant.Constant;
import com.tk.constant.ConstantEnum;
import com.tk.constant.RetCodeConstant;
import com.tk.exception.WebBusinessException;
import com.tk.mapper.PermissionMapper;
import com.tk.mapper.UserMapper;
import com.tk.service.PermissionService;
import com.tk.utils.TreeUtils;
import com.tk.vo.res.PermissionResVo;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<PermissionResVo> getAllPermission() {
		List<Permission> list = permissionMapper.findByStatusAndType(ConstantEnum.permissionStatus.ENABLE.getValue(),
				ConstantEnum.permissionType.WEB.getValue());
		List<PermissionResVo> rolePmsList = new ArrayList<PermissionResVo>();
		for (Permission permInfo : list) {
			rolePmsList.add(new PermissionResVo(permInfo.getId(), permInfo.getParentid(), permInfo.getDescription(),
					permInfo.getLevel(), permInfo.getMark()));
		}
		return TreeUtils.conversionTree(rolePmsList);
	}

	@Override
	public List<PermissionResVo> getPermissionByUser(String userName) {
		User user = userMapper.findUserByName(userName);
		if (user == null) {
			throw new WebBusinessException(RetCodeConstant.USER_NOT_EXISTS);
		}
		List<Permission> pmsList = new ArrayList<Permission>();
		if (user.getId() == Constant.SUPER_ADMIN_ID) {
			pmsList = permissionMapper.findByStatusAndType(ConstantEnum.permissionStatus.ENABLE.getValue(),
					ConstantEnum.permissionType.WEB.getValue());
		}
		List<PermissionResVo> permissionVo = new ArrayList<>();
		for (Permission permInfo : pmsList) {
			permissionVo.add(new PermissionResVo(permInfo.getId(), permInfo.getParentid(), permInfo.getDescription(),
					permInfo.getLevel(), permInfo.getMark()));
		}
		return TreeUtils.conversionTree(permissionVo);
	}

}
