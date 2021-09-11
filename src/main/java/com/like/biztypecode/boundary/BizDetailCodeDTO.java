package com.like.biztypecode.boundary;

import java.io.Serializable;

import com.like.biztypecode.boundary.BizTypeCodeDTO.SaveDTO;
import com.like.biztypecode.domain.BizDetailCode;
import com.like.biztypecode.domain.BizDetailCodeId;
import com.like.biztypecode.domain.BizTypeCode;
import com.like.biztypecode.domain.BizTypeEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BizDetailCodeDTO {

	
	@Data	
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SaveDTO implements Serializable {
				
		private String typeCode;
		
		private String detailCode;
		
		private String codeName;
		
		private Boolean useYn;
		
		private Integer sequence;
					
		private String comment;
		
		public BizDetailCode newEntity() {			
			return new BizDetailCode(new BizDetailCodeId(typeCode, detailCode), codeName, useYn, sequence, comment);
		}
		
		public BizDetailCode modify(BizDetailCode entity) {
			
			entity.modify(codeName
						 ,useYn
						 ,sequence						 
						 ,comment);
			
			return entity;
		}
		
		public static SaveDTO convert(BizDetailCode entity) {
			
			if (entity == null) return null;
			
			return new SaveDTO(entity.getId().getTypeCode()
							  ,entity.getId().getDetailCode()
							  ,entity.getCodeName()
							  ,entity.getUseYn()
							  ,entity.getSequence()							  
							  ,entity.getComment());
		}
	}
}
