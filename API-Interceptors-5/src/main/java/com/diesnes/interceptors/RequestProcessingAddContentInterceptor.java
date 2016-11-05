package com.diesnes.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//https://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-interceptor-tutorial/ (picture!)
//http://www.concretepage.com/spring/spring-mvc/spring-handlerinterceptor-annotation-example-webmvcconfigureradapter
//https://dzone.com/articles/using-spring-interceptors-your
public class RequestProcessingAddContentInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingAddContentInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			logger.info("INTERCEPTOR: ADDCONTENT: preHandle: " + InterceptorPriority.ADD_CONTENT_PRIORITY);
			// Do some changes to the incoming request object
			updateRequest(request);
			return true;
		} catch (Exception e) {
			logger.info("ADDCONTENT Interceptor: request update failed");
			return false;
		}
	}

	private void updateRequest(HttpServletRequest request) {
		logger.info("INTERCEPTOR: ADDCONTENT: updateRequest: " + InterceptorPriority.ADD_CONTENT_PRIORITY);
		request.setAttribute("commonData", "This string is required in every request");
	}

}