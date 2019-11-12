package com.example.demo.unit.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.unit.dao.IUnitDao;
import com.example.demo.unit.service.IUnitService;
import com.example.demo.unit.vo.UnitVO;
import com.mysql.cj.util.StringUtils;

@Service
public class UnitService implements IUnitService {
	@Autowired
	private IUnitDao unitDao;

	@Override
	public CommonResultVO<?> AddOrUpdateunit(HttpServletRequest request, List<UnitVO> unitList) {
		CommonResultVO<UnitVO> result = new CommonResultVO<UnitVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		for (int i = 0; i < unitList.size(); i++) {
			if (StringUtils.isNullOrEmpty(unitList.get(i).getUnitName())) {
				unitList.remove(i);
			} else {
				List<UnitVO> units = unitDao.Queryunit(unitList.get(i));
				if (!units.isEmpty()) {
					unitList.remove(i);
				}
			}
		}
		if (unitList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		unitDao.AddOrUpdateunit(unitList);
		result.setCode(200);
		result.setMsg("添加成功！");
		return result;
	}

	@Override
	public CommonResultVO<?> Deleteunit(HttpServletRequest request, List<UnitVO> unitList) {
		CommonResultVO<UnitVO> result = new CommonResultVO<UnitVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		for (int i = 0; i < unitList.size(); i++) {
			if (unitList.get(i).getUnitID() == 0) {
				unitList.remove(i);
			}
		}
		if (unitList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		unitDao.Deleteunit(unitList);
		result.setCode(200);
		result.setMsg("删除成功！");
		return result;
	}

	@Override
	public CommonResultVO<?> Queryunit(HttpServletRequest request, UnitVO unit) {
		CommonResultVO<UnitVO> result = new CommonResultVO<UnitVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<UnitVO> units = unitDao.Queryunit(unit);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(units);
		return result;
	}

}
