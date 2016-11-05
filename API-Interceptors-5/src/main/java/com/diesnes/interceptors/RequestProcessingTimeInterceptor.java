package com.diesnes.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//https://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-interceptor-tutorial/
//http://www.concretepage.com/spring/spring-mvc/spring-handlerinterceptor-annotation-example-webmvcconfigureradapter
//https://dzone.com/articles/using-spring-interceptors-your
public class RequestProcessingTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingTimeInterceptor.class);

	@Override  //is called before the actual controller is executed
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("INTERCEPTOR: TIME: preHandle: " + InterceptorPriority.TIME_PRIORITY);
//		long startTime = System.currentTimeMillis();
//		logger.info(
//				"Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + System.currentTimeMillis());
//		request.setAttribute("startTime", startTime);
		// if returned false, we need to make sure 'response' is sent
		return true;
	}

	@Override  // is called after the controller is executed.
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//logger.info("Request URL::" + request.getRequestURL().toString() + " Sent to Handler :: Current Time="
		//		+ System.currentTimeMillis());
		// we can add attributes in the modelAndView and use that in the view
		// page
		logger.info("INTERCEPTOR: TIME: postHandle: " + InterceptorPriority.TIME_PRIORITY);
	}

	@Override  //after the complete request has finished
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	//	long startTime = (Long) request.getAttribute("startTime");
	//	logger.info("Request URL::" + request.getRequestURL().toString() + ":: End Time=" + System.currentTimeMillis());
	//	logger.info("Request URL::" + request.getRequestURL().toString() + ":: Time Taken="
	//			+ (System.currentTimeMillis() - startTime));
		logger.info("INTERCEPTOR: TIME: afterCompletion: " + InterceptorPriority.TIME_PRIORITY);
	}

}