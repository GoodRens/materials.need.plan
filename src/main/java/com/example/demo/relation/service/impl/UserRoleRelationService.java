package com.example.demo.relation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.dao.IUserRoleRelationDao;
import com.example.demo.relation.service.IUserRoleRelationService;
import com.example.demo.relation.vo.UserRoleRelationVO;
import com.example.demo.role.vo.RoleVO;
import com.mysql.cj.util.StringUtils;

@Service
public class UserRoleRelationService implements IUserRoleRelationService {

	@Autowired
	private IUserRoleRelationDao userRoleRelationDao;

	@Override
	public CommonResultVO<?> createUserRoleRelations(HttpServletRequest request,
			List<UserRoleRelationVO> userRoleRelation) {
		CommonResultVO<UserRoleRelationVO> result = new CommonResultVO<UserRoleRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		boolean isExist = false;
		// 去掉已经存在用户角色
		for (int i = 0; i < userRoleRelation.size(); i++) {
			UserRoleRelationVO urr = userRoleRelationDao.getUserRoleRelationsByUR(userRoleRelation.get(i));
			if (urr.getRoleId() != 0 && urr.getUserId() != 0) {
				userRoleRelation.remove(i);
				isExist = true;
			}
		}
		if (userRoleRelation.isEmpty()) {
			result.setCode(400);
			result.setMsg("用户已拥有以上角色！");
			return result;
		}
		userRoleRelationDao.createUserRoleRelations(userRoleRelation);
		result.setCode(200);
		if (isExist) {
			result.setMsg("部分角色已经存在，部分用户角色添加成功！");
		} else {
			result.setMsg("添加成功！");
		}

		result.setResultList(userRoleRelation);
		return result;
	}

	@Override
	public CommonResultVO<?> deleteUserRoleRelations(HttpServletRequest request,
			List<UserRoleRelationVO> userRoleRelation) {
		CommonResultVO<UserRoleRelationVO> result = new CommonResultVO<UserRoleRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}

		for (int i = 0; i < userRoleRelation.size(); i++) {
			if (userRoleRelation.get(i).getRoleId() == 0 || userRoleRelation.get(i).getUserId() == 0) {
				userRoleRelation.remove(i);
			}
		}
		// 校验数据
		if (userRoleRelation.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确或关键字段缺失！");
			return result;
		}
		userRoleRelationDao.deleteUserRoleRelations(userRoleRelation);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(userRoleRelation);
		return result;
	}

	@Override
	public CommonResultVO<?> getRolesByUser(HttpServletRequest request, UserInfoVO userInfo) {
		CommonResultVO<RoleVO> result = new CommonResultVO<RoleVO>();
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

		List<RoleVO> list = userRoleRelationDao.getRolesByUser(userInfo);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(list);
		return result;
	}

}
