package com.example.demo.materials.category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.category.vo.MaterialsCategoryVO;

@Mapper
public interface IMaterialsCategoryDao {

	/**
	 * 添加物料分类
	 * 
	 * @param materialsCategoryList
	 */
	void addOrUpdateWlCategory(List<MaterialsCategoryVO> materialsCategoryList);

	/**
	 * 删除物料分类
	 * 
	 * @param materialsCategoryList
	 */
	void deleteWlCategory(List<MaterialsCategoryVO> materialsCategoryList);

	/**
	 * 查询物料分类
	 * 
	 * @param materialsCategory
	 * @return
	 */
	List<MaterialsCategoryVO> queryWlCategory(MaterialsCategoryVO materialsCategory);

}
