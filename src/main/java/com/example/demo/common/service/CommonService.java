package com.example.demo.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonBaseVO;

public class CommonService {
	/**
	 * 为参数设置createBy--单VO
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static void addCreateByToParam(HttpServletRequest request, CommonBaseVO commonBaseVO) {
		commonBaseVO.setCreaterBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
	}

	/**
	 * 为参数设置createBy--List
	 * 
	 * @param request
	 * @param commonBaseVOList
	 */
	public static void addCreateByToParamList(HttpServletRequest request, List<CommonBaseVO> commonBaseVOList) {
		for (CommonBaseVO commonBaseVO : commonBaseVOList) {
			commonBaseVO.setCreaterBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
		}
	}

	/**
	 * 为参数设置lastUpdateBy--单VO
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static void addLastUpdateByToParam(HttpServletRequest request, CommonBaseVO commonBaseVO) {
		commonBaseVO.setLastUpdateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
	}

	/**
	 * 为参数设置lastUpdateBy--List
	 * 
	 * @param request
	 * @param commonBaseVO
	 */
	public static void addLastUpdateByToParamList(HttpServletRequest request, List<CommonBaseVO> commonBaseVOList) {
		for (CommonBaseVO commonBaseVO : commonBaseVOList) {
			commonBaseVO.setLastUpdateBy(Integer.parseInt(UserRequestContext.getCurrentUser(request)));
		}
	}
}
