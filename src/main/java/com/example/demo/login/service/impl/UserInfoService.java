package com.example.demo.login.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.dao.IUserInfoDao;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoService implements IUserInfoService {

	// 使用log4j
	private Logger logger = Logger.getLogger(UserInfoService.class);

	@Autowired
	IUserInfoDao userInfoDao;

	@Override
	public String getUser(UserInfoVO userInfo) {

		return null;
	}

	@Override
	public void insertUser(UserInfoVO userInfo) {
		userInfoDao.insertUser(userInfo);
	}

}
