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

}
