package com.like.hrm.hrmtypecode.boundary;

import java.io.Serializable;

import org.springframework.util.StringUtils;


import com.like.hrm.hrmtypecode.domain.HrmType;
import com.like.hrm.hrmtypecode.domain.HrmTypeEnum;
import com.like.hrm.hrmtypecode.domain.QHrmType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class HrmTypeDTO {

	@Data
	public static class SearchHrmType implements Serializable {
		
		private static final long serialVersionUID = 1L;

		private final QHrmType qType = QHrmType.hrmType1;
						
		private String code;
		
		private String codeName;
		
		private String hrmType;
					
		public BooleanBuilder getBooleanBuilder() {
			BooleanBuilder builder = new BooleanBuilder();
			
			builder
				.and(eqHrmType(this.hrmType))
				.and(likeCodeName(this.codeName));
						
			return builder;
		}
		
		private BooleanExpression eqHrmType(String hrmType) {
			if (!StringUtils.hasText(hrmType)) {
				return null;
			}
			
			return qType.hrmType.eq(HrmTypeEnum.valueOf(hrmType));
		}
		
		private BooleanExpression likeCodeName(String codeName) {
			if (!StringUtils.hasText(codeName)) {
				return null;
			}
			
			return qType.name.like("%" + codeName + "%");
		}
				
	}
	
	@Data	
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SaveCode implements Serializable {
				
		private static final long serialVersionUID = -4482323353197356218L;
											
		private String code;			
			
		private String codeName;					
			
		private boolean useYn;
		
		private Integer sequence;
		
		private String hrmType;
		
		private String comment;
				
		public HrmType newHrmType() {
			return new HrmType(this.code 
					   		  ,this.codeName
					   		  ,this.useYn
					   		  ,this.sequence
					   		  ,hrmType == null ? null : HrmTypeEnum.valueOf(this.hrmType)
					   		  ,this.comment);
		}
		
		public HrmType changeInfo(HrmType entity) {
			entity.modify(this.codeName
						 ,this.useYn
						 ,this.sequence
						 ,hrmType == null ? null : HrmTypeEnum.valueOf(this.hrmType)
						 ,this.comment);
			return entity;
		}
		
		public static SaveCode convert(HrmType entity) {
						
			return new SaveCode(entity.getId()
					           ,entity.getName()					           
							   ,entity.isUseYn()
							   ,entity.getSequence()
							   ,entity.getHrmType() == null ? null : entity.getHrmType().toString()
							   ,entity.getComment());
			
		}
		
		
	}
}
