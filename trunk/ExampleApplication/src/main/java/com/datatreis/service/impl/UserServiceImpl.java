package com.datatreis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datatreis.dao.base.UserDao;
import com.datatreis.model.User;
import com.datatreis.service.base.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Transactional
	public void addUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	@Override
	@Transactional
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	
	@Override
	@Transactional
	public User getUser(int id){
		return userDao.getUser(id);
		
	}
	@Override
	@Transactional
	public void deleteUser(int id){
		userDao.deleteUser(id);

		
	}
}
