package com.datatreis.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datatreis.dao.base.UserDao;
import com.datatreis.model.User;

@Service 
public class UserDaoImpl implements UserDao{
	@Autowired  
    private SessionFactory sessionfactory;  
	 private Session getCurrentSession() {  
	        return sessionfactory.getCurrentSession(); 
	    }  
@Override
   public void saveUser(User user) {  
        getCurrentSession().saveOrUpdate(user) ; 
    }  
@Override
    public List<User> getUsers() {  
  
        @SuppressWarnings("unchecked")  
        List<User> userlist = sessionfactory.getCurrentSession()  
                .createCriteria(User.class).list();  
        return userlist;   
}
@Override
public void updateUser(User user){
	User userToUpdate = getUser(user.getId());
	userToUpdate.setFirstName(user.getFirstName());
	userToUpdate.setLastName(user.getLastName());
	userToUpdate.setGender(user.getGender());
	userToUpdate.setCity(user.getCity());
	getCurrentSession().update(userToUpdate);
}
@Override
public User getUser(int id){
	
	User user = (User) getCurrentSession().get(User.class, id);
	return user;
	}
@Override
public void deleteUser(int id){
	User user = getUser(id);
    	if (user != null)
               getCurrentSession().delete(user);
       }
}
