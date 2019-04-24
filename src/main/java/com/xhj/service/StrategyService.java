package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.entity.Strategy;
import com.xhj.mapper.StrategyMapper;

@Service
public class StrategyService {
	@Autowired
	private StrategyMapper strategyMapper;

	// 更新策略信息
	public boolean updateStrategy(Strategy st) {
		return strategyMapper.updateStrategy(st);
	}

	// 通过id查询策略
	public Strategy getStrategyByID(int st_id) {
		return strategyMapper.selectStrategyByID(st_id);
	}

	// 删除策略
	public boolean deleteStrategy(int st_id) {
		return strategyMapper.deleteStrategy(st_id);
	}

	// 通过name查询策略
	public PageInfo<Strategy> getStrategyByName(int page, int size, String st_feature) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Strategy> strategys = strategyMapper.selectStrategysByFeature(st_feature);
		// 封装分页之后的数据
		PageInfo<Strategy> pageInfoStrategy = new PageInfo<Strategy>(strategys);
		return pageInfoStrategy;
	}

	// 查询策略
	public PageInfo<Strategy> getStrategy(int page, int size) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Strategy> strategys = strategyMapper.selectStrategys();
		// 封装分页之后的数据
		PageInfo<Strategy> pageInfoStrategy = new PageInfo<Strategy>(strategys);
		return pageInfoStrategy;
	}

	// 添加策略
	public boolean addStrategy(Strategy strategy) {
		return strategyMapper.addStrategy(strategy);
	}
}
