package com.example.demo.relation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.relation.vo.DepartmentUserRelationVO;

@Mapper
public interface IDepartmentUserRelationDao {

	void createDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

	void deleteDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

	DepartmentUserRelationVO getDepartmentUserRelationByUR(@Param("departmentUserRelation")DepartmentUserRelationVO departmentUserRelation);
}
