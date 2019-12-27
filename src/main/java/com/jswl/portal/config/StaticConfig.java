package com.jswl.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jswl.portal.handler.MyHandler;



@Configuration
public class StaticConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private MyHandler myHandler;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/admin/upload/**").addResourceLocations("file:D:/images/");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myHandler)//
		//拦截的路径
		.addPathPatterns("/admin/**")//
		//排除的路径
		.excludePathPatterns("/admin/login","/admin/doLogin");
	}


}
