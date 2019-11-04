package com.example.demo.department.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.department.dao.IDepartmentDao;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVo;
import com.mysql.cj.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService implements IDepartmentService {

	@Autowired
	IDepartmentDao userInfoDao;

	@Override
	public CommonResultVo<?> getDepartments(HttpServletRequest request, DepartmentVo departmentVo) {
		CommonResultVo<DepartmentVo> result = new CommonResultVo<DepartmentVo>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 根据部门名称查询
		List<DepartmentVo> departmentList = userInfoDao.getDepartments(departmentVo);
		if (departmentList.isEmpty()) {
			result.setCode(400);
			result.setMsg("无部门信息，请添加！");
			return result;
		}
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(departmentList);
		return result;
	}

	@Override
	public CommonResultVo<?> createDepartments(HttpServletRequest request, List<DepartmentVo> departmentVos) {
		log.info("插入部门信息" + JSONObject.toJSONString(departmentVos));
		CommonResultVo<DepartmentVo> result = new CommonResultVo<DepartmentVo>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 校验数据
		if (departmentVos.isEmpty()) {
			result.setCode(400);
			result.setMsg("添加部门失败，信息为空！");
			return result;
		}
		for (int i = 0; i < departmentVos.size(); i++) {
			if (StringUtils.isNullOrEmpty(departmentVos.get(i).getDepartmentName())
					|| StringUtils.isNullOrEmpty(departmentVos.get(i).getDepartmentLevel())) {
				result.setCode(400);
				result.setMsg("添加部门失败，部门名称或和部门层级为空！");
				result.setResultList(departmentVos);
				return result;
			}
		}
		userInfoDao.createDepartments(departmentVos);
		result.setCode(200);
		result.setMsg("添加部门成功！");
		result.setResultList(departmentVos);
		return result;
	}

	@Override
	public CommonResultVo<?> deleteDepartments(HttpServletRequest request, List<Integer> departmentIds) {
		CommonResultVo<Integer> result = new CommonResultVo<Integer>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		userInfoDao.deleteDepartments(departmentIds);
		result.setCode(200);
		result.setMsg("删除部门成功！");
		result.setResultList(departmentIds);
		return result;
	}

}
