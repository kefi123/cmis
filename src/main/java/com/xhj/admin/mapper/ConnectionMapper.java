package com.xhj.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.admin.entity.Connection;

@Mapper
public interface ConnectionMapper {
	// 更新人脉邮件往来的次数
	@Update("update connection set co_num=co_num+1 where co_id=#{co_id}")
	boolean updateConNum(int co_id);

	// 更新人脉信息
	@Update("update connection set co_name=#{co_name},co_sex=#{co_sex},co_feature=#{co_feature},co_phone=#{co_phone},co_address=#{co_address},co_remarks=#{co_remarks} where co_id=#{co_id}")
	boolean updateConnection(Connection connection);

	// 删除人脉
	@Delete("delete from connection where co_id=#{co_id}")
	boolean deleteConnection(int co_id);

	// 通过co_name模糊查询人脉
	@Select("select * from `connection` where co_name like concat('%',#{co_name},'%')")
	List<Connection> selectConnectionsByName(String co_name);

	// 通过co_name精确查询人脉
	@Select("select * from `connection` where co_name=#{co_name}")
	Connection aselectConByName(String co_name);

	// 通过co_mail查询人脉
	@Select("select * from `connection` where co_mail=#{co_mail}")
	Connection selectConnectionsByMail(String co_mail);

	// 通过co_id查询人脉
	@Select("select * from `connection` where co_id=#{co_id}")
	Connection selectConnectionByID(int co_id);

	// 通过co_us_name查询人脉
	@Select("select * from `connection` where co_us_name=#{co_us_name}")
	List<Connection> selectConByUname(String co_us_name);

	//查找某用户下的某个人脉
	@Select("select * from `connection` where co_us_name=#{co_us_name} and co_name=#{co_name}")
	Connection seConByUname(Connection con);

	// 查询所有人脉
	@Select("select * from `connection`")
	List<Connection> selectConnections();

	// 插入人脉
	@Insert("insert into connection(co_us_name,co_name,co_mail,co_sex,co_feature,co_address,co_phone,co_remarks,co_num) "
			+ "values(#{co_us_name},#{co_name},#{co_mail},#{co_sex},#{co_feature},#{co_address},#{co_phone},#{co_remarks},#{co_num})")
	boolean addConnection(Connection connection);
}
