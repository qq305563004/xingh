package com.tk.mapper;

import java.util.List;

import com.tk.bean.Rolepermission;
import com.tk.utils.MyMapper;

public interface RolepermissionMapper extends MyMapper<Rolepermission> {
	
	List<Rolepermission> findByRolid(int id);
	
}