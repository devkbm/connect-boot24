package com.like.hrm.hrmtypecode.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class HrmTypeDetailCodeId implements Serializable {

	@Column(name="TYPE_CODE")
	String typeCode;
		
	@Column(name="DETAIL_CODE")
	String detailCode;	
	
	public HrmTypeDetailCodeId(String typeCode, String detailCode) {
		this.typeCode = typeCode;
		this.detailCode = detailCode;
	}
}
