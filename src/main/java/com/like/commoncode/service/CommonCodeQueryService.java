package com.like.commoncode.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.commoncode.boundary.CodeComboDTO;
import com.like.commoncode.boundary.CodeDTO;
import com.like.commoncode.boundary.CodeHierarchy;
import com.like.commoncode.domain.model.Code;
import com.like.commoncode.domain.repository.CommonCodeQueryRepository;

@Service
@Transactional(readOnly=true)
public class CommonCodeQueryService {

	private CommonCodeQueryRepository codeRepository;
			
	public CommonCodeQueryService(CommonCodeQueryRepository codeRepository) {
		this.codeRepository = codeRepository;
	}
		
	public List<Code> getCodeList(String parentCodeId) {		
		return codeRepository.getCodeList(parentCodeId);
	}
	
	public List<Code> getCodeList(CodeDTO.SearchCode searchCondition) {		
		return codeRepository.getCodeList(searchCondition.getCondition());
	}
	
	public List<CodeHierarchy> getCodeHierarchyList(CodeDTO.SearchCode searchCondition) {		
		
		return codeRepository.getCodeHierarchyList(searchCondition);
	}
	
	public List<CodeComboDTO> getCodeListByComboBox(String codeGroup) {
		return codeRepository.getCodeListByComboBox(codeGroup);
	}	
}
