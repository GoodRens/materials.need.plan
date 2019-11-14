package com.example.demo.materials.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.materials.vo.MaterialsVO;

@Mapper
public interface IMaterialsDao {

	void addOrUpdateWl(List<MaterialsVO> materialsList);

	void deleteWl(List<MaterialsVO> materialsList);

	List<MaterialsVO> queryWl(MaterialsVO materials);

}
