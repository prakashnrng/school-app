package com.nr.springmvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nr.springmvc.dao.UserProfileDao;
import com.nr.springmvc.model.Student;
import com.nr.springmvc.model.UserProfile;
 
 
 
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
     
	static Logger logger=LoggerFactory.getLogger(UserProfileServiceImpl.class);
    @Autowired
    UserProfileDao dao;
     
    public UserProfile findById(int id) {
    	logger.info("UserProfileServiceImpl->findById(id)");
        return dao.findById(id);
    }
 
    public UserProfile findByType(String type){
    	logger.info("UserProfileServiceImpl->findByType(String type)");
        return dao.findByType(type);
    }
 
   
    
    public List<UserProfile> findAll() {
    	logger.info("UserProfileServiceImpl->findAll");
        return dao.findAll();
    }
}