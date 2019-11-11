package com.example.demo.relation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.vo.DepartmentUserRelationVO;

@Mapper
public interface IDepartmentUserRelationDao {

	/**
	 * 批量创建部门用户
	 * 
	 * @param departmentUserRelationList
	 */
	void createDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

	/**
	 * 批量删除部门用户
	 * 
	 * @param departmentUserRelationList
	 */
	void deleteDepartmentUserRelations(List<DepartmentUserRelationVO> departmentUserRelationList);

	/**
	 * 根据部门id和用户id查询该关系
	 * 
	 * @param departmentUserRelation
	 * @return
	 */
	DepartmentUserRelationVO getDepartmentUserRelationByUR(
			@Param("departmentUserRelation") DepartmentUserRelationVO departmentUserRelation);

	/**
	 * 获取用户的部门
	 * 
	 * @param userInfo
	 * @return
	 */
	List<DepartmentVO> getDepartmentByUser(@Param("userInfo") UserInfoVO userInfo);
}
