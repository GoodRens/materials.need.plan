package com.example.demo.relation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.relation.vo.DepartmentRoleRelationVO;
import com.example.demo.role.vo.RoleVO;

@Mapper
public interface IDepartmentRoleRelationDao {

	/**
	 * 批量新增部门角色
	 * 
	 * @param departmentRolerRelationList
	 * @return
	 */
	void createDepartmentRoleRelations(List<DepartmentRoleRelationVO> departmentRolerRelationList);

	/**
	 * 批量删除部门角色
	 * 
	 * @param departmentRolerRelationList
	 * @return
	 */
	void deleteDepartmentRoleRelations(List<DepartmentRoleRelationVO> departmentRolerRelationList);

	/**
	 * 批量更新部门角色
	 * 
	 * @param departmentRolerRelationList
	 * @return
	 */
	void updatedeleteDepartmentRoleRelations(List<DepartmentRoleRelationVO> departmentRolerRelationList);

	/**
	 * 根据部门id和角色id查询该部门角色关系
	 * 
	 * @param departmentRolerRelation
	 * @return
	 */
	DepartmentRoleRelationVO getDepartmentRoleRelationByUR(
			@Param("departmentRoleRelation") DepartmentRoleRelationVO departmentRolerRelation);

	/**
	 * 查询部门的角色
	 * 
	 * @param department
	 * @return
	 */
	List<RoleVO> getRoleByDepartmentId(DepartmentVO department);

}
