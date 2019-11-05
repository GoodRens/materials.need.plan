package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.vo.DepartmentUserRelationVO;

public interface IDepartmentUserRelationService {

	/**
	 * 批量新增部门成员
	 * 
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVo<?> createDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList);

	/**
	 * 删除部门成员
	 * 
	 * @param request
	 * @param departmentUserRelationList
	 * @return
	 */
	CommonResultVo<?> deleteDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList);
}
