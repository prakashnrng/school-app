package com.nr.springmvc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	static{
		System.out.println("AppInitializer->s.b");
	}
	
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	System.out.println("AppInitializer->getRootConfigClasses");
        return new Class[] { AppConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	System.out.println("AppInitializer->getServletConfigClasses");
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
    	System.out.println("AppInitializer->getServletMappings()");
        return new String[] { "/" };
    }
 
}
