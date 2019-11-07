package com.example.demo.role.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.vo.UserInfoVO;
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
		String resultStr = "";
		// 角色名称重复校验
		List<RoleVO> roleListByNames = roleDao.getAllRolesByNames(roleList);
		if (roleListByNames.isEmpty()) {
			// 空
		} else {
			for (int i = 0; i < roleList.size(); i++) {
				for (int j = 0; j < roleListByNames.size(); j++) {
					if (roleListByNames.get(j).getRoleName().equals(roleList.get(i).getRoleName())) {
						resultStr += "角色名称：" + roleList.get(i).getRoleName() + "已存在，添加失败；";
						roleList.remove(i);
					}
				}
			}
		}
		if (roleList.isEmpty()) {
			result.setCode(400);
			result.setMsg("角色名称为空或角色名称已存在！");
			return result;
		}
		roleDao.createRoles(roleList);
		result.setCode(200);
		if (StringUtils.isNullOrEmpty(resultStr)) {
			result.setMsg("新增成功！");
		} else {
			result.setMsg("部分角色新增成功！");
			result.setResult(resultStr);
		}
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

	@Override
	public CommonResultVo<?> getRolesByUser(HttpServletRequest request, UserInfoVO userInfo) {
		CommonResultVo<RoleVO> result = new CommonResultVo<RoleVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (userInfo.getId() == 0) {
			result.setCode(400);
			result.setMsg("请传入正确的userId！");
			return result;
		}
		
		List<RoleVO> list = roleDao.getRolesByUser(userInfo);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(list);
		return result;
	}

}
