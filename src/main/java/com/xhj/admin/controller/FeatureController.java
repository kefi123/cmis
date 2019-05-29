package com.xhj.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.admin.entity.Feature;
import com.xhj.admin.service.FeatureService;

@Controller
public class FeatureController {
	@Autowired
	FeatureService featureService;

	// 更新人脉信息
	@RequestMapping("/updateFeature")
	public String updateFeature(Feature fe, Map<String, Object> map) {
		map.put("status", featureService.updateFeature(fe));
		return "getFeature?page=1&size=4";
	}

	// 通过id来查询人脉信息
	@RequestMapping("/getFeatureByID")
	public String getFeatureByID(int fe_id, Map<String, Object> map) {
		map.put("feature", featureService.getFeatureByID(fe_id));
		return "feature/updateFeature";
	}

	// 通过特征名称来查询特征
	@RequestMapping("/getFeatureByName")
	public String getFeatureByName(int page, int size, String fe_name, Map<String, Object> map) {
		map.put("pageInfos", featureService.getFeatureByName(page, size, fe_name));
		map.put("hrefs", "getFeatureByName");
		return "feature/findFeature";

	}

	// 查询所有的特征
	@RequestMapping("/getFeature")
	public String getFeature(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", featureService.getFeature(page, size));
		map.put("hrefs", "getFeature");
		return "feature/findFeature";

	}

	// 删除特征
	@RequestMapping("/deleteFeature")
	public String deleteFeature(int fe_id, Map<String, Object> map) {
		map.put("status", featureService.deleteFeature(fe_id));
		return "getFeature?page=1&size=4";
	}

	// 添加特征
	@RequestMapping("/addFeature")
	public String addFeature(String fe_name, Map<String, Object> map) {
		if (fe_name != null)
			map.put("status", featureService.addFeature(fe_name));
		else
			map.put("status", false);
		return "feature/addFeature";
	}

}
