package com.like.hrm.appointment.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.exception.ControllerException;
import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.appointment.boundary.AppointmentRegisterDTO;
import com.like.hrm.appointment.domain.model.AppointmentRegister;
import com.like.hrm.appointment.service.AppointmentRegisterCommandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppointmentRegisterController {
	
	private AppointmentRegisterCommandService commandService;		

	public AppointmentRegisterController(AppointmentRegisterCommandService commandService) {
		this.commandService = commandService;		
	}	
	
	@GetMapping("/hrm/appointmentregister/{id}")
	public ResponseEntity<?> getAppointmentRegister(@PathVariable(value="id") String id) {
		
		AppointmentRegister ledger = commandService.getLedger(id);
					
		return WebControllerUtil.getResponse(ledger											
											,String.format("%d 건 조회되었습니다.", ledger == null ? 0 : 1)
											,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/appointmentregister"}, method={RequestMethod.POST,RequestMethod.PUT}) 
	public ResponseEntity<?> saveAppointmentRegister(@RequestBody AppointmentRegisterDTO.SaveAppointmentRegister dto, BindingResult result) {				
		
		if ( result.hasErrors()) {
			log.info(result.toString());
			throw new ControllerException(result.toString());
		} 
																	
		commandService.saveLedger(dto);						
								 					
		return WebControllerUtil.getResponse(null											
											,String.format("%d 건 저장되었습니다.", 1)
											,HttpStatus.OK);
	}
	
	@DeleteMapping("/hrm/appointmentregister/{id}")
	public ResponseEntity<?> deleteAppointmentRegister(@PathVariable(value="id") String id) {				
																		
		commandService.deleteLedger(id);						
								 					
		return WebControllerUtil.getResponse(null											
											,String.format("%d 건 삭제되었습니다.", 1)
											,HttpStatus.OK);
	}	
	
}
