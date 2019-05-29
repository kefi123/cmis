package com.xhj.user.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.user.entity.Cindustry;
import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicDisplay;
import com.xhj.user.entity.DynamicPic;
import com.xhj.user.entity.Parent_industry;
import com.xhj.user.entity.User;
import com.xhj.user.entity.UserDetailDisplay;
import com.xhj.user.mapper.CindustryMapper;
import com.xhj.user.mapper.DynamicMapper;
import com.xhj.user.mapper.Parent_industryMapper;
import com.xhj.user.mapper.UserMapper;

@Service
public class UserService {
	
	//先获得动态Mapper类
	@Autowired
	DynamicMapper dm;
	
	//用户Mapper类
	@Autowired
	UserMapper um;
	
	@Autowired
	Parent_industryMapper pim;
	
	@Autowired
	CindustryMapper cim;
	
	// 删除用户信息
	public boolean deleteUser(int u_id) {
		return um.deleteUser(u_id);
	}
	
	// 分页查询用户信息
	public PageInfo<User> getUsers(int page, int size) {
		
		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		
		//获取数据
		List<User> users = um.getUsers();
		
		// 封装分页之后的数据
		PageInfo<User> pageInfoUser = new PageInfo<User>(users);
		
		return pageInfoUser;
	}
	
	//封装用户详情页面的数据返回前台
	public UserDetailDisplay getUserDetail(int u_id){
		
		UserDetailDisplay udd=new UserDetailDisplay();
		
		//获取用户信息
		User user=um.selectUserByID(u_id);
		
		//获取行业信息
		Parent_industry parent_industry=pim.select_parent_industry(user.getP_industry_id());
		Cindustry cindustry=cim.select_child_industry(user.getC_industry_id());
		
		//获取该用户的动态信息
		List<DynamicDisplay> dds=new ArrayList<DynamicDisplay>();
				
		//常见一个展示动态的对象
		DynamicDisplay dd;
		
		//动态图片
		List<DynamicPic> pics;
		
		//获取动态信息
		List<Dynamic> dynamics=dm.selectByUID(user.getU_id());
		for(Dynamic dynamic:dynamics){
			//获取空间
			dd=new DynamicDisplay();
			
			//设置动态信息
			dd.setDynamic(dynamic);
			
			//设置用户信息
			dd.setUser(user);
			
			//读取动态图片信息并设置
			pics=dm.selectPic(dynamic.getDynamic_id());
			dd.setDynamicPic(pics);
			
			dds.add(dd);
		}
		
		//封装数据
		udd.setUser(user);
		udd.setPi(parent_industry);
		udd.setCi(cindustry);
		udd.setDds(dds);
		
		return udd;
	}
	

	// 登录
	public User login(User user) {
		User user_x = um.selectUsersByName(user.getU_name());
		if (user_x != null) {
			if (user.getU_password().equals(user_x.getU_password()))
				return user_x;
			else
				return null;
		} else
			return null;
	}
	
	//更新头像信息
	public boolean updateAvatar(int u_id,String u_avatar){
		return um.updateAvatar(u_id,u_avatar);
	}
	//更新用户信息
	public boolean updateUser(User user){
		return um.updateUser(user);
	}
	

	// 注册
	@Transactional
	public boolean register(User user) {
		return um.insertUser(user);
	}

}
