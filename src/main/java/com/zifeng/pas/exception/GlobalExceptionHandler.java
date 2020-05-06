package com.zifeng.pas.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 定义要捕获的异常 可以多个 @ExceptionHandler({})
	 *
	 * @param request  request
	 * @param e        exception
	 * @param response response
	 * @return 响应结果
	 */
	@ExceptionHandler(CustomException.class)
	public ErrorResponseEntity customExceptionHandler(HttpServletRequest request, final Exception e,
			HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());

		CustomException exception = (CustomException) e;
		return new ErrorResponseEntity(exception.getCode(), exception.getMessage());
	}

	/**
	 * 捕获 RuntimeException 异常
	 *
	 * @param request  request
	 * @param e        exception
	 * @param response response
	 * @return 响应结果
	 */
	@ExceptionHandler(RuntimeException.class)
	public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e,
			HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());

		RuntimeException exception = (RuntimeException) e;
		return new ErrorResponseEntity(400, exception.getMessage());
	}

	/**
	 * 通用的接口映射异常处理方
	 */
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
			return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
					exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
		}

		if (ex instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;

			System.out.println("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数："
					+ exception.getName() + ",信息：" + exception.getLocalizedMessage());

			return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
		}

		return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
	}
}
