package com.example.demo.materials.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.CommonService;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.dao.IMaterialsDao;
import com.example.demo.materials.service.IMaterialsService;
import com.example.demo.materials.vo.MaterialsVO;
import com.mysql.cj.util.StringUtils;

@Service
public class MaterialsService implements IMaterialsService {

	@Autowired
	private IMaterialsDao materialsDao;

	@Override
	public CommonResultVO<?> addOrUpdateWl(HttpServletRequest request, List<MaterialsVO> materialsList) {
		CommonResultVO<MaterialsVO> result = new CommonResultVO<MaterialsVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		if (materialsList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		// 添加创建人
		CommonService.addCreateByToParamList(request, materialsList);
		materialsDao.addOrUpdateWl(materialsList);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(materialsList);
		return result;
	}

	@Override
	public CommonResultVO<?> deleteWl(HttpServletRequest request, List<MaterialsVO> materialsList) {
		CommonResultVO<MaterialsVO> result = new CommonResultVO<MaterialsVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		for (int i = 0; i < materialsList.size(); i++) {
			if (materialsList.get(i).getId() == 0) {
				materialsList.remove(i);
			}
		}

		if (materialsList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		materialsDao.deleteWl(materialsList);
		result.setCode(200);
		result.setMsg("删除成功！");
		result.setResultList(materialsList);
		return result;
	}

	@Override
	public CommonResultVO<?> queryWl(HttpServletRequest request, MaterialsVO materials) {
		CommonResultVO<MaterialsVO> result = new CommonResultVO<MaterialsVO>();
		// 登录校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<MaterialsVO> materialss = materialsDao.queryWl(materials);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(materialss);
		return result;
	}

}
