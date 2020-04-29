package com.litbo.hospitalzj.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class CustomMvcConfig extends WebMvcConfigurerAdapter {

    //注册拦截器2
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         /*addPathPatterns 用于添加拦截规则
         excludePathPatterns 用户排除拦截*/
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/", "/userlogin.html", "/static/**",
                        "/suinfo/login");
    }



}
