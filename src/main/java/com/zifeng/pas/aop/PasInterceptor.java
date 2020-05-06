package com.zifeng.pas.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zifeng.pas.entity.PasPara;
import com.zifeng.pas.service.PasParaService;
import com.zifeng.pas.util.ThreadUtils;

import reactor.util.annotation.Nullable;

/*
 * ① 不依赖Spring容器, 可以使用 Spring容器管理的Bean
 * ② 拦截器通过动态代理进行
 * ③ 拦截器应用场景, 性能分析, 权限检查, 日志记录
 */

public class PasInterceptor implements HandlerInterceptor {
	@Autowired
	private PasParaService initParaService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		PasPara pasPara = initParaService.get();
		// 平台参数置入threadlocal供后续使用
		ThreadUtils.setHolder("para", pasPara);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		//threadlocal清理
		ThreadUtils.remove();
		System.out.println("afterCompletion");
	}
}