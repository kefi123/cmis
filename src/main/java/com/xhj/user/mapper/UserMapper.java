package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.user.entity.User;

@Mapper
public interface UserMapper {
	
	//删除用户
	@Delete("delete from t_user where u_id = #{u_id}")
	boolean deleteUser(int u_id);
	
	// 通过用户名查询用户
	@Select("select * from `t_user` where u_name = #{u_name}")
	User selectUsersByName(String u_name);
	
	// 通过ID查询用户
	@Select("select * from `t_user` where u_id = #{u_id}")
	User selectUserByID(int u_id);

	//更新头像信息
	@Update("update t_user set u_avatar=#{u_avatar} where u_id=#{u_id}")
	boolean updateAvatar(@Param(value = "u_id") int u_id,@Param(value = "u_avatar") String u_avatar);
	
	//更新用户信息
	@Update("update t_user set u_realname=#{u_realname},u_sex=#{u_sex},u_mail=#{u_mail},p_industry_id=#{p_industry_id},c_industry_id=#{c_industry_id},u_company=#{u_company},u_position=#{u_position} where u_id=#{u_id}")
	boolean updateUser(User user);
	
	// 向数据库中插入一条用户信息(只包括用户名密码)
	@Insert("insert into `t_user` (u_name,u_password) "
			+ "values(#{u_name},#{u_password})")
	boolean insertUser(User user);

	// 通过用户名字查找用户
	@Select("select * from `user` where us_nickname = #{us_nickname}")
	User sUByNickName(String us_nickname);
	
	//查询所有用户的id
	@Select("select u_id from `t_user`")
	public List<Integer> getAllID();
	
	//查询所有用户的信息
	@Select("select * from t_user")
	public List<User> getUsers();
}
