package com.xy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//@Configuration

/**
 * 千万切记，继承WebMvcConfigurationSupport 我替换掉我们的mvc其他默认配置 ，如果想要让
 * WebMvcConfigurationSupport配置失效，就在启动类中添加注解@conditionalOnMissingBean({WebMvcConfigurationSupport.Class})
 * 另一种方法就是实现WebMvcConfigurer接口来配置拦截器，作为拦截器的配置类
 */
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
/*
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/check/**").excludePathPatterns("/images/**");


        super.addInterceptors(registry);
    }*/

}
