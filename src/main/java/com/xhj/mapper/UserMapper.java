package com.xhj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xhj.entity.User;

@Mapper
public interface UserMapper {
	// 通过用户名查询用户
	@Select("select * from `user` where us_name = #{us_name}")
	User selectUsersByName(String us_name);

	// 向数据库中插入一条用户信息
	@Insert("insert into `user` (us_name,us_password,us_mail,us_authcode,us_level) "
			+ "values(#{us_name},#{us_password},#{us_mail},#{us_authcode},#{us_level})")
	boolean insertUser(User user);

	// 通过用户名字查找用户
	@Select("select * from `user` where us_nickname = #{us_nickname}")
	User sUByNickName(String us_nickname);
}
