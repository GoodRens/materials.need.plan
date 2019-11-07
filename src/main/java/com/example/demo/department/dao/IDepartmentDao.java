package com.example.demo.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.department.vo.DepartmentVo;
import com.example.demo.login.vo.UserInfoVO;

@Mapper
public interface IDepartmentDao {
	/**
	 * 获取部门/层级
	 * 
	 * @param departmentVo
	 * @return
	 */
	List<DepartmentVo> getDepartments(@Param("departments") DepartmentVo departmentVo);

	/**
	 * 创建部门信息
	 * 
	 * @param departmentVos
	 * @return
	 */
	void createDepartments(List<DepartmentVo> departmentVos);

	/***
	 * 删除部门
	 * 
	 * @param departmentVos
	 */
	void deleteDepartments(List<Integer> departmentVos);

	/**
	 * 根据部门名称查询部门
	 * 
	 * @param departmentVos
	 * @return
	 */
	List<DepartmentVo> getDepartmentsByNames(@Param("departments") List<DepartmentVo> departmentVos);

	/***
	 * 查询用户所在的部门
	 * 
	 * @param userInfo
	 * @return
	 */
	List<DepartmentVo> getDepartmentByUser(@Param("userInfo") UserInfoVO userInfo);
}
