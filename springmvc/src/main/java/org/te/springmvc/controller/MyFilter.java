package org.te.springmvc.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 =(HttpServletRequest) request; 
		System.out.println("inside do filter");
		System.out.println("url    :"+request2.getRequestURL());
		System.out.println("Uri    :"+request2.getRequestURI());
		System.out.println("Method :"+request2.getMethod());
		chain.doFilter(request2, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
