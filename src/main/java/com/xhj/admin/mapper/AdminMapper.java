package com.xhj.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xhj.admin.entity.Admin;

@Mapper
public interface AdminMapper {
	
	//根据账号查询管理员信息
	@Select("select * from t_admin where admin_name=#{admin_name}")
	public Admin selectAdmin(String admin_name);
	
}
