package com.tk.controller.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tk.constant.ConstantEnum;
import com.tk.constant.RetCodeConstant;
import com.tk.controller.BaseController;
import com.tk.service.RoleService;
import com.tk.vo.Code;
import com.tk.vo.req.AddRoleReqVo;
import com.tk.vo.req.IdReqVo;
import com.tk.vo.req.RoleReqPageVo;
import com.tk.vo.req.UpdateRoleReqVo;
import com.tk.vo.res.PermissionResVo;
import com.tk.vo.res.RoleResVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色管理
 * 
 * @author xingh
 *
 */
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Api(value = "角色管理")
public class RoleController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "角色添加")
	@PreAuthorize("hasAuthority('W_M_JSTJ')")
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public Code<Object> saveRole(@Valid @RequestBody AddRoleReqVo reqVo) {
		logger.info("RoleController:add()");
		roleService.addRole(reqVo, ConstantEnum.roleType.WEB.getValue(), getUserName());
		logger.info("RoleController:add() SUCCESS");
		return new Code<>(RetCodeConstant.SUCCESS);
	}

	@ApiOperation(value = "角色更新")
	@PreAuthorize("hasAuthority('W_F_JSXG')")
	@RequestMapping(value = "/role/update", method = RequestMethod.POST)
	public Code<Object> update(@Valid @RequestBody UpdateRoleReqVo reqVo) {
		logger.info("RoleController:update()");
		roleService.updateRole(reqVo);
		logger.info("RoleController:update() SUCCESS");
		return new Code<>(RetCodeConstant.SUCCESS);
	}

	@ApiOperation(value = "角色删除")
	@PreAuthorize("hasAuthority('W_F_JSSC')")
	@RequestMapping(value = "/role/delete", method = RequestMethod.POST)
	public Code<Object> delete(@Valid @RequestBody IdReqVo reqVo) {
		logger.info("RoleController:delete()");
		roleService.deleteRole(reqVo.getId());
		logger.info("RoleController:delete() SUCCESS");
		return new Code<>(RetCodeConstant.SUCCESS);
	}
	
	@ApiOperation(value = "角色分页列表")
    @PreAuthorize("hasAuthority('W_M_JSYL')")
    @RequestMapping(value = "/role/list", method = RequestMethod.POST)
    public Code<Map<String, Object>> list(@Valid @RequestBody RoleReqPageVo reqVo) {
        logger.info("RoleController:list()");
        Code<Map<String, Object>> code = new Code<>(RetCodeConstant.SUCCESS, roleService.roleList(reqVo));
        logger.info("RoleController:list() SUCCESS");
        return code;
    }
	
	@ApiOperation(value = "获取角色")
    @RequestMapping(value = "/role/getRole", method = RequestMethod.POST)
    public Code<List<PermissionResVo>> getRole(@Valid @RequestBody IdReqVo reqVo) {
        logger.info("RoleController:getRole()");
        Code<List<PermissionResVo>> code = new Code<>(RetCodeConstant.SUCCESS, roleService.getRole(reqVo.getId(), getUserName()));
        logger.info("RoleController:getRole() SUCCESS");
        return code;
    }
	
	@ApiOperation(value = "角色下拉列表")
    @RequestMapping(value = "/role/roleList", method = RequestMethod.POST)
    public Code<List<RoleResVo>> roleList() {
        logger.info("RoleController:roleList()");
        Code<List<RoleResVo>> code = new Code<>(RetCodeConstant.SUCCESS, roleService.roleList());
        logger.info("RoleController:roleList() SUCCESS");
        return code;
    }
}
