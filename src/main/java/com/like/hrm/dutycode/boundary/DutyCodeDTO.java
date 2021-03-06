package com.like.hrm.dutycode.boundary;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.hrm.dutycode.domain.DutyCode;
import com.like.hrm.dutycode.domain.QDutyCode;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DutyCodeDTO {

	public static class SearchDutyCode implements Serializable {
			
		private static final long serialVersionUID = 393877591925132395L;

		private final QDutyCode qDutyCode = QDutyCode.dutyCode1; 
		
		String dutyCode;
		
		String dutyName;
		
		Boolean enabled;
		
		public BooleanBuilder getBooleanBuilder() {
			BooleanBuilder builder = new BooleanBuilder();
			builder
				.and(likeDutyCode(this.dutyCode))
				.and(likeDutyName(this.dutyName));
			
			return builder;
		}
		
		private BooleanExpression likeDutyCode(String dutyCode) {
			if (!StringUtils.hasText(dutyCode)) {
				return null;
			}
			
			return qDutyCode.dutyCode.like("%"+dutyCode+"%");
		}
		
		private BooleanExpression likeDutyName(String dutyName) {
			if (!StringUtils.hasText(dutyName)) {
				return null;
			}
			
			return qDutyCode.dutyName.like("%"+dutyName+"%");
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SaveDutyCode implements Serializable {				

		private String dutyCode;
				
		private String dutyName;
				
		private Boolean enabled;
				
		private String dutyGroup;
					
		private Boolean isFamilyEvent = false;
		
		private Long familyEventAmt;		
		
		private String comment;
		
		private List<Long> dutyApplicationInputLimitIdList;
		
		public DutyCode newEntity() {
			return DutyCode.builder()
						   .dutyCode(dutyCode)
						   .dutyName(dutyName)
						   .enabled(enabled)
						   .dutyGroup(dutyGroup)
						   .isFamilyEvent(isFamilyEvent)
						   .familyEventAmt(familyEventAmt)
						   .comment(comment)
						   .dutyApplicationInputLimitIdList(dutyApplicationInputLimitIdList)
						   .build();
		}
		
		public void modifyEntity(DutyCode entity) {
			entity.modifyEntity(dutyName
							   ,enabled
							   ,dutyGroup
							   ,isFamilyEvent
							   ,familyEventAmt
							   ,comment);
		}
		
		public static SaveDutyCode convert(DutyCode entity) {
			return SaveDutyCode.builder()
							   .dutyCode(entity.getDutyCode())
							   .dutyName(entity.getDutyName())
							   .enabled(entity.getEnabled())
							   .dutyGroup(entity.getDutyGroup())
							   .isFamilyEvent(entity.getIsFamilyEvent())
							   .familyEventAmt(entity.getFamilyEventAmt())
							   .comment(entity.getComment())
							   .dutyApplicationInputLimitIdList(entity.getDutyCodeRule().stream().map(e -> e.getDutyApplicationInputLimitId()).collect(Collectors.toList()))
							   .build();
		}
	}
}
