package com.example.demo.relation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.CommonService;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.dao.IDepartmentUserRelationDao;
import com.example.demo.relation.service.IDepartmentUserRelationService;
import com.example.demo.relation.vo.DepartmentUserRelationVO;
import com.mysql.cj.util.StringUtils;

@Service
public class DepartmentUserRelationService implements IDepartmentUserRelationService {

	@Autowired
	private IDepartmentUserRelationDao departmentUserRelationDao;

	@Override
	public CommonResultVO<?> createDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList) {
		CommonResultVO<DepartmentUserRelationVO> result = new CommonResultVO<DepartmentUserRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		boolean isExist = false;
		// 去掉已经存在用户角色
		for (int i = 0; i < departmentUserRelationList.size(); i++) {
			DepartmentUserRelationVO dur = departmentUserRelationDao
					.getDepartmentUserRelationByUR(departmentUserRelationList.get(i));
			if (dur.getDepartmentId() != 0 && dur.getUserId() != 0) {
				departmentUserRelationList.remove(i);
				isExist = true;
			}
		}
		if (departmentUserRelationList.isEmpty()) {
			result.setCode(400);
			result.setMsg("用户已属于以上部门！");
			return result;
		}
		// 添加创建人
		CommonService.addCreateByToParamList(request, departmentUserRelationList);
		departmentUserRelationDao.createDepartmentUserRelations(departmentUserRelationList);
		if (isExist) {
			result.setMsg("部分部门已经存在，部分部门用户添加成功！");
		} else {
			result.setMsg("添加成功！");
		}
		result.setCode(200);
		result.setResultList(departmentUserRelationList);
		return result;
	}

	@Override
	public CommonResultVO<?> deleteDepartmentUserRelations(HttpServletRequest request,
			List<DepartmentUserRelationVO> departmentUserRelationList) {
		CommonResultVO<DepartmentUserRelationVO> result = new CommonResultVO<DepartmentUserRelationVO>();
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

	@Override
	public CommonResultVO<?> getDepartmentByUser(HttpServletRequest request, UserInfoVO userInfo) {
		CommonResultVO<DepartmentVO> result = new CommonResultVO<DepartmentVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (userInfo.getId() == 0) {
			result.setCode(400);
			result.setMsg("用户id为空！");
			return result;
		}
		List<DepartmentVO> departments = departmentUserRelationDao.getDepartmentByUser(userInfo);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(departments);
		return result;
	}

}
