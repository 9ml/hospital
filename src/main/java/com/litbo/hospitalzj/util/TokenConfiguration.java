package com.litbo.hospitalzj.util;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TokenConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new VerifyTokenInterceptor()).addPathPatterns("/business/*");
    }
}