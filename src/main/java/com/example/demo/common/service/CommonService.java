package com.example.demo.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonBaseVO;

public class CommonService {
	/**
	 * 为参数设置createBy--单VO
	 * @param <T>
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static <T> void addCreateByToParam(HttpServletRequest request, T commonBaseVO) {
		((CommonBaseVO) commonBaseVO).setCreateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
	}

	/**
	 * 为参数设置createBy--List
	 * @param <T>
	 * 
	 * @param request
	 * @param commonBaseVOList
	 */
	public static <T> void addCreateByToParamList(HttpServletRequest request, List<T> commonBaseVOList) {
		for (T commonBaseVO : commonBaseVOList) {
			((CommonBaseVO) commonBaseVO).setCreateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
		}
	}

	/**
	 * 为参数设置lastUpdateBy--单VO
	 * @param <T>
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static <T> void addLastUpdateByToParam(HttpServletRequest request, T commonBaseVO) {
		((CommonBaseVO) commonBaseVO).setLastUpdateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
	}

	/**
	 * 为参数设置lastUpdateBy--List
	 * @param <T>
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static <T> void addLastUpdateByToParamList(HttpServletRequest request, List<T> commonBaseVOList) {
		for (T commonBaseVO : commonBaseVOList) {
			((CommonBaseVO) commonBaseVO).setLastUpdateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
		}
	}
}
