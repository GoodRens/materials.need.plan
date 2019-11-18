package com.example.demo.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.login.dao.IUserInfoDao;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;
import com.mysql.cj.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoService implements IUserInfoService {

	@Autowired
	IUserInfoDao userInfoDao;

	@Override
	public CommonResultVO<UserInfoVO> getUser(UserInfoVO userInfo) {
		CommonResultVO<UserInfoVO> result = new CommonResultVO<UserInfoVO>();
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
	public CommonResultVO<?> insertUser(UserInfoVO userInfo) {
		CommonResultVO<UserInfoVO> result = new CommonResultVO<UserInfoVO>();
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
	public CommonResultVO<?> getAllUsers(HttpServletRequest request) {
		CommonResultVO<UserInfoVO> result = new CommonResultVO<UserInfoVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<UserInfoVO> userInfoList = userInfoDao.getAllUsers();
		result.setCode(200);
		result.setMsg("获取成功！");
		result.setResultList(userInfoList);
		return result;
	}

}
