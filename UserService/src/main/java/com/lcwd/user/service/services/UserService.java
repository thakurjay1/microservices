package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {
	// User Operations
	
	//create 
	User saveUser(User user);
	
	//get all users
	
	List<User> getAllUsers();
	
	// get single user
	User getUser(String userId);
	
	// delete user
	void deleteUser(String userId);
	
	//update user
	User updateUser(User user, String userId);
}
