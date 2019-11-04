package com.example.demo.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.vo.UserInfoVO;

@Mapper
public interface IUserInfoDao {

	/**
	 * 用户名是否存在
	 * 
	 * @return
	 */
	public int userNameIsExist(@Param("userName") String userName);

	/**
	 * 用户注册
	 * 
	 * @param userInfo
	 */
	public void insertUser(UserInfoVO userInfo);

	/**
	 * 查询用户名密码
	 * 
	 * @param userInfo
	 * @return
	 */
	public UserInfoVO getUser(@Param("user") UserInfoVO userInfo);

	/**
	 * 查询所有用户
	 */
	public List<UserInfoVO> getAllUsers();

}
