package com.example.demo.relation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.dao.IUserRoleRelationDao;
import com.example.demo.relation.service.IUserRoleRelationService;
import com.example.demo.relation.vo.UserRoleRelationVO;
import com.mysql.cj.util.StringUtils;

@Service
public class UserRoleRelationService implements IUserRoleRelationService {

	@Autowired
	private IUserRoleRelationDao userRoleRelationDao;

	@Override
	public CommonResultVo<?> createUserRoleRelations(HttpServletRequest request,
			List<UserRoleRelationVO> userRoleRelation) {
		CommonResultVo<UserRoleRelationVO> result = new CommonResultVo<UserRoleRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		userRoleRelationDao.createUserRoleRelations(userRoleRelation);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(userRoleRelation);
		return result;
	}

	@Override
	public CommonResultVo<?> deleteUserRoleRelations(HttpServletRequest request,
			List<UserRoleRelationVO> userRoleRelation) {
		CommonResultVo<UserRoleRelationVO> result = new CommonResultVo<UserRoleRelationVO>();
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

}
