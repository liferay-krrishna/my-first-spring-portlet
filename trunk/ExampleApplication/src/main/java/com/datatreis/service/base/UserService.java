package com.datatreis.service.base;
import java.util.List;

import com.datatreis.model.User;

public interface UserService {
	public void addUser(User user);  
    public List<User> getUsers(); 
    public void updateUser(User user);  
    public User getUser(int id);  
    public void deleteUser(int id);  
}
