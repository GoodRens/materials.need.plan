package com.example.demo.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.department.vo.DepartmentVo;

@Mapper
public interface IDepartmentDao {
	/**
	 * 获取部门/层级
	 * 
	 * @param departmentVo
	 * @return
	 */
	public List<DepartmentVo> getDepartments(DepartmentVo departmentVo);

	/**
	 * 创建部门信息
	 * 
	 * @param departmentVos
	 * @return
	 */
	public void createDepartments(List<DepartmentVo> departmentVos);

	/***
	 * 删除部门
	 * 
	 * @param departmentVos
	 */
	public void deleteDepartments(List<Integer> departmentVos);
}
