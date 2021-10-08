package com.like.user.domain.model;

import com.like.hrm.staff.domain.model.Staff;

public class ContactInfo {

	private Long id;
	
	private Staff employee;
	
	private String type;
	
	private String number;
	
	private boolean isLast;
	
	public ContactInfo(Staff employee
					  ,String type
					  ,String number
					  ,Boolean isLast) {
		this.employee = employee;
		this.type = type;
		this.number = number;
		this.isLast = isLast;
	}
}
