package com.example.demo.materials.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.dao.IMaterialsPlanDao;
import com.example.demo.materials.service.IMaterialsPlanService;
import com.example.demo.materials.vo.MaterialsPlanVO;
import com.mysql.cj.util.StringUtils;

public class MaterialsPlanService implements IMaterialsPlanService {

	@Autowired
	private IMaterialsPlanDao materialsPlanDao;

	@Override
	public CommonResultVO<?> AddNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsPlanList) {
		CommonResultVO<MaterialsPlanVO> result = new CommonResultVO<MaterialsPlanVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsPlanList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		materialsPlanDao.addNeedPlan(materialsPlanList);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(materialsPlanList);
		return result;
	}

	@Override
	public CommonResultVO<?> DeleteNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsPlanList) {
		CommonResultVO<MaterialsPlanVO> result = new CommonResultVO<MaterialsPlanVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}

		for (int i = 0; i < materialsPlanList.size(); i++) {
			if (materialsPlanList.get(i).getId() == 0) {
				materialsPlanList.remove(i);
			}
		}

		if (materialsPlanList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		materialsPlanDao.deleteNeedPlan(materialsPlanList);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(materialsPlanList);
		return result;
	}

	@Override
	public CommonResultVO<?> QueryNeedPlan(HttpServletRequest request, MaterialsPlanVO materialsPlan) {
		CommonResultVO<MaterialsPlanVO> result = new CommonResultVO<MaterialsPlanVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<MaterialsPlanVO> materialsPlans = materialsPlanDao.queryNeedPlan(materialsPlan);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(materialsPlans);
		return result;
	}
}
