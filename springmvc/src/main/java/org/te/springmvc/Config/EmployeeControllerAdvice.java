package org.te.springmvc.Config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.te.springmvc.customexception.EmployeeExp;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeExp.class)
	public String handleExp(EmployeeExp exp, HttpServletRequest request) {
		request.setAttribute("err", exp.getMessage());
		return "errPage";
	}
}
