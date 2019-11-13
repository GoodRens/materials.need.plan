package com.example.demo.materials.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.vo.MaterialsPlanVO;

@Mapper
public interface IMaterialsPlanDao {


	void deleteNeedPlan(List<MaterialsPlanVO> materialsPlanList);

	void addNeedPlan(List<MaterialsPlanVO> materialsPlanList);

	List<MaterialsPlanVO> queryNeedPlan(MaterialsPlanVO materialsPlan);

}
