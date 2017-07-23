package com.nr.springmvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nr.springmvc.dao.UserDao;
import com.nr.springmvc.model.User;
 
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
 
    @Autowired
    private UserDao dao;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
     
    public User findById(int id) {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->findById()");
    	logger.info("======================================");
        return dao.findById(id);
    }
 
    public User findBySSO(String sso) {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->findBySSO()");
    	logger.info("======================================");
        User user = dao.findBySSO(sso);
        return user;
    }
 
    public void saveUser(User user) {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->saveUser()");
    	logger.info("======================================");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUser(User user) {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->updateUser"+user);
    	logger.info("======================================");
        User entity = dao.findById(user.getId());
        logger.info("UserServiceImpl->updateUser()"+entity);
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            if(!user.getPassword().equals(entity.getPassword())){
            	logger.info("UserServiceImpl->updateUser(user)-> if(!user.getPassword().equals(entity.getPassword()))");
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            logger.info("======================================");
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }
 
     
    public void deleteUserBySSO(String sso) {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->deleteUserBySSO(sso)");
    	logger.info("======================================");
        dao.deleteBySSO(sso);
    }
 
    public List<User> findAllUsers() {
    	logger.info("======================================");
    	logger.info("UserServiceImpl->deleteUserBySSO(sso)");
    	logger.info("======================================");
        return dao.findAllUsers();
    }
 
    public boolean isUserSSOUnique(Integer id, String sso) {
    	logger.info("======================================");
    	 
        User user = findBySSO(sso);
        logger.info("UserServiceImpl->isUserSSOUnique()"+user);
        logger.info("======================================");
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
     
}