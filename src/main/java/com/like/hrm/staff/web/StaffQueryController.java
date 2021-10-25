package com.like.hrm.staff.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.staff.boundary.StaffDTO;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.service.StaffQueryService;

@RestController
public class StaffQueryController {
	
	private StaffQueryService service;
	
	public StaffQueryController(StaffQueryService service) {
		this.service = service;		
	}
	
	@GetMapping("/hrm/employee")
	public ResponseEntity<?> getEmployeeList(StaffDTO.SearchEmployee dto) {
		
		List<Staff> list = service.getEmployeeList(dto);					
		
		List<StaffDTO.ResponseEmployee> dtoList = list.stream()
														 .map(e -> StaffDTO.ResponseEmployee.convert(e))
														 .collect(Collectors.toList()); 
		
		return WebControllerUtil.getResponse(dtoList											
											,String.format("%d 건 조회되었습니다.", dtoList.size())
											,HttpStatus.OK);
	}
}