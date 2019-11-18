package com.example.demo.materials.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.vo.MaterialsVO;

@Mapper
public interface IMaterialsDao {

	/**
	 * 添加物料
	 * 
	 * @param materialsList
	 */
	void addOrUpdateWl(List<MaterialsVO> materialsList);

	/**
	 * 删除物料
	 * 
	 * @param materialsList
	 */
	void deleteWl(List<MaterialsVO> materialsList);

	/**
	 * 删除物料
	 * 
	 * @param materials
	 * @return
	 */
	List<MaterialsVO> queryWl(MaterialsVO materials);

}
