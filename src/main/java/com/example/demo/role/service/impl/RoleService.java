package com.example.demo.role.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.role.dao.IRoleDao;
import com.example.demo.role.service.IRoleService;
import com.example.demo.role.vo.RoleVO;
import com.mysql.cj.util.StringUtils;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public CommonResultVo<?> createRoles(HttpServletRequest request, List<RoleVO> roleList) {
		CommonResultVo<RoleVO> result = new CommonResultVo<RoleVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		roleDao.createRoles(roleList);
		result.setCode(200);
		result.setMsg("新增成功！");
		result.setResultList(roleList);
		return result;
	}

	@Override
	public CommonResultVo<?> getAllRoles(HttpServletRequest request) {
		CommonResultVo<RoleVO> result = new CommonResultVo<RoleVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<RoleVO> roleList = roleDao.getAllRoles();
		result.setCode(200);
		result.setMsg("获取成功！");
		result.setResultList(roleList);
		return result;
	}

	@Override
	public CommonResultVo<?> deleteRoles(HttpServletRequest request, List<Integer> roleIds) {
		CommonResultVo<Integer> result = new CommonResultVo<Integer>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		roleDao.deleteRoles(roleIds);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(roleIds);
		return result;
	}

}
