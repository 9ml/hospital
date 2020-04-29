package com.litbo.hospitalzj.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String pathInfo = request.getPathInfo();
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        System.out.println("pathInfo :" + pathInfo);
        System.out.println("requestURL : "+ requestURL);
        System.out.println("requestURI : "+ requestURI);
        System.out.println("servletPath : " + servletPath);


        if (true) {
            System.out.println("已经进行拦截了。。。。。。。。");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }


}
