package com.like.hrm.staff.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.exception.ControllerException;
import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.staff.boundary.StaffDTO;
import com.like.hrm.staff.domain.model.appointment.AppointmentRecord;
import com.like.hrm.staff.service.StaffAppointmentService;

@RestController
public class StaffAppointmentController {

	private StaffAppointmentService service;
	
	public StaffAppointmentController(StaffAppointmentService service) {
		this.service = service;
	}
	
	@GetMapping("/hrm/staff/{staffId}/appointmentrecord/{id}")
	public ResponseEntity<?> getAppointmentRecord(@PathVariable String staffId
									  			 ,@PathVariable Long id) {
				
		AppointmentRecord entity = service.getAppointmentRecord(staffId, id);  									
				
		StaffDTO.SaveAppointmentRecord dto = StaffDTO.SaveAppointmentRecord.convert(entity) ;
		
		return WebControllerUtil
				.getResponse(dto											
							,String.format("%d 건 조회되었습니다.", dto == null ? 0 : 1)
							,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/hrm/staff/{staffId}/appointmentrecord"}, method={RequestMethod.POST,RequestMethod.PUT})	
	public ResponseEntity<?> saveAppointmentRecord(@RequestBody StaffDTO.SaveAppointmentRecord dto, BindingResult result) {			
		
		if ( result.hasErrors()) {
			throw new ControllerException("오류 : " +dto.toString());
		} 											
				
		service.saveAppointmentRecord(dto);
											 				
		return WebControllerUtil
				.getResponse(null							
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
	
	@PutMapping("/hrm/staff/{staffId}/appointmentrecord/{id}/apply")
	public ResponseEntity<?> applyAppointmentRecord(@PathVariable String staffId
 			 									   ,@PathVariable Long id) {									
				
		service.applyAppointmentRecord(staffId, id);
											 				
		return WebControllerUtil
				.getResponse(null							
							,String.format("%d 건 저장되었습니다.", 1)
							,HttpStatus.OK);
	}
}
