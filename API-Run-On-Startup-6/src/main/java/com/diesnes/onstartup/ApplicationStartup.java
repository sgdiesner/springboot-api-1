package com.diesnes.onstartup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//http://blog.netgloo.com/2014/11/13/run-code-at-spring-boot-startup/
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

	
  /**
   * This method is called during Spring's startup.
   * 
   * @param event Event raised when an ApplicationContext gets initialized or
   * refreshed.
   */
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
 
	  logger.info("APPLICTION-STARTUP: onApplicationEvent");
		
 
    return;
  }
 
} 