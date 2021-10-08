package com.like.hrm.staff.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.exception.ControllerException;
import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.staff.boundary.StaffDTO;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.service.StaffService;

@RestController
public class StaffController {
	
	private StaffService employeeService;
		
	public StaffController(StaffService employeeService) {
		this.employeeService = employeeService;
	}		
	
	@GetMapping("/hrm/employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable String id) {
				
		Staff emp = employeeService.getEmployee(id);  									
		
		StaffDTO.ResponseEmployee dto = StaffDTO.ResponseEmployee.convert(emp); 
		
		return WebControllerUtil
				.getResponse(dto											
							,String.format("%d 건 조회되었습니다.", dto == null ? 0 : 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/employee/create"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> newEmployee(@RequestBody @Valid StaffDTO.NewEmployee dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		} 											
						
		employeeService.newEmployee(dto);
											 				
		return WebControllerUtil
				.getResponse(null											
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/employee"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> saveEmployee(@RequestBody StaffDTO.SaveEmployee dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		} 											
						
		employeeService.saveEmployee(dto);
											 				
		return WebControllerUtil
				.getResponse(null											
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/employee/changedept"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> saveDeptChange(@RequestBody StaffDTO.NewDept dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		} 											
				
		employeeService.saveDeptChangeHistory(dto);
											 				
		return WebControllerUtil
				.getResponse(null											
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/employee/changejob"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> saveJobChange(@RequestBody StaffDTO.NewJob dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		} 											
				
		employeeService.saveJobChangeHistory(dto);
											 				
		return WebControllerUtil
				.getResponse(null											
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/employee/changestatus"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> saveStatusChange(@RequestBody StaffDTO.NewStatus dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류");
		} 											
				
		employeeService.saveStatusChangeHistory(dto);
											 				
		return WebControllerUtil
				.getResponse(null							
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}	
	
}
