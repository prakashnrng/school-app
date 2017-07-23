package com.nr.springmvc.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum UserProfileType implements Serializable{
	
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN"),
	PRINCIPAL("PRINCIPAL"),
	DIRECTOR("DIRECTOR");
  static  Logger log=LoggerFactory.getLogger(UserProfileType.class);
    String userProfileType;
     
    private UserProfileType(String userProfileType){
    	System.out.println("------------------------------------------------------------");
    	System.out.println("UserProfileType->UserProfileType(UserProfileType)");
    	System.out.println(userProfileType);
    	System.out.println("------------------------------------------------------------");
    	
    	
    	this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
    	System.out.println("------------------------------------------------------------");
    	System.out.println("UserProfileType->getUserProfileType");
    	System.out.println(userProfileType);
    	System.out.println("------------------------------------------------------------");
    	
    	
    	
        return userProfileType;
    }
     
}