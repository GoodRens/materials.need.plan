package com.example.demo.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "User Info Controller")
@RequestMapping("/mnp/user")
@CrossOrigin
public class UserInfoController {

	// cookie变量用来装我们的cookies信息
	private static Cookie cookie;

	@Autowired
	private IUserInfoService service;

	@ApiOperation(value = "用户登录校验", notes = "根据用户用户名检验")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResultVo<?> getUser(HttpServletResponse response, @RequestBody UserInfoVO userInfo) {
		CommonResultVo<UserInfoVO> result = service.getUser(userInfo);
		if (result.getCode() == 200) {
			cookie = new Cookie("userId", result.getResultList().get(0).getId() + "");
			response.addCookie(cookie);
		}
		return result;
	}

	@ApiOperation(value = "用户注销", notes = "根据用户ID")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public CommonResultVo<?> logoutUser(HttpServletResponse response, @RequestBody UserInfoVO userInfo) {
		CommonResultVo<?> result = new CommonResultVo<UserInfoVO>();
		result.setCode(200);
		result.setMsg("注销成功！");
		cookie = new Cookie("userId", null);
		response.addCookie(cookie);
		return result;
	}

	@ApiOperation(value = "用户注册", notes = "用户名和密码必填")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public CommonResultVo<?> insertUser(@RequestBody UserInfoVO userInfo) {
		return service.insertUser(userInfo);
	}

}
