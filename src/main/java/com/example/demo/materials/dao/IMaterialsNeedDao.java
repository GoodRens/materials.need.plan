package com.example.demo.materials.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.vo.MaterialsNeedVO;

@Mapper
public interface IMaterialsNeedDao {


	/**
	 * 批量新增物料需求信息
	 * 
	 * @param materialsNeedList
	 */
	void createMaterialNeeds(List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量删除物料需求信息
	 * 
	 * @param materialsNeedList
	 */
	void deleteMaterialNeeds(List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量更新新增物料需求信息
	 * 
	 * @param materialsNeedList
	 */
	void updateMaterialNeeds(List<MaterialsNeedVO> materialsNeedList);
}
