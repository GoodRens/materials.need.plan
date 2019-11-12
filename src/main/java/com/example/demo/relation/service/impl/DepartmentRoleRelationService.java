package com.example.demo.relation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.relation.dao.IDepartmentRoleRelationDao;
import com.example.demo.relation.service.IDepartmentRoleRelationService;
import com.example.demo.relation.vo.DepartmentRoleRelationVO;
import com.example.demo.role.vo.RoleVO;
import com.mysql.cj.util.StringUtils;

@Service
public class DepartmentRoleRelationService implements IDepartmentRoleRelationService {

	@Autowired
	private IDepartmentRoleRelationDao departmentRoleRelationDao;

	@Override
	public CommonResultVO<?> createDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		CommonResultVO<DepartmentRoleRelationVO> result = new CommonResultVO<DepartmentRoleRelationVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		boolean isExist = false;
		// 校验必填数据
		for (int i = 0; i < departmentRoleRelationList.size(); i++) {
			if (departmentRoleRelationList.get(i).getDepartmentId() != 0
					&& departmentRoleRelationList.get(i).getRoleId() != 0) {
				DepartmentRoleRelationVO drr = departmentRoleRelationDao
						.getDepartmentRoleRelationByUR(departmentRoleRelationList.get(i));
				if (drr.getRoleId() != 0 && drr.getDepartmentId() != 0) {
					// 过滤已存在的关系
					departmentRoleRelationList.remove(i);
					isExist = true;
				}
			} else {
				// 过滤不完整数据
				departmentRoleRelationList.remove(i);
			}
		}
		if (departmentRoleRelationList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确或部门角色已存在！");
			return result;
		}
		departmentRoleRelationDao.createDepartmentRoleRelations(departmentRoleRelationList);
		result.setCode(200);
		if (isExist) {
			result.setMsg("部分部门角色添加成功，部分已存在！");
		} else {
			result.setMsg("添加成功！");
		}
		return result;
	}

	@Override
	public CommonResultVO<?> deleteDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList) {

		CommonResultVO<DepartmentRoleRelationVO> result = new CommonResultVO<DepartmentRoleRelationVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 校验必填数据
		for (int i = 0; i < departmentRoleRelationList.size(); i++) {
			if (departmentRoleRelationList.get(i).getDepartmentId() == 0
					&& departmentRoleRelationList.get(i).getRoleId() == 0) {
				departmentRoleRelationList.remove(i);
			}
		}
		departmentRoleRelationDao.deleteDepartmentRoleRelations(departmentRoleRelationList);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(departmentRoleRelationList);
		return result;
	}

	@Override
	public CommonResultVO<?> updateDepartmentRoleRelations(HttpServletRequest request,
			List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultVO<?> getRoleByDepartmentId(HttpServletRequest request, DepartmentVO department) {
		CommonResultVO<RoleVO> result = new CommonResultVO<RoleVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<RoleVO> roles = departmentRoleRelationDao.getRoleByDepartmentId(department);
		return null;
	}

}
