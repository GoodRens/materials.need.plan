package com.example.demo.relation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.relation.dao.IDepartmentUserRelationDao;
import com.example.demo.relation.service.IDepartmentUserRelationService;
import com.example.demo.relation.vo.DepartmentUserRelationVO;
import com.mysql.cj.util.StringUtils;

@Service
public class DepartmentUserRelationService implements IDepartmentUserRelationService {

	@Autowired
	private IDepartmentUserRelationDao departmentUserRelationDao;

	@Override
	public CommonResultVo<?> createDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList) {
		CommonResultVo<DepartmentUserRelationVO> result = new CommonResultVo<DepartmentUserRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		departmentUserRelationDao.createDepartmentUserRelations(departmentUserRelationList);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(departmentUserRelationList);
		return result;
	}

	@Override
	public CommonResultVo<?> deleteDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList) {
		CommonResultVo<DepartmentUserRelationVO> result = new CommonResultVo<DepartmentUserRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 校验userID 和 departmentId ，不存在则剔除
		for (int i = 0; i < departmentUserRelationList.size(); i++) {
			if (departmentUserRelationList.get(i).getDepartmentId() == 0
					|| departmentUserRelationList.get(i).getUserId() == 0) {
				departmentUserRelationList.remove(i);
			}
		}
		// 校验是否还有数据
		if (departmentUserRelationList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确或关键字段缺失！");
			return result;
		}
		departmentUserRelationDao.deleteDepartmentUserRelations(departmentUserRelationList);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(departmentUserRelationList);
		return result;
	}

}
