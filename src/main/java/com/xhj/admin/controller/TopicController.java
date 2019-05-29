package com.xhj.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.admin.entity.Topic;
import com.xhj.admin.service.TopicService;

@Controller
public class TopicController {
	@Autowired
	TopicService topicService;

	// 话题大全
	@RequestMapping("/getAllTopic")
	public String getAllTopic() {
		return "topic/allTopic";
	}

	// 每日一招
	@RequestMapping("/getWz")
	public String getWz() {
		return "topic/wz";
	}

	// 更新话题信息
	@RequestMapping("/updateTopic")
	public String updateTopic(Topic topic, Map<String, Object> map) {
		map.put("status", topicService.updateTopic(topic));
		return "getTopic?page=1&size=4";
	}

	// 通过class来查询话题信息
	@RequestMapping("/getTopicByClass")
	public String getTopicByClass(int page, int size, String to_class, Map<String, Object> map) {
		map.put("pageInfos", topicService.getTopicByClass(page, size, to_class));
		map.put("hrefs", "getTopicByClass");
		return "topic/findTopic";

	}

	// 通过id来查询话题信息
	@RequestMapping("/getTopicByID")
	public String getTopicByID(int to_id, Map<String, Object> map) {
		map.put("topic", topicService.getTopicByID(to_id));
		return "topic/updateTopic";
	}

	// 查询所有的话题
	@RequestMapping("/getTopic")
	public String getTopic(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", topicService.getTopic(page, size));
		map.put("hrefs", "getTopic");
		return "topic/findTopic";

	}

	// 删除话题
	@RequestMapping("/deleteTopic")
	public String deleteTopic(int to_id, Map<String, Object> map) {
		map.put("status", topicService.deleteTopic(to_id));
		return "getTopic?page=1&size=4";
	}

	// 跳转到添加话题的页面
	@RequestMapping("/addTopicFtl")
	public String addTopic(Map<String, Object> map) {
		map.put("status", false);
		return "topic/addTopic";
	}

	// 添加话题信息
	@RequestMapping("/addTopic")
	public String addTopic(Topic topic, Map<String, Object> map) {
		map.put("status", topicService.addTopic(topic));
		return "topic/addTopic";
	}
}
