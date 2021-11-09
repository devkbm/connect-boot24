package com.like.system.user.boundary;

import lombok.Data;

@Data
public class PasswordRequestDTO {

	String userId;
	
	String beforePassword;
	
	String afterPassword;	
}
