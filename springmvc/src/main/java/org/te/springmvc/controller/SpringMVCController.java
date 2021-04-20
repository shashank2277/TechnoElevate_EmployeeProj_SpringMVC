package org.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.te.springmvc.beans.UserBean;

@Controller
public class SpringMVCController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView getHello() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("hello");
		return andView;
	}

//	@RequestMapping(path = "/search", method = RequestMethod.GET)
//	public ModelAndView getData(ModelAndView modelAndView, HttpServletRequest request) {
//		String name = request.getParameter("name");
////		modelAndView.addObject("username",name);
//		request.setAttribute("username", name);
//		modelAndView.setViewName("newHome");
//		return modelAndView;
//
//	}

	@GetMapping("/login")
	public String getLogin() {
		return "loginForm";
	}

	@PostMapping("/login")
	public String getFormData(HttpServletRequest request, ModelMap modelMap) {
		String name = request.getParameter("user");
		int password = Integer.parseInt(request.getParameter("pwd"));

		modelMap.addAttribute("name", name);
		modelMap.addAttribute("pwd", password);

		return "userDetails";
	}

	@PostMapping("/login1")
	public String name(ModelMap map, int pwd, String user) {
		map.addAttribute("name", user);
		map.addAttribute("pwd", pwd);

		return "userDetails";
	}

	@PostMapping("/login2")
	public String getDataFromBean(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute("name", userBean.getUser());
		modelMap.addAttribute("pwd", userBean.getPwd());

		return "userDetails";
	}

	@PostMapping("/login3")
	public String getFromRequestPara(ModelMap map, @RequestParam(name = "") String user,
			@RequestParam(name = "") int password) {
		map.addAttribute("name", user);
		map.addAttribute("pwd", password);

		return "userDetails";

	}

}
