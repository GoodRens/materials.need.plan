package com.example.demo.relation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.relation.vo.DepartmentUserRelationVO;

@Mapper
public interface IDepartmentUserRelationDao {

	void createDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

	void deleteDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

}
