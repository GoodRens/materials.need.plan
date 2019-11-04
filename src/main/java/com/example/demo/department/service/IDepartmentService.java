package com.example.demo.department.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.department.vo.DepartmentVo;

public interface IDepartmentService {
	/**
	 * 获取部门/层级
	 * 
	 * @param departmentVo
	 * @return
	 */
	public CommonResultVo<?> getDepartments(HttpServletRequest request, @RequestBody DepartmentVo departmentVo);

	/**
	 * 创建部门信息
	 * 
	 * @param departmentVos
	 * @return
	 */
	public CommonResultVo<?> createDepartments(HttpServletRequest request,
			@RequestBody List<DepartmentVo> departmentVos);

	/**
	 * 删除部门
	 * 
	 * @param request
	 * @param departmentVos
	 * @return
	 */
	public CommonResultVo<?> deleteDepartments(HttpServletRequest request, List<Integer> departmentIds);

}
