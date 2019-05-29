package com.xhj.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.admin.entity.Strategy;
import com.xhj.admin.service.StrategyService;

@Controller
public class StrategyController {
	@Autowired
	StrategyService strategyService;

	// 更新策略
	@RequestMapping("/updateStrategy")
	public String updateStrategy(Strategy st, Map<String, Object> map) {
		map.put("status", strategyService.updateStrategy(st));
		return "getStrategy?page=1&size=4";
	}

	// 通过id来查询策略
	@RequestMapping("/getStrategyByID")
	public String getStrategyByID(int st_id, Map<String, Object> map) {
		map.put("strategy", strategyService.getStrategyByID(st_id));
		return "strategy/updatestrategy";
	}

	// 通过特征名称来查询策略信息
	@RequestMapping("/getStrategyByFeature")
	public String getStrategyByFeature(int page, int size, String st_feature, Map<String, Object> map) {
		map.put("pageInfos", strategyService.getStrategyByName(page, size, st_feature));
		map.put("hrefs", "getStrategyByFeature");
		return "strategy/findStrategy";

	}

	// 查询所有的策略
	@RequestMapping("/getStrategy")
	public String getStrategy(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", strategyService.getStrategy(page, size));
		map.put("hrefs", "getStrategy");
		return "strategy/findStrategy";

	}

	// 删除策略
	@RequestMapping("/deleteStrategy")
	public String deleteStrategy(int st_id, Map<String, Object> map) {
		map.put("status", strategyService.deleteStrategy(st_id));
		return "getStrategy?page=1&size=4";
	}

	// 跳转到添加策略页面
	@RequestMapping("/addStrategyFtl")
	public String addStrategy(Map<String, Object> map) {
		map.put("status", false);
		return "strategy/addStrategy";
	}

	// 添加策略信息
	@RequestMapping("/addStrategy")
	public String addStrategy(Strategy strategy, Map<String, Object> map) {
		map.put("status", strategyService.addStrategy(strategy));
		return "strategy/addStrategy";
	}
}
