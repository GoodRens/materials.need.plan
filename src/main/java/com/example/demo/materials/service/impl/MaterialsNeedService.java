package com.example.demo.materials.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.materials.dao.IMaterialsNeedDao;
import com.example.demo.materials.service.IMaterialsNeedService;
import com.example.demo.materials.vo.MaterialsNeedVO;
import com.mysql.cj.util.StringUtils;

@Service
public class MaterialsNeedService implements IMaterialsNeedService {

	@Autowired
	IMaterialsNeedDao materialsNeedDao;

	@Override
	public CommonResultVo<?> createMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		CommonResultVo<MaterialsNeedVO> result = new CommonResultVo<MaterialsNeedVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsNeedList.isEmpty()) {
			result.setCode(400);
			result.setMsg("传入的数据为空或格式不正确！");
			return result;
		}
		materialsNeedDao.createMaterialNeeds(materialsNeedList);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(materialsNeedList);
		return result;
	}

	@Override
	public CommonResultVo<?> deleteMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		CommonResultVo<MaterialsNeedVO> result = new CommonResultVo<MaterialsNeedVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsNeedList.isEmpty()) {
			result.setCode(400);
			result.setMsg("传入的数据为空！");
			return result;
		}
		for (int i = 0; i < materialsNeedList.size(); i++) {
			if (materialsNeedList.get(i).getId() == 0) {
				materialsNeedList.remove(i);
			}
		}
		if (materialsNeedList.isEmpty()) {
			result.setCode(400);
			result.setMsg("传入的数据格式不正确！");
			return result;
		}
		materialsNeedDao.deleteMaterialNeeds(materialsNeedList);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(materialsNeedList);
		return result;
	}

	@Override
	public CommonResultVo<?> updateMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		CommonResultVo<MaterialsNeedVO> result = new CommonResultVo<MaterialsNeedVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsNeedList.isEmpty()) {
			result.setCode(400);
			result.setMsg("传入的数据为空！");
			return result;
		}
		for (int i = 0; i < materialsNeedList.size(); i++) {
			if (materialsNeedList.get(i).getId() == 0) {
				materialsNeedList.remove(i);
			}
		}
		if (materialsNeedList.isEmpty()) {
			result.setCode(400);
			result.setMsg("传入的数据格式不正确！");
			return result;
		}
		materialsNeedDao.updateMaterialNeeds(materialsNeedList);
		result.setCode(200);
		result.setMsg("更新成功！");
		result.setResultList(materialsNeedList);
		return result;
	}

}
