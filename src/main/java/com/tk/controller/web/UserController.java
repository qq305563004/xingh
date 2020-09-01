package com.tk.controller.web;

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

import com.tk.constant.RetCodeConstant;
import com.tk.controller.BaseController;
import com.tk.service.UserService;
import com.tk.vo.Code;
import com.tk.vo.req.AddUserReqVo;
import com.tk.vo.req.IdReqVo;
import com.tk.vo.req.UpdateUserReqVo;
import com.tk.vo.req.UserReqPageVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 系统账户管理
 * @author xingh
 *
 */
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Api(value = "系统账户管理")
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @ApiOperation(value = "添加系统账户")
    @PreAuthorize("hasAuthority('W_M_XTZHTJ')")
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Code<Object> saveUser(@Valid @RequestBody AddUserReqVo reqVo) {
        logger.info("UserController:saveUser()");
        userService.saveUser(reqVo, getUserName());
        logger.info("UserController:saveUser() SUCCESS");
        return new Code<>(RetCodeConstant.SUCCESS);
    }
    
    @ApiOperation(value = "删除当前系统用户")
    @PreAuthorize("hasAuthority('W_F_XTZHSC')")
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public Code<Object> deleteUser(@Valid @RequestBody IdReqVo reqVo){
    	logger.info("UserController:deleteUser()");
        userService.deleteUser(reqVo.getId());
        logger.info("UserController:deleteUser() SUCCESS");
        return new Code<>(RetCodeConstant.SUCCESS);
    }
    
    @ApiOperation(value = "修改当前系统用户")
    @PreAuthorize("hasAuthority('W_F_XTZHXG')")
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Code<Object> updateUser(@Valid @RequestBody UpdateUserReqVo reqVo) {
        logger.info("UserController:updateUser()");
        userService.updateUser(reqVo);
        logger.info("UserController:updateUser() SUCCESS");
        return new Code<>(RetCodeConstant.SUCCESS);
    }
    
    @ApiOperation(value = "系统账户一览")
    @PreAuthorize("hasAuthority('W_M_XTZHYL')")
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public Code<Map<String, Object>> list(@Valid @RequestBody UserReqPageVo reqVo) {
        logger.info("UserController:list()");
        Code<Map<String, Object>> code = new Code<>(RetCodeConstant.SUCCESS, userService.userList(reqVo,getUserName()));
        logger.info("UserController:list() SUCCESS");
        return code;
    }
}
