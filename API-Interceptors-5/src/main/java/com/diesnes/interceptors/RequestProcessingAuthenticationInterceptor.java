package com.diesnes.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//https://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-interceptor-tutorial/
//http://www.concretepage.com/spring/spring-mvc/spring-handlerinterceptor-annotation-example-webmvcconfigureradapter
public class RequestProcessingAuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingAuthenticationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("INTERCEPTOR: AUTHENTICATION: updateRequest: " + InterceptorPriority.AUTH_PRIORITY);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("INTERCEPTOR: AUTHENTICATION: postHandle: " + InterceptorPriority.AUTH_PRIORITY);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("INTERCEPTOR: AUTHENTICATION: afterCompletion : " + InterceptorPriority.AUTH_PRIORITY);
	}

}