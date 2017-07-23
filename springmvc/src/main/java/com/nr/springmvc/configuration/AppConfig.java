package com.nr.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.tiles2.TilesViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.nr.springmvc.converter.RoleToUserProfileConverter;
 
 
 
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nr.springmvc")
public class AppConfig extends WebMvcConfigurerAdapter{
     
     
    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;
     
 
    /**
     * Configure ViewResolvers to deliver preferred views.
     */
       
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	System.out.println("=================================================");
 System.out.println("AppConfig->configureViewResolvers()");
 System.out.println("=================================================");
           TilesViewResolver viewResolver = new TilesViewResolver();
           
      /*  viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
     
        viewResolver.setSuffix(".jsp");
        System.out.println("=================================================");
        System.out.println(viewResolver);
        System.out.println("=================================================");*/
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("=================================================");
    	System.out.println("AppConfig->addResourceHandlers()");
    	System.out.println("=================================================");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
     
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	System.out.println("=================================================");
    	System.out.println("AppConfig->addFormatters()");
    	System.out.println("=================================================");
        registry.addConverter(roleToUserProfileConverter);
    }
     
 
    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
    @Bean
    public MessageSource messageSource() {
    	System.out.println("=================================================");
    	System.out.println("AppConfig->messageSource()");
    	System.out.println("=================================================");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
     
    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
     * This is a workaround for this issue.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
    	System.out.println("=================================================");
    	System.out.println("AppConfig->configurePathMatch()");
    	System.out.println("=================================================");
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
    
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
    	TilesConfigurer  tilesConfigurer=new TilesConfigurer();
    	tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
    	tilesConfigurer.setCheckRefresh(true);
    	return tilesConfigurer;
    }
     
    
    
  /*  @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
            configurer.enable();
    }*/
}