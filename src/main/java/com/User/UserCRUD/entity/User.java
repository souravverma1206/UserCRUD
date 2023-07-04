package com.User.UserCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "First Name")
	private String firstName;
	
	@Column(name = "Last Name")
	private String lastName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Age")
	private int age;
	
	
	
}
