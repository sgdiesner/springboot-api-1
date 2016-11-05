package com.diesnes.interceptors;

import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Order(InterceptorPriority.ADD_CONTENT_PRIORITY)  //See Ordered - this is just a value between Integer.MIN_VALUE and Integer.MAX_VALUE - have some scheme
public class WebMvcConfigAddContentInterceptor extends WebMvcConfigurerAdapter {

//	@Autowired
//	RequestProcessingTimeInterceptor yourInjectedInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestProcessingAddContentInterceptor());
	}

}
