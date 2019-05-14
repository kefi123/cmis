package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.user.entity.MailFriend;

@Mapper
public interface MailFriendMapper {
	
	//修改邮箱好友的状态
	@Update("update t_mf set mf_delete=#{mf_delete} where mf_mail=#{mf_mail}")
	public boolean updateMfStatus(MailFriend mf);
	
	//根据邮箱查询是否存在好友记录
	@Select("select * from t_mf where mf_mail = #{mf_mail}")
	public MailFriend selectMFbyMail(String mf_mail);
	
	//往数据库里插入邮箱好友的信息
	@Insert("insert into t_mf(mf_uid,mf_name,mf_mail) values(#{mf_uid},#{mf_name},#{mf_mail})")
	public boolean insertMF(MailFriend mf);
	
	//更新邮箱好友的联系次数
	@Update("update t_mf set mf_num=mf_num+1 where mf_mail=#{mf_mail}")
	public boolean updateNum(String mf_mail);
	
	//删除某用户下的所有邮箱好友
	@Delete("delete from t_mf where mf_uid=#{mf_uid}")
	public boolean deleteMf(int mf_uid);
	
	//查询当前用户下所有形式导入和未导入的邮箱好友数据
	@Select("select * from t_mf where mf_uid=#{mf_uid}")
	public List<MailFriend> getAllMf(int mf_uid);
	
	//查询当前用户下已导入的邮箱好友数据
	@Select("select * from t_mf where mf_uid=#{mf_uid} and mf_delete=1")
	public List<MailFriend> getMf(int mf_uid);
}
