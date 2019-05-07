package com.xhj.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.user.entity.Notice;

@Mapper
public interface NoticeMapper {
	
	//向数据库里插入通知信息
	@Insert("insert into t_notice (senduser_id,receiveuser_id,notice_time) values (#{senduser_id},#{receiveuser_id},now())")
	public boolean insertNotice(Notice notice);
	
	//根据用户id查找该用户的所有通知
	@Select("select * from t_notice where receiveuser_id=#{receiveuser_id}")
	public List<Notice> selectNoticeByID(int receiveuser_id);
	
	//更改通知的状态
	@Update("update t_notice set status=#{status} where notice_id=#{notice_id}")
	public boolean updateNotice(Notice notice);
}
