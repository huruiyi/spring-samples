package com.ruiyi.cookie.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie findTargetCookie(Cookie[] cookies, String name) {

		if (cookies == null) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}

		return null;
	}

}
