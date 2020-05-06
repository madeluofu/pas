package com.zifeng.pas.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * ① 过滤器是在web应用启动的时候初始化一次, 在web应用停止的时候销毁.
 * ② 可以对请求的URL进行过滤, 对敏感词过滤, 
 * ③ 挡在拦截器的外层
 * ④ Filter 是 Servlet规范的一部分
 */

public class PasFilter1 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("I'm filter1");
	};

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// do something 处理request 或response
		System.out.println("filter1");
		// 放行，调用filter链中的下一个filter
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
