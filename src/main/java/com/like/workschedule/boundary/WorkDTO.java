package com.like.workschedule.boundary;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;

import org.springframework.util.StringUtils;

import com.like.workschedule.domain.WorkGroup;
import com.like.workschedule.domain.QWorkGroup;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class WorkDTO {	
	
	@Data
	public static class SearchWorkGroup implements Serializable {
		
		private static final long serialVersionUID = 1L;

		private final QWorkGroup qWorkGroup = QWorkGroup.workGroup;
						
		String name;			
					
		public BooleanBuilder getBooleanBuilder() {
			BooleanBuilder builder = new BooleanBuilder();
			
			builder.and(likeGroupName(this.name));			
			
			return builder;
		}
		
		private BooleanExpression likeGroupName(String name) {
			if (!StringUtils.hasText(name)) return null;
			
			return qWorkGroup.name.like("%"+this.name+"%");
		}
	}	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class FormWorkGroup implements Serializable {
				
		private static final long serialVersionUID = 8230052719254860669L;

		LocalDateTime createdDt;	 
		
		String createdBy;
		
		LocalDateTime modifiedDt;
		
		String modifiedBy;
		
		@Nullable
		Long workGroupId;
				
		@NotEmpty
		String workGroupName;		
		
		String color;
		
		List<String> memberList;
		
		public WorkGroup newWorkGroup() {
			return new WorkGroup(this.workGroupName, this.color);
		}
		
		public void modifyWorkGroup(WorkGroup workGroup) {
			workGroup.modifyEntity(this.workGroupName, color);
		}
		
		public static WorkDTO.FormWorkGroup convertDTO(WorkGroup entity) {
			WorkDTO.FormWorkGroup dto = FormWorkGroup.builder()
													 .workGroupId(entity.getId())
													 .workGroupName(entity.getName())
													 .color(entity.getColor())
													 .memberList(entity.getMemberList().stream().map( r -> r.getUser().getUserId()).collect(Collectors.toList()))
													 .build();
			
			return dto;
		}
	}
		
	
}
