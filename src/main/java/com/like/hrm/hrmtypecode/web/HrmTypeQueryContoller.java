package com.like.hrm.hrmtypecode.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebControllerUtil;
import com.like.hrm.hrmtypecode.boundary.HrmTypeDTO;
import com.like.hrm.hrmtypecode.boundary.HrmTypeDetailCodeDTO;
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
		
		List<HrmTypeDTO.SaveCode> list = new ArrayList<HrmTypeDTO.SaveCode>();
		
		for (HrmTypeEnum menuType : HrmTypeEnum.values()) {			
			list.add(new HrmTypeDTO.SaveCode(menuType.getCode()
											,menuType.getName()
											,true
											,0
											,"HRMTYPE"
											,""));
		}										
					
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
	
	@GetMapping("/hrm/hrmtype")
	public ResponseEntity<?> getHrmTypeList(HrmTypeDTO.SearchHrmType dto) {
		
		//List<HrmType> list = service.getHrmDeptTypeList(dto);												
		
		List<HrmTypeDTO.SaveCode> list = service.getHrmDeptTypeList(dto)
												.stream()
												.map(e -> HrmTypeDTO.SaveCode.convert(e))
												.collect(Collectors.toList());
		
		//HrmTypeDTO.SaveCode.convert(entity)
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
	
	@GetMapping("/hrm/hrmtype/{type}/code")
	public ResponseEntity<?> getHrmTypeDetailCodeList(HrmTypeDetailCodeDTO.SearchHrmTypeDetailCode dto) {
		
		//List<HrmTypeDetailCode> list = service.getHrmDeptTypeList(dto);												
		
		List<HrmTypeDetailCodeDTO.SaveCode> list = service.getHrmDeptTypeList(dto)
														  .stream()
														  .map(e -> HrmTypeDetailCodeDTO.SaveCode.convert(e))
														  .collect(Collectors.toList());
		
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
}
