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
		unitDao.AddOrUpdateunit(unitList);
		return null;
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
		unitDao.Deleteunit(unitList);
		return null;
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
		return null;
	}

}
