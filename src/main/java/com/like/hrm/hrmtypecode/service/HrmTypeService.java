package com.like.hrm.hrmtypecode.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.hrmtypecode.boundary.HrmTypeDTO;
import com.like.hrm.hrmtypecode.boundary.HrmTypeDetailCodeDTO;
import com.like.hrm.hrmtypecode.domain.HrmType;
import com.like.hrm.hrmtypecode.domain.HrmTypeDetailCode;
import com.like.hrm.hrmtypecode.domain.HrmTypeDetailCodeRepository;
import com.like.hrm.hrmtypecode.domain.HrmTypeRepository;

@Service
@Transactional
public class HrmTypeService {

	private HrmTypeRepository hrmTypeRepository;
	private HrmTypeDetailCodeRepository hrmTypeDetailCodeRepository;	
	
	public HrmTypeService(HrmTypeRepository hrmTypeRepository
						 ,HrmTypeDetailCodeRepository hrmTypeDetailCodeRepository) {		
		this.hrmTypeRepository = hrmTypeRepository;
		this.hrmTypeDetailCodeRepository = hrmTypeDetailCodeRepository;
	}					
	
	public HrmType getHrmType(String id) {
		return hrmTypeRepository.findById(id).orElse(null);
	}
	
	public HrmTypeDTO.SaveCode getHrmTypeDTO(String code) {
		HrmType entity = this.getHrmType(code);
		
		return HrmTypeDTO.SaveCode.convert(entity);
	}
	
	public void saveHrmType(HrmTypeDTO.SaveCode dto) {
		HrmType hrmType = null; //= dto.getId() == null ? null : hrmTypeRepository.findById(dto.getId()).orElse(null);			
		
		if (hrmType == null) {
			hrmType = dto.newHrmType();
		} else {					
			hrmType = dto.changeInfo(hrmType);
		}
		
		hrmTypeRepository.save(hrmType);		
	}	

	public void deleteHrmType(String id) {
		hrmTypeRepository.deleteById(id);				
	}
	
	public HrmTypeDetailCode getTypeDetailCode(String id) {
		return hrmTypeDetailCodeRepository.findById(id).orElse(null);
	}
	
	public HrmTypeDetailCodeDTO.SaveCode getTypeDetailCodeDTO(String id) {
		HrmTypeDetailCode entity = hrmTypeDetailCodeRepository.findById(id).orElse(null);				
		
		return HrmTypeDetailCodeDTO.SaveCode.convert(entity);
	}
	
	public void saveTypeDetailCode(HrmTypeDetailCodeDTO.SaveCode dto) {		
		HrmTypeDetailCode typeDetailCode = null;
		/*
		if (dto.getId() != null) {
			typeDetailCode = this.getTypeDetailCode(dto.getId());
		}
		*/
		
		if (typeDetailCode == null) {
			typeDetailCode = dto.newTypeDetailCode();
		} else {
			typeDetailCode = dto.changeInfo(typeDetailCode);
		}
		
		hrmTypeDetailCodeRepository.save(typeDetailCode);
	}
	
	public void deleteTypeDetailCode(String id) {
		hrmTypeDetailCodeRepository.deleteById(id);
	}		
	
}
