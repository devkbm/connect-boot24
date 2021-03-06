package com.like.system.user.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.core.util.SessionUtil;
import com.like.system.core.web.exception.ControllerException;
import com.like.system.core.web.util.WebControllerUtil;
import com.like.system.user.boundary.PasswordRequestDTO;
import com.like.system.user.boundary.UserDTO;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.service.UserService;

@RestController
public class UserController {		
				
	private UserService userService;
		
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/api/common/user/myinfo")
	public ResponseEntity<?> getUserInfo() throws FileNotFoundException, IOException {
														
		SystemUser user = userService.getUser(SessionUtil.getUserId());				
		
		UserDTO.FormSystemUser dto = UserDTO.convertDTO(user);					
		
		return WebControllerUtil
				.getResponse(dto							
							,String.format("%d 건 조회되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@GetMapping("/api/common/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable(value="id") String userId) throws FileNotFoundException, IOException {
						
		SystemUser user = userService.getUser(userId);				
		
		UserDTO.FormSystemUser dto = UserDTO.convertDTO(user);					
		
		return WebControllerUtil
				.getResponse(dto							
							,String.format("%d 건 조회되었습니다.", 1)
							,HttpStatus.OK);
	}
		
	
	
	@PostMapping("/api/common/user")	
	public ResponseEntity<?> saveUser(@RequestBody UserDTO.FormSystemUser dto, BindingResult result) {
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		}										
											
		userService.saveUser(dto);					
																					 		
		return WebControllerUtil
				.getResponse(null							
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}	
	
	@DeleteMapping("/api/common/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") String userId) {
										
		userService.deleteUser(userId);															
								 					
		return WebControllerUtil
				.getResponse(null							
							,String.format("%d 건 삭제되었습니다.", 1)
							,HttpStatus.OK);
	}
		
	@PostMapping("/api/common/user/{id}/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody PasswordRequestDTO dto) {				
						
		userService.changePassword(dto.getUserId(), dto.getBeforePassword(), dto.getAfterPassword());													
								 					
		return WebControllerUtil
				.getResponse(null							
							,"비밀번호가 변경되었습니다."
							,HttpStatus.OK);
	}
			
	@PostMapping("/api/common/user/{id}/initpassword")
	public ResponseEntity<?> initializePassword(@PathVariable(value="id") String userId) {			
				
		userService.initPassword(userId);														
								 					
		return WebControllerUtil
				.getResponse(null							
							,"비밀번호가 초기화되었습니다."
							,HttpStatus.OK);
	}	
			
}
