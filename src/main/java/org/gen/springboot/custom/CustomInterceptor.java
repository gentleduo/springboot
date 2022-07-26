package org.gen.springboot.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建拦截器实现HandlerInterceptor接口。
 * 拦截器的方法将按preHandle==>Controller==>postHandle==>afterCompletion的顺序执行。
 * 注意，只有preHandle方法 返回true时后面的方法才会执行。当拦截器链内存在多个拦截器时，postHandle在拦截器链内的所有拦截器返回成功时才会调用，
 * 而afterCompletion只有preHandle返回true才调用，但若拦截器链内的第一个拦截器的preHandle方法返回false，则后面的方法都不执行。
 */
public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("CustomInterceptor>>>preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		System.out.println("CustomInterceptor>>>postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("CustomInterceptor>>>afterCompletion");
	}
}
