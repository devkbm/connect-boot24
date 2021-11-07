package com.like.biztypecode.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.biztypecode.boundary.BizDetailCodeDTO;
import com.like.biztypecode.domain.BizDetailCode;
import com.like.biztypecode.domain.BizDetailCodeId;
import com.like.biztypecode.domain.BizDetailCodeRepository;

@Service
@Transactional
public class BizDetailCodeService {

	private BizDetailCodeRepository repository;
	
	public BizDetailCodeService(BizDetailCodeRepository repository) {
		this.repository = repository;
	}
	
	public BizDetailCode getBizDetailCode(BizDetailCodeId id) {
		return repository.findById(id).orElse(null);
	}
	
	public void saveBizDetailCode(BizDetailCodeDTO.FormBizDetailCode dto) {
		BizDetailCode entity = this.getBizDetailCode(new BizDetailCodeId(dto.getTypeCode(), dto.getDetailCode()));
		
		if (entity == null) {
			entity = dto.newEntity();
		} else {
			dto.modify(entity);
		}
		
		repository.save(entity);
	}
	
	public void deleteBizDetailCode(BizDetailCodeId id) {
		repository.deleteById(id);
	}
}
