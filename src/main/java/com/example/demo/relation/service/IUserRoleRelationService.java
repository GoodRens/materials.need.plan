package com.example.demo.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.vo.UserRoleRelationVO;

public interface IUserRoleRelationService {

	/**
	 * 批量创建用户角色
	 * 
	 * @param request
	 * @param userRoleRelation
	 */

	CommonResultVo<?> createUserRoleRelations(HttpServletRequest request, List<UserRoleRelationVO> userRoleRelation);

	/**
	 * 批量删除用户角色
	 * 
	 * @param request
	 * @param userRoleRelation
	 */
	CommonResultVo<?> deleteUserRoleRelations(HttpServletRequest request, List<UserRoleRelationVO> userRoleRelation);
}
