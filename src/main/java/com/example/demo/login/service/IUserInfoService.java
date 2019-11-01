package com.example.demo.login.service;

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

}
