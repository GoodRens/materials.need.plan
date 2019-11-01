package com.example.demo.login.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.dao.IUserInfoDao;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.DepartmentVo;
import com.example.demo.login.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoService implements IUserInfoService {

	@Autowired
	IUserInfoDao userInfoDao;

	@Override
	public CommonResultVo<?> getUser(UserInfoVO userInfo) {
		CommonResultVo<UserInfoVO> result = new CommonResultVo<UserInfoVO>();
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		list.add(userInfo);
		result.setResultList(list);
		// 查询用户是否存在
		int count = userInfoDao.userNameIsExist(userInfo.getName());
		if (count <= 0) {
			result.setCode(400);
			result.setMsg("用户名不存在！");
			return result;
		}
		UserInfoVO resultUser = userInfoDao.getUser(userInfo);
		if (resultUser.getPassWord().equals(userInfo.getPassWord())) {
			// 用数据库的用户信息返回
			list.clear();
			list.add(resultUser);
			result.setResultList(list);
			result.setCode(200);
			result.setMsg("验证通过！");
			return result;
		} else {
			result.setCode(400);
			result.setMsg("密码错误！");
			return result;
		}
	}

	@Override
	public CommonResultVo<?> insertUser(UserInfoVO userInfo) {
		CommonResultVo<UserInfoVO> result = new CommonResultVo<UserInfoVO>();
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		list.add(userInfo);
		result.setResultList(list);
		if ("".equals(userInfo.getName()) || userInfo.getName() == null) {
			result.setCode(400);
			result.setMsg("用户名为空！");
			return result;
		}
		if ("".equals(userInfo.getPassWord()) || userInfo.getPassWord() == null) {
			result.setCode(400);
			result.setMsg("密码为空！");
			return result;
		}
		// 查询用户是否存在
		int count = userInfoDao.userNameIsExist(userInfo.getName());
		if (count > 0) {
			result.setCode(400);
			result.setMsg("用户名已存在！");
			return result;
		}

		userInfoDao.insertUser(userInfo);
		log.info(userInfo.getName() + "注册成功信息：" + JSONObject.toJSONString(userInfo));
		result.setCode(200);
		result.setMsg("注册成功！");
		return result;
	}

	@Override
	public CommonResultVo<?> getDepartments(DepartmentVo departmentVo) {
		CommonResultVo<DepartmentVo> result = new CommonResultVo<DepartmentVo>();
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

	/**
	 * 根据同层级所有部门
	 * 
	 * @param parentId
	 * @return
	 */
	public List<DepartmentVo> getDepartmentSameLevel(int parentId) {
		List<DepartmentVo> list = new ArrayList<DepartmentVo>();
		return list;
	}
}
