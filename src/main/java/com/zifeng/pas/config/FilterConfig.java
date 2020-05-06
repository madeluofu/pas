package com.zifeng.pas.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zifeng.pas.aop.PasFilter1;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<PasFilter1> registrationBean() {
		FilterRegistrationBean<PasFilter1> filterRegistrationBean = new FilterRegistrationBean<PasFilter1>(new PasFilter1());
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
