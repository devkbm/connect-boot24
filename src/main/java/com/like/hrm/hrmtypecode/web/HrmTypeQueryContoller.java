package com.like.hrm.hrmtypecode.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.appointment.boundary.ChangeableTypeDTO;
import com.like.hrm.appointment.boundary.ChangeableTypeDTO.EnumDTO;
import com.like.hrm.hrmtypecode.boundary.HrmTypeDTO;
import com.like.hrm.hrmtypecode.boundary.HrmTypeDetailCodeDTO;
import com.like.hrm.hrmtypecode.domain.HrmType;
import com.like.hrm.hrmtypecode.domain.HrmTypeDetailCode;
import com.like.hrm.hrmtypecode.domain.HrmTypeEnum;
import com.like.hrm.hrmtypecode.service.HrmTypeQueryService;

@RestController
public class HrmTypeQueryContoller {

	private HrmTypeQueryService service;
	
	public HrmTypeQueryContoller(HrmTypeQueryService service) {
		this.service = service;
	}
	
	@GetMapping("/hrm/typelist")
	public ResponseEntity<?> getTypeList() {
		
		List<ChangeableTypeDTO.EnumDTO> list = new ArrayList<ChangeableTypeDTO.EnumDTO>();
		
		for (HrmTypeEnum menuType : HrmTypeEnum.values()) {			
			list.add(new EnumDTO(menuType.getCode(), menuType.getName()));
		}										
					
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
	
	@GetMapping("/hrm/hrmtype")
	public ResponseEntity<?> getHrmTypeList(HrmTypeDTO.SearchHrmType dto) {
		
		List<HrmType> list = service.getHrmDeptTypeList(dto);												
					
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
	
	@GetMapping("/hrm/typedetailcode")
	public ResponseEntity<?> getHrmTypeDetailCodeList(HrmTypeDetailCodeDTO.SearchHrmTypeDetailCode dto) {
		
		List<HrmTypeDetailCode> list = service.getHrmDeptTypeList(dto);												
					
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
}
