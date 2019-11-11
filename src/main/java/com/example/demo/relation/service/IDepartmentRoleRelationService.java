package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.relation.vo.DepartmentRoleRelationVO;

public interface IDepartmentRoleRelationService {

	/**
	 * 批量新增部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVO<?> createDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);

	/**
	 * 批量删除部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVO<?> deleteDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);

	/**
	 * 批量更新部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVO<?> updateDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);

	/**
	 * 查询部门下的角色
	 * 
	 * @param request
	 * @param department
	 * @return
	 */
	CommonResultVO<?> getRoleByDepartmentId(HttpServletRequest request, List<DepartmentVO> department);
}
