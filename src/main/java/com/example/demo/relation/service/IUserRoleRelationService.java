package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.vo.UserRoleRelationVO;

public interface IUserRoleRelationService {

	/**
	 * 批量创建用户角色
	 * 
	 * @param request
	 * @param userRoleRelation
	 */

	CommonResultVO<?> createUserRoleRelations(HttpServletRequest request, List<UserRoleRelationVO> userRoleRelation);

	/**
	 * 批量删除用户角色
	 * 
	 * @param request
	 * @param userRoleRelation
	 */
	CommonResultVO<?> deleteUserRoleRelations(HttpServletRequest request, List<UserRoleRelationVO> userRoleRelation);
	/**
	 * 查询用户的角色
	 * 
	 * @param request
	 * @param userInfo
	 * @return
	 */
	CommonResultVO<?> getRolesByUser(HttpServletRequest request, UserInfoVO userInfo);
}
