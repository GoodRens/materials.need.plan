package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.vo.DepartmentUserRelationVO;

public interface IDepartmentRoleRelationService {

	/**
	 * 批量新增部门成员
	 * 
	 * @param departmentUserRelationList
	 * @return
	 */
	public CommonResultVo<?> createDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList);
}
