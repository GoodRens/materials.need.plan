package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;

@RestController
@Api(tags = "用户操作")
@RequestMapping("/web/client/user")
public class UserInfoController {

	@Autowired
	private IUserInfoService service;

	@ApiOperation(value = "用户登录校验", notes = "根据用户电话号码查询用户是否已经注册")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getUser(@RequestBody UserInfoVO userInfo) {
		return service.getUser(userInfo);
	}

	@ApiOperation(value = "用户注册", notes = "用户注册")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void insertUser(@RequestBody UserInfoVO userInfo) {
		service.insertUser(userInfo);
	}
}
