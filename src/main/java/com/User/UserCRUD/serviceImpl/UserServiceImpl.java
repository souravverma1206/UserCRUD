package com.User.UserCRUD.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.UserCRUD.entity.User;
import com.User.UserCRUD.exception.ResourceNotFoundException;
import com.User.UserCRUD.repository.UserRepository;
import com.User.UserCRUD.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		
		return this.userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Integer userid) {
		// TODO Auto-generated method stub
		
		User oldUser = this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException(userid));
		
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setAge(user.getAge());
		oldUser.setEmail(user.getEmail());
		
		return this.userRepo.save(oldUser);
	}

	@Override
	public User getUserById(Integer userid) {
		// TODO Auto-generated method stub
		
		User oldUser = this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException(userid));
		
		return oldUser;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userRepo.findAll();
		
		return users;
	}

	@Override
	public void deleteUser(Integer userid) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException(userid));
		
		this.userRepo.delete(user);
		
	}

}
