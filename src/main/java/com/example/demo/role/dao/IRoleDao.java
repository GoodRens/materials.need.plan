package com.example.demo.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.role.vo.RoleVO;

@Mapper
public interface IRoleDao {

	/**
	 * 新增角色
	 * 
	 * @param roleList
	 */
	void createRoles(List<RoleVO> roleList);

	/**
	 * 获取所有角色
	 */
	List<RoleVO> getAllRoles();

	/**
	 * 根据id查询角色
	 * 
	 * @param id
	 * @return
	 */
	int getRoleById(@Param("id") int id);

	/**
	 * 删除角色，支持批量
	 * 
	 * @param roleList
	 */
	void deleteRoles(List<Integer> roleIds);

	/**
	 * 根据角色名称获取角色
	 */
	List<RoleVO> getAllRolesByNames(List<RoleVO> roleIds);

	/**
	 * 查询用户的角色
	 * 
	 * @param userInfo
	 * @return
	 */
	List<RoleVO> getRolesByUser(@Param("userInfo") UserInfoVO userInfo);
}
