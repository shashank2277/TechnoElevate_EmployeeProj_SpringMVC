package org.te.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookiesController {
	
	@GetMapping("/cookiesPage")
	public String getCookies() {
		return "cookiesPage";
	}
	
	@GetMapping("/createCookies")
	public String name(HttpServletResponse response,ModelMap map) {
		Cookie cookie = new Cookie("EmpName","sai");
		response.addCookie(cookie);
		map.addAttribute("msg", "created Cookies");
		return "cookiesPage";
	}
	@GetMapping("/showCookies")
	public String getName(@CookieValue(name ="EmpName",required = false)String name,ModelMap map) {
		map.addAttribute("cookie", name);
		return "cookiesPage";
	}
	

}
