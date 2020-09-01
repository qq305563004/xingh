package com.tk.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tk.bean.Permission;
import com.tk.bean.Role;
import com.tk.bean.Rolepermission;
import com.tk.constant.ConstantEnum;
import com.tk.constant.RetCodeConstant;
import com.tk.exception.WebBusinessException;
import com.tk.mapper.PermissionMapper;
import com.tk.mapper.RoleMapper;
import com.tk.mapper.RolepermissionMapper;
import com.tk.mapper.UserroleMapper;
import com.tk.service.RoleService;
import com.tk.utils.TreeUtils;
import com.tk.vo.req.AddRoleReqVo;
import com.tk.vo.req.RoleReqPageVo;
import com.tk.vo.req.UpdateRoleReqVo;
import com.tk.vo.res.PermissionResVo;
import com.tk.vo.res.RoleResPageVo;
import com.tk.vo.res.RoleResVo;

/**
 * 角色管理
 * 
 * @author xingh
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RolepermissionMapper rolepermissionMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private UserroleMapper userroleMapper;


	@Transactional
	@Override
	public void addRole(AddRoleReqVo reqVo, int roleType, String userName) {
		String roleName = reqVo.getRolename();
		if (roleMapper.findByRoleName(roleName) != null) {
			throw new WebBusinessException(RetCodeConstant.ROLE_ALREADY_EXISTS);
		}
		Role role = new Role();
		role.setRolename(roleName);
		role.setType(roleType);
		role.setLevel(ConstantEnum.roleLevel.DISPLAY.getValue());
		role.setCreateperson(userName);
		role.setCreatetime(new Date());
		roleMapper.insert(role);
		List<Rolepermission> rpList = new ArrayList<>();
		List<Integer> permVoList = reqVo.getPermissionList();
		Collections.sort(permVoList);
		for (Integer permissionId : permVoList) {
			Rolepermission rolepermission = new Rolepermission();
			rolepermission.setPermissionid(permissionId);
			rolepermission.setRoleid(role.getId());
			rpList.add(rolepermission);
		}
		rolepermissionMapper.insertList(rpList);
	}

	@Transactional
	@Override
	public void updateRole(UpdateRoleReqVo reqVo) {
		List<Rolepermission> rolepermissions = permissionMapper.findByPermissionid(reqVo.getRoleid());
		for (Rolepermission rolepermission : rolepermissions) {
			rolepermissionMapper.delete(rolepermission);
		}
		List<Rolepermission> rpList = new ArrayList<>();
		for (Integer integer : reqVo.getPermissionList()) {
			Rolepermission rolepermission = new Rolepermission();
			rolepermission.setRoleid(reqVo.getRoleid());
			rolepermission.setPermissionid(integer);
			rpList.add(rolepermission);
		}
		rolepermissionMapper.insertList(rpList);
	}

	@Transactional
	@Override
	public void deleteRole(int id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		List<Rolepermission> rolepermissions = rolepermissionMapper.findByRolid(id);
		if (!StringUtils.isEmpty(userroleMapper.findByRoleId(id))) {
			throw new WebBusinessException(RetCodeConstant.ROLE_USE);
		}
		for (Rolepermission rolepermission : rolepermissions) {
			rolepermissionMapper.delete(rolepermission);
		}
		roleMapper.delete(role);
	}
	
	@Override
	public Map<String, Object> roleList(RoleReqPageVo reqVo){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(reqVo.getCurrentPage(),reqVo.getPageRows());
		List<RoleResPageVo>list = roleMapper.listPagingInfo();
		map.put("data", list);
		map.put("total", new PageInfo(list).getTotal());
		return map;
	}

	@Override
	public List<PermissionResVo> getRole(int id, String userName) {
		//获取所有的菜单
		List<Permission> list = permissionMapper.findByStatusAndType(ConstantEnum.permissionStatus.ENABLE.getValue(),
				ConstantEnum.permissionType.WEB.getValue());
		List<PermissionResVo> pmsList = new ArrayList<PermissionResVo>();
		for (Permission permInfo : list) {
			pmsList.add(new PermissionResVo(permInfo.getId(), permInfo.getParentid(), permInfo.getDescription(),
					permInfo.getLevel(), permInfo.getMark()));
		}
		//获取该角色的菜单
		List<Permission> permissions = permissionMapper.findPermissionByRoleId(id);
		List<PermissionResVo> rolePmsList = new ArrayList<PermissionResVo>();
		for (Permission permInfo : permissions) {
			rolePmsList.add(new PermissionResVo(permInfo.getId(), permInfo.getParentid(), permInfo.getDescription(),
					permInfo.getLevel(), permInfo.getMark()));
		}
		TreeUtils.selectedLogics(rolePmsList, pmsList);
		return TreeUtils.conversionTree(pmsList);
	}

	@Override
	public List<RoleResVo> roleList() {		
		return roleMapper.roleList();
	}
}
