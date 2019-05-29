package com.xhj.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.admin.entity.Topic;

@Mapper
public interface TopicMapper {
	// 更新话题信息
	@Update("update topic set to_class=#{to_class},to_content=#{to_content} where to_id=#{to_id}")
	boolean updateTopic(Topic topic);

	// 删除话题
	@Delete("delete from topic where to_id=#{to_id}")
	boolean deleteTopic(int to_id);

	// 通过class查询话题
	@Select("select * from `topic` where to_class like concat('%',#{to_class},'%')")
	List<Topic> selectTopicsByClass(String to_class);

	// 通过id查询话题
	@Select("select * from `Topic` where to_id=#{to_id}")
	Topic selectTopicByID(int to_id);

	// 查询所有话题
	@Select("select * from `Topic`")
	List<Topic> selectTopics();

	// 插入话题
	@Insert("insert into Topic(to_class,to_content) "
			+ "values(#{to_class},#{to_content})")
	boolean addTopic(Topic topic);
}
