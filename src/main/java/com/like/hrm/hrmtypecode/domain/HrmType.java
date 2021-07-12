package com.like.hrm.hrmtypecode.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.like.core.domain.AuditEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMTYPECODE2")
public class HrmType extends AuditEntity {
		
	@Id
	@Column(name="TYPE_CODE")
	private String code;
	
	@Column(name="TYPE_CODE_NAME")
	private String codeName;
	
	@Column(name="USE_YN")
	private boolean useYn = true;
	
	@Column(name="PRT_SEQ")
	private Integer sequence;
	
	@Enumerated(EnumType.STRING)
	@Column(name="APPOINT_TYPE_CODE")
	private HrmTypeEnum hrmType;
				
	@Column(name="CMT")
	private String comment;		
	
	public HrmType(String code
				  ,String codeName
				  ,boolean useYn
				  ,Integer sequence
				  ,HrmTypeEnum hrmType				  
				  ,String comment) {		
		this.hrmType = hrmType;
		this.code = code;
		this.codeName = codeName;
		this.useYn = useYn;
		this.sequence = sequence;
		this.hrmType = hrmType;
		this.comment = comment;
	}
	
	public void modify(String codeName
					  ,boolean useYn
					  ,Integer sequence
					  ,HrmTypeEnum hrmType
					  ,String comment ) {		
		this.codeName = codeName;
		this.useYn = useYn;
		this.sequence = sequence;
		this.hrmType = hrmType;
		this.comment = comment;
	}	
	
}
