package com.xhj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.admin.entity.Topic;
import com.xhj.admin.mapper.TopicMapper;

@Service
public class TopicService {
	@Autowired
	TopicMapper topicMapper;

	// 更新话题信息
	public boolean updateTopic(Topic topic) {
		return topicMapper.updateTopic(topic);
	}

	// 删除话题
	public boolean deleteTopic(int to_id) {
		return topicMapper.deleteTopic(to_id);
	}

	// 通过class查询话题
	public PageInfo<Topic> getTopicByClass(int page, int size, String to_class) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Topic> topics = topicMapper.selectTopicsByClass(to_class);
		// 封装分页之后的数据
		PageInfo<Topic> pageInfoTopic = new PageInfo<Topic>(topics);
		return pageInfoTopic;
	}

	// 通过id查询话题
	public Topic getTopicByID(int to_id) {
		return topicMapper.selectTopicByID(to_id);
	}

	// 查询话题
	public PageInfo<Topic> getTopic(int page, int size) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Topic> topics = topicMapper.selectTopics();
		// 封装分页之后的数据
		PageInfo<Topic> pageInfoTopic = new PageInfo<Topic>(topics);
		return pageInfoTopic;
	}

	// 添加话题
	public boolean addTopic(Topic topic) {
		boolean result = topicMapper.addTopic(topic);
		return result;
	}
}
