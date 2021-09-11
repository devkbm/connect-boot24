package com.like.biztypecode.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.biztypecode.boundary.BizDetailCodeDTO;
import com.like.biztypecode.domain.BizDetailCodeId;
import com.like.biztypecode.service.BizDetailCodeService;
import com.like.core.web.exception.ControllerException;
import com.like.core.web.util.WebControllerUtil;

@RestController
public class BizDetailCodeController {

	private BizDetailCodeService service;
	
	public BizDetailCodeController(BizDetailCodeService service) {
		this.service = service;
	}
	
	@GetMapping("/common/biztype/{typeCode}/bizdetail/{detailCode}")
	public ResponseEntity<?> getBizDetailCode(@PathVariable(value="typeCode") String typeCode
											 ,@PathVariable(value="detailCode") String detailCode) {
		
		BizDetailCodeDTO.SaveDTO dto = BizDetailCodeDTO.SaveDTO.convert(service.getBizDetailCode(new BizDetailCodeId(typeCode, detailCode)));
					
		return WebControllerUtil.getResponse(dto											
											,String.format("%d 건 조회되었습니다.", dto == null ? 0 : 1)
											,HttpStatus.OK);
	}
			
	@PostMapping("/common/biztype/bizdetail")	
	public ResponseEntity<?> saveBizDetailCode(@RequestBody BizDetailCodeDTO.SaveDTO dto, BindingResult result) {				
		
		if ( result.hasErrors()) {			
			throw new ControllerException(result.toString());
		} 
																	
		service.saveBizDetailCode(dto);						
								 					
		return WebControllerUtil.getResponse(null											
											,String.format("%d 건 저장되었습니다.", 1)
											,HttpStatus.OK);
	}
	
		
	@DeleteMapping("/common/biztype/{typeCode}/bizdetail/{detailCode}")
	public ResponseEntity<?> deleteBizDetailCode(@PathVariable(value="typeCode") String typeCode
			 									,@PathVariable(value="detailCode") String detailCode) {				
																		
		service.deleteBizDetailCode(new BizDetailCodeId(typeCode, detailCode));						
								 					
		return WebControllerUtil.getResponse(null											
											,String.format("%d 건 삭제되었습니다.", 1)
											,HttpStatus.OK);
	}
}
