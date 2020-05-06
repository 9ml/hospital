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


		String[] paths = request.getServletPath().split("/");
		String path ;
		if(paths.length>=1)
			path = paths[1];
		else path = "/";
		System.out.println("------------------"+request.getServletPath()+":"+path+"--------------------------------------");
		if(path.equals("control")||path.equals("/")){
			if(request.getSession().getAttribute("uid")==null){
				response.sendRedirect("/login.html");
				return false;
			}
			String uid  = request.getSession().getAttribute("uid").toString();
			if(StringUtils.isEmpty(uid)){
				response.sendRedirect("/login.html");
				return false;
			}
		}else {
			if(request.getSession().getAttribute("suId")==null){
				response.sendRedirect("/userlogin.html");
				return false;
			}
			String uid  = request.getSession().getAttribute("suId").toString();
			if(StringUtils.isEmpty(uid)){
				response.sendRedirect("/userlogin.html");
				return false;
			}
		}

		/**
		 * 返回 false：请求被拦截，返回
		 * 返回 true ：请求OK，可以继续执行，放行
		 */
		return true;
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
