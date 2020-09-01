package com.tk.controller.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tk.constant.RetCodeConstant;
import com.tk.controller.BaseController;
import com.tk.service.PermissionService;
import com.tk.vo.Code;
import com.tk.vo.res.PermissionResVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Api(value = "权限管理")
public class PermissionController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

	@Autowired
	private PermissionService permissionService;

	@ApiOperation(value = "当前用户权限列表")
	//@PreAuthorize("hasAuthority('W_M_QXLB')")
	@RequestMapping(value = "/permission/list", method = RequestMethod.POST)
	public Code<List<PermissionResVo>> list() {
		logger.info("PermissionController:list()");
		Code<List<PermissionResVo>> code = new Code<>(RetCodeConstant.SUCCESS,
				permissionService.getPermissionByUser(getUserName()));
		logger.info("PermissionController:list() SUCCESS");
		return code;
	}
	
	@ApiOperation(value = "权限列表")
	//@PreAuthorize("hasAuthority('W_M_QXLB')")
	@RequestMapping(value = "/permission/listAll", method = RequestMethod.POST)
	public Code<List<PermissionResVo>> listAll() {
		logger.info("PermissionController:list()");
		Code<List<PermissionResVo>> code = new Code<>(RetCodeConstant.SUCCESS,
				permissionService.getAllPermission());
		logger.info("PermissionController:list() SUCCESS");
		return code;
	}	
}
