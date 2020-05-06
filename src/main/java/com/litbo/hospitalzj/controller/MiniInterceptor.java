package com.litbo.hospitalzj.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MiniInterceptor implements HandlerInterceptor {

	/**
	 * 拦截请求，在controller调用之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object arg2) throws Exception {


//		System.out.println("------------------"+request.getServletPath()+":"+path+"--------------------------------------");

		Object uid = request.getSession().getAttribute("uid");
		Object suId = request.getSession().getAttribute("suId");
		if (uid == null && suId == null){
			response.sendRedirect("/login.html");
			return false;
		}
		return true;




	/**
	 * 返回 false：请求被拦截，返回
	 * 返回 true ：请求OK，可以继续执行，放行
	 */


	}

	
	/**
	 * 请求controller之后，渲染视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	
	/**
	 * 请求controller之后，视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
