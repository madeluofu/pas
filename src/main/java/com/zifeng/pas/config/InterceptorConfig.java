package com.zifeng.pas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zifeng.pas.aop.PasInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	/**
	 * 将自定义拦截器作为Bean写入配置
	 * 
	 * @return
	 */
	@Bean
	public PasInterceptor pasInterceptor() {
		return new PasInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 多个拦截器组成一个拦截器链 
		 * addPathPatterns 用于添加拦截规则 
		 * excludePathPatterns 用户排除拦截
		 */
		registry.addInterceptor(pasInterceptor()).addPathPatterns("/**");
	}
}
