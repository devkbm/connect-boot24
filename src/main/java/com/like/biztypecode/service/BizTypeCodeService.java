package com.like.biztypecode.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.biztypecode.boundary.BizTypeCodeDTO;
import com.like.biztypecode.domain.BizTypeCode;
import com.like.biztypecode.domain.BizTypeCodeRepository;

@Service
@Transactional
public class BizTypeCodeService {

	private BizTypeCodeRepository repository;
	
	public BizTypeCodeService(BizTypeCodeRepository repository) {
		this.repository = repository;
	}
	
	public BizTypeCode getBizTypeCode(String id) {
		return repository.findById(id).orElse(null);
	}
	
	public void saveBizTypeCode(BizTypeCodeDTO.SaveDTO dto) {
		BizTypeCode entity = null;
		
		if (dto.getId() != null) {
			entity = this.getBizTypeCode(dto.getId());
		} else {
			entity = dto.newEntity();
		}
		
		repository.save(entity);
	}
	
	public void deleteBizTypeCode(String id) {
		repository.deleteById(id);
	}
}
