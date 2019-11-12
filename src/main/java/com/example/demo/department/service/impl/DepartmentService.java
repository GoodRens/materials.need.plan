package com.example.demo.department.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.dao.IDepartmentDao;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVO;
import com.mysql.cj.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService implements IDepartmentService {

	@Autowired
	IDepartmentDao departmentDao;

	@Override
	public CommonResultVO<?> getDepartments(HttpServletRequest request, DepartmentVO departmentVo) {
		CommonResultVO<DepartmentVO> result = new CommonResultVO<DepartmentVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 根据部门名称查询
		List<DepartmentVO> departmentList = departmentDao.getDepartments(departmentVo);
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
	public CommonResultVO<?> createDepartments(HttpServletRequest request, List<DepartmentVO> departmentVos) {
		log.info("插入部门信息" + JSONObject.toJSONString(departmentVos));
		CommonResultVO<DepartmentVO> result = new CommonResultVO<DepartmentVO>();
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
			if (StringUtils.isNullOrEmpty(departmentVos.get(i).getDepartmentName())) {
				result.setCode(400);
				result.setMsg("添加部门失败，部门名称为空！");
				result.setResultList(departmentVos);
				return result;
			}
		}
		String resultStr = "";
		List<DepartmentVO> departments = departmentDao.getDepartmentsByNames(departmentVos);
		if (departments.isEmpty()) {
			// 空
		} else {
			for (int i = 0; i < departmentVos.size(); i++) {
				for (int j = 0; j < departments.size(); j++) {
					if (departments.get(j).getDepartmentName().equals(departmentVos.get(i).getDepartmentName())) {
						resultStr += "角色名称：" + departmentVos.get(i).getDepartmentName() + "已存在，添加失败；";
						departmentVos.remove(i);
					}
				}
			}
		}
		if (departmentVos.isEmpty()) {
			result.setCode(400);
			result.setMsg("部门名称为空或部门角色名称已存在！");
			return result;
		}
		departmentDao.createDepartments(departmentVos);
		if (StringUtils.isNullOrEmpty(resultStr)) {
			result.setMsg("新增成功！");
		} else {
			result.setMsg("部分角色新增成功！");
			result.setResult(resultStr);
		}
		result.setCode(200);
		result.setResultList(departmentVos);
		return result;
	}

	@Override
	public CommonResultVO<?> deleteDepartments(HttpServletRequest request, List<Integer> departmentIds) {
		CommonResultVO<Integer> result = new CommonResultVO<Integer>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		deleteDepartmentsOfRecursion(departmentIds);
		result.setCode(200);
		result.setMsg("删除部门及其子部门成功！");
		result.setResultList(departmentIds);
		return result;
	}

	/**
	 * 递归删除部门及其子部门
	 * 
	 * @param idList
	 * @return
	 */
	public void deleteDepartmentsOfRecursion(List<Integer> idList) {
		if(idList.isEmpty()) {
			return;
		}
		// 删除父部门
		departmentDao.deleteDepartments(idList);
		// 查询子部门id
		List<Integer> childenIdList = departmentDao.getDepartmentIdsById(idList);
		if (!childenIdList.isEmpty()) {
			deleteDepartmentsOfRecursion(childenIdList);
		}
	}

}
