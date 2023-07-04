package com.User.UserCRUD.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	
	public ResourceNotFoundException(int userId) {
		
		super("User with Id "+userId+" Not Found");
	}

}
