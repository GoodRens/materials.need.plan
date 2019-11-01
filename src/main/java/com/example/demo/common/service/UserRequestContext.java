package com.example.demo.common.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserRequestContext {
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
