package com.example.demo.login.service;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.vo.UserInfoVO;

public interface IUserInfoService {

	/**
	 * 用户登录 查询用户名/密码验证
	 * 
	 * @param userInfo
	 * @return
	 */
	public CommonResultVo<UserInfoVO> getUser(UserInfoVO userInfo);

	/**
	 * 用户注册
	 * 
	 * @param userInfo
	 * @return
	 */
	public CommonResultVo<?> insertUser(UserInfoVO userInfo);

	/**
	 * 查询所有用户
	 * 
	 * @param response
	 * @return
	 */
	public CommonResultVo<?> getAllUsers(HttpServletRequest request);
}
