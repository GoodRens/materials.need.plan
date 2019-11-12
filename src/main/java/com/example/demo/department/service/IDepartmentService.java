package com.example.demo.department.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.vo.DepartmentVO;

public interface IDepartmentService {
	/**
	 * 获取部门/层级
	 * 
	 * @param departmentVo
	 * @return
	 */
	CommonResultVO<?> getDepartments(HttpServletRequest request, DepartmentVO departmentVo);

	/**
	 * 创建部门信息
	 * 
	 * @param departmentVos
	 * @return
	 */
	CommonResultVO<?> createDepartments(HttpServletRequest request, List<DepartmentVO> departmentVos);

	/**
	 * 删除部门
	 * 
	 * @param request
	 * @param departmentVos
	 * @return
	 */
	CommonResultVO<?> deleteDepartments(HttpServletRequest request, List<Integer> departmentIds);

}
