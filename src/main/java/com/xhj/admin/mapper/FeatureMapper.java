package com.xhj.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.admin.entity.Feature;

@Mapper
public interface FeatureMapper {

	// 更新特征
	@Update("update feature set fe_name=#{fe_name} where fe_id=#{fe_id}")
	boolean updateFeature(Feature feature);

	// 通过id查询特征
	@Select("select * from `feature` where fe_id=#{fe_id}")
	Feature selectFeatureByID(int fe_id);

	// 删除特征
	@Delete("delete from feature where fe_id=#{fe_id}")
	boolean deleteFeature(int fe_id);

	// 通过name查询特征
	@Select("select * from `feature` where fe_name like concat('%',#{fe_name},'%')")
	List<Feature> selectFeaturesByName(String fe_name);

	// 查询所有特征
	@Select("select * from `feature`")
	List<Feature> selectFeatures();

	// 插入特征
	@Insert("insert into feature(fe_name) values(#{fe_name})")
	boolean addFeature(String fe_name);
}
