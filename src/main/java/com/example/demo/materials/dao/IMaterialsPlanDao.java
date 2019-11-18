package com.example.demo.materials.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.vo.MaterialsPlanVO;

@Mapper
public interface IMaterialsPlanDao {

	/**
	 * 添加物料需求计划
	 * 
	 * @param materialsPlanList
	 */
	void deleteNeedPlan(List<MaterialsPlanVO> materialsPlanList);

	/**
	 * 删除物料需求计划
	 * 
	 * @param materialsPlanList
	 */
	void addNeedPlan(List<MaterialsPlanVO> materialsPlanList);

	/**
	 * 查询物料需求计划
	 * 
	 * @param materialsPlan
	 * @return
	 */
	List<MaterialsPlanVO> queryNeedPlan(MaterialsPlanVO materialsPlan);

}
