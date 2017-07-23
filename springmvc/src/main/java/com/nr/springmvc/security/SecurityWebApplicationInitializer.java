package com.nr.springmvc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
  
	static Logger logger=LoggerFactory.getLogger(SecurityWebApplicationInitializer.class);
	static{
		logger.info("=========================================");
		logger.info("SecurityWebApplicationInitializer->s.b");
		logger.info("=========================================");
	}
}
