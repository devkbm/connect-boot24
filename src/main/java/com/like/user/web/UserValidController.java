package com.like.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebControllerUtil;
import com.like.user.domain.model.Authority;
import com.like.user.service.AuthorityService;
import com.like.user.service.UserService;

@RestController
public class UserValidController {
	
	private UserService userService;
	private AuthorityService authorityService;
		
	public UserValidController(UserService userService
							  ,AuthorityService authorityService) {
		this.userService = userService;
		this.authorityService = authorityService;
	}

	@GetMapping(value={"/common/user/{id}/check"})
	public ResponseEntity<?> checkId(@PathVariable(value="id") String userId) {
						
		boolean isDuplicated = userService.CheckDuplicationUser(userId);					
				
		return WebControllerUtil
				.getResponse(isDuplicated ? false : true
						    ,isDuplicated ? "기존 아이디가 존재합니다." : "신규 등록 가능합니다."
						    ,HttpStatus.OK); 
	}
		
	@GetMapping(value={"/common/authority/{id}/check"})
	public ResponseEntity<?> getAuthorityDupCheck(@PathVariable(value="id") String authorityName) {			
					
		Authority authority = authorityService.getAuthority(authorityName);										
		
		boolean rtn = authority == null ? true : false;
						
		return WebControllerUtil
				.getResponse(rtn
							,rtn == false? "기존에 등록된 권한이 존재합니다." : "신규 등록 가능합니다."
							,HttpStatus.OK);
	}
}
