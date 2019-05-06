package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.xhj.user.entity.Comment;
import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicPic;

@Mapper
public interface DynamicMapper {
	
	
	//往数据库里插入动态信息
	@Insert("insert into t_dynamics (dynamic_user_id,dynamic_content) values (#{dynamic_user_id},#{dynamic_content})")
	@Options(useGeneratedKeys = true, keyProperty = "dynamic_id", keyColumn = "dynamic_id")
	public int insert(Dynamic dynamic);
	
	//往数据库里插入动态图片信息
	@Insert("insert into t_dynamic_pictures (dynamic_id,dynamic_picture_path) values (#{dynamic_id},#{dynamic_picture_path})")
	public int insertPic(DynamicPic dynamicPic);
	
	//从数据库里读出所有的动态信息
	@Select("select * from t_dynamics")
	public List<Dynamic> selectAll();
	
	//读取某用户的所有动态
	@Select("select * from t_dynamics where dynamic_user_id = #{dynamic_user_id}")
	public List<Dynamic> selectByUID(int dynamic_user_id);
	
	//根据动态id读取该动态信息
	@Select("select * from t_dynamics where dynamic_id = #{dynamic_id}")
	public Dynamic selectSingleByDID(int dynamic_id);
	
	//根据动态的id从数据库里读出该动态的图片信息
	@Select("select * from t_dynamic_pictures where dynamic_id = #{dynamic_id}")
	public List<DynamicPic> selectPic(int dynamic_id);
	
	//读取动态所有的评论信息
	@Select("select * from t_comment where dynamic_id = #{dynamic_id}")
	public List<Comment> selectComment(int dynamic_id);
	
	//写入评论
	@Insert("insert into t_comment (dynamic_id,comment_user_id,comment_content) values (#{dynamic_id},#{comment_user_id},#{comment_content})")
	public int insertComment(Comment comment);
	
}
