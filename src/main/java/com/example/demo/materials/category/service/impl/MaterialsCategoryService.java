package com.example.demo.materials.category.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.CommonService;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.category.dao.IMaterialsCategoryDao;
import com.example.demo.materials.category.service.IMaterialsCategoryService;
import com.example.demo.materials.category.vo.MaterialsCategoryVO;
import com.mysql.cj.util.StringUtils;

@Service
public class MaterialsCategoryService implements IMaterialsCategoryService {

	@Autowired
	private IMaterialsCategoryDao materialsCategoryDao;

	@Override
	public CommonResultVO<?> addOrUpdateWlCategory(HttpServletRequest request,
			List<MaterialsCategoryVO> materialsCategoryList) {
		CommonResultVO<MaterialsCategoryVO> result = new CommonResultVO<MaterialsCategoryVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsCategoryList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		// 添加创建人
		CommonService.addCreateByToParamList(request, materialsCategoryList);
		materialsCategoryDao.addOrUpdateWlCategory(materialsCategoryList);
		result.setCode(200);
		result.setMsg("添加成功！");
		return result;
	}

	@Override
	public CommonResultVO<?> deleteWlCategory(HttpServletRequest request,
			List<MaterialsCategoryVO> materialsCategoryList) {
		CommonResultVO<MaterialsCategoryVO> result = new CommonResultVO<MaterialsCategoryVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		for (int i = 0; i < materialsCategoryList.size(); i++) {
			if (materialsCategoryList.get(i).getId() == 0) {
				materialsCategoryList.remove(i);
			}
		}
		if (materialsCategoryList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		materialsCategoryDao.deleteWlCategory(materialsCategoryList);
		result.setCode(200);
		result.setMsg("删除成功！");
		return result;
	}

	@Override
	public CommonResultVO<?> queryWlCategory(HttpServletRequest request, MaterialsCategoryVO materialsCategory) {
		CommonResultVO<MaterialsCategoryVO> result = new CommonResultVO<MaterialsCategoryVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<MaterialsCategoryVO> materialsCategoryList = materialsCategoryDao.queryWlCategory(materialsCategory);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(materialsCategoryList);
		return result;
	}

}
