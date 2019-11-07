package com.example.demo.common.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户上下文工具
 * 
 * @author MaLongGui
 *
 */
public class UserRequestContext {

	/**
	 * 获取当前登录用户id
	 * 
	 * @param request
	 * @return
	 */
	public static String getCurrentUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
