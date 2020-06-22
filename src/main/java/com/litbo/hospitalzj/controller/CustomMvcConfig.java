package com.litbo.hospitalzj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomMvcConfig implements WebMvcConfigurer {

    //注册拦截器2
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         /*addPathPatterns 用于添加拦截规则
         excludePathPatterns 用户排除拦截*/
        registry.addInterceptor(new MiniInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/userlogin.html","/qylx/**","/jglx/all","/zzinfo/insert",
                        "/suinfo/forget","/suinfo/updatePassword",
                        "/suinfo/login","/suinfo/insert","/user/login","/wjsc/**"
                       ,"/static/**","/supplier/**","/static_fileimages/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static_fileimages/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/static_fileimages/");

    }




}
