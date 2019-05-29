package com.xhj.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.admin.entity.Strategy;

@Mapper
public interface StrategyMapper {

	// 更新策略
	@Update("update strategy set st_feature=#{st_feature},st_content=#{st_content} where st_id=#{st_id}")
	boolean updateStrategy(Strategy strategy);

	// 通过id查询策略
	@Select("select * from `strategy` where st_id=#{st_id}")
	Strategy selectStrategyByID(int st_id);

	// 删除策略
	@Delete("delete from strategy where st_id=#{st_id}")
	boolean deleteStrategy(int st_id);

	// 通过st_feature查询策略
	@Select("select * from `strategy` where st_feature like concat('%',#{st_feature},'%')")
	List<Strategy> selectStrategysByFeature(String st_feature);

	// 查询所有策略
	@Select("select * from `strategy`")
	List<Strategy> selectStrategys();

	// 插入策略
	@Insert("insert into strategy(st_feature,st_content) values(#{st_feature},#{st_content})")
	boolean addStrategy(Strategy strategy);
}
