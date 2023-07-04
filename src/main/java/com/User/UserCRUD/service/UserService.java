package com.User.UserCRUD.service;

import java.util.List;

import com.User.UserCRUD.entity.User;

public interface UserService {

	User createUser(User user);
	User updateUser(User user , Integer userid);
	User getUserById(Integer userid);
	
	List<User> getAllUsers();
	
	void deleteUser(Integer userid);
	
	
	
}
