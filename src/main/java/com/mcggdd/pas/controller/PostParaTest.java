package com.mcggdd.pas.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//get、post获取请求的参数使用场景
//1 两个接口调用时使用
//2 从页面请求时使用
//
//@RequestBody注解的3个必须
//1 这个注解必须用post方法请求才可以
//2 请求参数必须放在body体里
//3 请求必须配置Content-Type: application/json
//
//@ResponseBody是做序列化处理的
//@RequestBody是做反序列化处理的

@Controller
public class PostParaTest {
	// 在post方法请求中获取参数，返回String类型
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody String getString(@RequestBody String body) {
		return body;
	}

	// post方法请求中获取参数，返回json类型
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody Map getString(@RequestBody Map body) {
		return body;
	}

	// post请求参数为文本类型，用HttpServiceRequest实现
	// 请求参数为文本类型的时候就要通过这种输入流获取参数内容，请求的参数非json格式
	@RequestMapping(value = "/getParam", method = RequestMethod.POST)
	public @ResponseBody Object getParam(HttpServletRequest request) {
		String body = null;
		try {
			/**
			 * 用HttpServletRequest类型的参数属性request获取输入流（读）
			 * 赋值给BufferedReader类型的bufferedReader（缓冲区读取）读取数据 将获取到的转为json
			 **/
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			body = org.apache.commons.io.IOUtils.toString(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	// post请求类型为自定义的实体类
	// 请求的返回类型为自定义的实体类的类型时，实体类的类属性就是请求的参数，并且都是必传
	@RequestMapping(value = "/getParam", method = RequestMethod.POST)
	public @ResponseBody Animal getParam(@RequestBody Animal animal) {
		return animal;
	}

}
