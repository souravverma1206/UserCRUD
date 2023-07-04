package com.User.UserCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.UserCRUD.entity.User;
import com.User.UserCRUD.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User newUser = this.userService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId){
		
		User updatedUser = this.userService.updateUser(user, userId);
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> users = this.userService.getAllUsers(); 
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		
		User user = this.userService.getUserById(userId);
		
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId){
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
	}
	
}
