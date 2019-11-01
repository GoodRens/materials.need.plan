package com.example.demo.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.dao.IUserInfoDao;
import com.example.demo.login.service.IUserInfoService;
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
		result.setResultVo(userInfo);
		// 查询用户是否存在
		int count = userInfoDao.userNameIsExist(userInfo.getName());
		if (count <= 0) {
			result.setCode(400);
			result.setMsg("用户名不存在！");
			return result;
		}
		UserInfoVO resultUser = userInfoDao.getUser(userInfo);
		if(resultUser.getPassWord().equals(userInfo.getPassWord())) {
			result.setCode(200);
			result.setMsg("验证通过！");
			return result;
		}else {
			result.setCode(400);
			result.setMsg("密码错误！");
			return result;
		}
	}

	@Override
	public CommonResultVo<?> insertUser(UserInfoVO userInfo) {
		CommonResultVo<UserInfoVO> result = new CommonResultVo<UserInfoVO>();
		result.setResultVo(userInfo);
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

}
