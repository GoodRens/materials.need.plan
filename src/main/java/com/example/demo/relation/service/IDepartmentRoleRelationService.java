package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.vo.DepartmentRoleRelationVO;

public interface IDepartmentRoleRelationService {

	/**
	 * 批量新增部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVo<?> createDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);

	/**
	 * 批量删除部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVo<?> deleteDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);

	/**
	 * 批量更新部门角色
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVo<?> updateDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList);
}
