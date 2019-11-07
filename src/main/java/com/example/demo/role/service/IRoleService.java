package com.example.demo.role.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.role.vo.RoleVO;

public interface IRoleService {

	/**
	 * 创建角色
	 * 
	 * @param request
	 * @param roleList
	 * @return
	 */
	CommonResultVo<?> createRoles(HttpServletRequest request, List<RoleVO> roleList);

	/**
	 * 获取所有的角色
	 * 
	 * @param request
	 * @return
	 */
	CommonResultVo<?> getAllRoles(HttpServletRequest request);

	/**
	 * 删除角色
	 * 
	 * @param request
	 * @param roleIds
	 * @return
	 */
	CommonResultVo<?> deleteRoles(HttpServletRequest request, List<Integer> roleIds);

}
