package com.example.demo.relation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.vo.UserRoleRelationVO;
import com.example.demo.role.vo.RoleVO;

@Mapper
public interface IUserRoleRelationDao {

	/**
	 * 批量创建用户角色
	 * 
	 * @param userRoleRelation
	 * @return
	 */
	void createUserRoleRelations(List<UserRoleRelationVO> userRoleRelation);

	/**
	 * 批量删除用户角色
	 * 
	 * @param userRoleRelation
	 * @return
	 */
	void deleteUserRoleRelations(List<UserRoleRelationVO> userRoleRelation);

	/**
	 * 查询当前用户角色
	 * 
	 * @param userRoleRelation
	 * @return
	 */
	UserRoleRelationVO getUserRoleRelationsByUR(@Param("userRoleRelation") UserRoleRelationVO userRoleRelation);

	/**
	 * 查询用户的角色
	 * 
	 * @param userInfo
	 * @return
	 */
	List<RoleVO> getRolesByUser(@Param("userInfo") UserInfoVO userInfo);
}
