package com.like.hrm.appointmentcode.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AppointmentCodeRepository extends JpaRepository<AppointmentCode, String>, QuerydslPredicateExecutor<AppointmentCode> {			
	
}
