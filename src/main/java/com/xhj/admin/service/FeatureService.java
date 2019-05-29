package com.xhj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.admin.entity.Feature;
import com.xhj.admin.mapper.FeatureMapper;

@Service
public class FeatureService {
	@Autowired
	private FeatureMapper featureMapper;

	// 更新人脉信息
	public boolean updateFeature(Feature fe) {
		return featureMapper.updateFeature(fe);
	}

	// 通过id查询特征
	public Feature getFeatureByID(int fe_id) {
		return featureMapper.selectFeatureByID(fe_id);
	}

	// 删除特征
	public boolean deleteFeature(int fe_id) {
		return featureMapper.deleteFeature(fe_id);
	}

	// 通过name查询feature
	public PageInfo<Feature> getFeatureByName(int page, int size, String fe_name) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Feature> features = featureMapper.selectFeaturesByName(fe_name);
		// 封装分页之后的数据
		PageInfo<Feature> pageInfoFeature = new PageInfo<Feature>(features);
		return pageInfoFeature;
	}

	// 查询特征
	public PageInfo<Feature> getFeature(int page, int size) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Feature> features = featureMapper.selectFeatures();
		// 封装分页之后的数据
		PageInfo<Feature> pageInfoFeature = new PageInfo<Feature>(features);
		return pageInfoFeature;
	}

	// 添加特征
	/**
	 * 增加后要commit
	 */
	public boolean addFeature(String fe_name) {
		boolean result = featureMapper.addFeature(fe_name);
		return result;
	}
}
