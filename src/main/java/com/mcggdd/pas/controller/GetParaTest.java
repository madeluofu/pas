package com.mcggdd.pas.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class GetParaTest {
	// HttpServletRequest获取客户请求信息、消息头、参数、IP
	// 在方法中获取入参（get方法）
	@RequestMapping(value = "/test", params = { "name", "age" }, method = RequestMethod.GET)
	public @ResponseBody String getString(HttpServletRequest request) {
		// 获取一个参数
		String name = request.getParameter("name");
		// 获取所有参数
		Map map = request.getParameterMap();
		// 获取IP
		String ip = request.getRemoteAddr();
		return name;
	}

	// 将请求参数映射到一个对象上
	// 请求能映射到的原因是实体类Animal 有两个参数name、age，浏览器请求时参数key与属性名一一对应，返回的是json格式
	// Test URL： http://127.0.0.1:8080/test/getParam?name=xx&age=10
	@RequestMapping(value = "/getParam")
	public @ResponseBody Animal getParam(Animal animal) {
		return animal;
	}

	// 注解获取参数get方法
	// 路径映射的参数名要与方法中的参数名一致
	// 路径映射的参数名要与方法中的参数名一致
	@RequestMapping(value = "/test", params = { "name", "age" }, method = RequestMethod.GET)
	public @ResponseBody String getString(@RequestParam String name, @RequestParam Integer age) {
		System.out.println("姓名" + name + "年龄" + age);
		return "姓名" + name + "年龄" + age;
	}

	// get请求在@RequestParam中设置参数
	// 请求参数的表达式只能用“=”或者“！=”不能使用“<”和“>”
	// 请求参数userName用@RequestParam注解设置
	// @RequestParam有3个参数：
	// 1 value：改变该参数在请求时的实际名称，例如这个参数名是userName，用value设置成了name，那么请求时只能用name请求成功，用userName是请求不成功的，这样就不至于将userName暴露在外
	// 2 defaultValue：在该参数是非必填的时候，页面请求时写了该参数，但是没有给值，就会使用defaultValue的值
	// 3 required：设置该参数是否必填，默认为true，设置为false就可以不填写
	@RequestMapping(value = "/test", params = { "userName", "age" }, method = RequestMethod.GET)
	public @ResponseBody String getString(
			@RequestParam(value = "name", defaultValue = "test", required = false) String userName,
			@RequestParam Integer age) {
		return "姓名" + userName + "年龄" + age;
	}
}
