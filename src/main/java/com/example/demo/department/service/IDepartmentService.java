package com.example.demo.department.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.department.vo.DepartmentVo;
import com.example.demo.login.vo.UserInfoVO;

public interface IDepartmentService {
	/**
	 * 获取部门/层级
	 * 
	 * @param departmentVo
	 * @return
	 */
	CommonResultVo<?> getDepartments(HttpServletRequest request, DepartmentVo departmentVo);

	/**
	 * 创建部门信息
	 * 
	 * @param departmentVos
	 * @return
	 */
	CommonResultVo<?> createDepartments(HttpServletRequest request, List<DepartmentVo> departmentVos);

	/**
	 * 删除部门
	 * 
	 * @param request
	 * @param departmentVos
	 * @return
	 */
	CommonResultVo<?> deleteDepartments(HttpServletRequest request, List<Integer> departmentIds);

	/**
	 * 查询角色所在部门
	 * 
	 * @param request
	 * @param userInfo
	 * @return
	 */
	CommonResultVo<?> getDepartmentByUser(HttpServletRequest request, UserInfoVO userInfo);

}
