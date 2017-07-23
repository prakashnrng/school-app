package com.nr.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nr.springmvc.model.UserProfile;
 
 
 
 
 
@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile>implements UserProfileDao{
 
	static{
		System.out.println("UserProfileDaoImpl->s.b");
	}
	
    public UserProfile findById(int id) {
    	System.out.println("UserProfileDaoImpl->findById(id)");
        return getByKey(id); 
    }
 
    public UserProfile findByType(String type) {
    	System.out.println("UserProfileDaoImpl->findByType(String)");
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (UserProfile) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll(){
    	System.out.println("UserProfileDaoImpl->findAll()");
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();
    }
    
    
    
     
}