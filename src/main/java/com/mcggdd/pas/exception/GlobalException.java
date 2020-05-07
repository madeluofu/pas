package com.zifeng.pas.exception;

/**
 * <p>@filename GlobalException</p>
 * <p>
 * <p>@description 全局异常信息</p>
 **/
public class GlobalException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3807488895330525876L;
	private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }
}
