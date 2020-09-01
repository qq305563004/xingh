package com.tk.mapper;

import java.util.List;

import com.tk.bean.User;
import com.tk.utils.MyMapper;
import com.tk.vo.req.UserReqPageVo;
import com.tk.vo.res.UserResPageVo;

public interface UserMapper extends MyMapper<User> {
	User findUserByName(String name);
	
	int insertGeneratedKey(User user);
	
	List<UserResPageVo> listPagingInfo(UserReqPageVo reqVo);
}