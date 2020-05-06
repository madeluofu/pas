package com.zifeng.pas.exception;

import lombok.Data;

/**
 * <p>
 * @filename CodeMsg
 * </p>
 * <p>
 * <p>
 * @description 通用状态码和消息封装
 * </p>
 **/
@Data
public class CodeMsg {
	// 自定义状态码
	private int code;
	// 消息信息
	private String msg;
	// 通用异常 4001XX
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");

	// 模块1 4002XX
	// 模块2 4003XX
	// 模块3 4004XX
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}
}