package com.example.demo.unit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.unit.vo.UnitVO;

@Mapper
public interface IUnitDao {

	void Deleteunit(List<UnitVO> unitList);

	void AddOrUpdateunit(List<UnitVO> unitList);

	List<UnitVO> Queryunit(@Param("unit")UnitVO unitList);

}
