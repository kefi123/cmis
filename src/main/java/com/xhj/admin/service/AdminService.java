package com.xhj.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.admin.entity.Admin;
import com.xhj.admin.mapper.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper am;

	//管理员登录
	public Admin adminLogin(Admin admin){
		
		Admin newAdmin = am.selectAdmin(admin.getAdmin_name());
		if (newAdmin != null) {
			if (admin.getAdmin_password().equals(newAdmin.getAdmin_name()))
				return newAdmin;
			else
				return null;
		} 
		else
			return null;
	}
	
}
