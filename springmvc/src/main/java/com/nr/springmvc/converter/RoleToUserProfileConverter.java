package com.nr.springmvc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nr.springmvc.model.UserProfile;
import com.nr.springmvc.service.UserProfileService;
 
 
/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{
 
	static{
		System.out.println("RoleToUserProfileConverter->s.b");
	}
	
	
    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
     
    @Autowired
    UserProfileService userProfileService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
    	System.out.println("RoleToUserProfileConverter->UserProfile->convert(Object)");
        Integer id = Integer.parseInt((String)element);
        System.out.println("RoleToUserProfileConverter->UserProfile->convert(Object)"+id);
        UserProfile profile= userProfileService.findById(id);
        System.out.println("RoleToUserProfileConverter->UserProfile->convert(Object)"+profile);
        logger.info("Profile : {}",profile);
        return profile;
    }
     
}
