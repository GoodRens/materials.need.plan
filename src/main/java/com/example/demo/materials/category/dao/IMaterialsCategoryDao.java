package com.example.demo.materials.category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.category.vo.MaterialsCategoryVO;

@Mapper
public interface IMaterialsCategoryDao {

	void addOrUpdateWlCategory(List<MaterialsCategoryVO> materialsCategoryList);

	void deleteWlCategory(List<MaterialsCategoryVO> materialsCategoryList);

	List<MaterialsCategoryVO> queryWlCategory(MaterialsCategoryVO materialsCategory);


}
