package com.example.demo.unit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.unit.vo.UnitVO;

@Mapper
public interface IUnitDao {

	List<UnitVO> Deleteunit(List<UnitVO> unitList);

	void AddOrUpdateunit(List<UnitVO> unitList);

	List<UnitVO> Queryunit(List<UnitVO> unitList);

}
