package com.like.hrm.employee.domain.model.status;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.core.domain.AuditEntity;
import com.like.core.vo.DatePeriod;
import com.like.hrm.employee.domain.model.Employee;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"employee"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMEMPSTATUSHISTORY")
@EntityListeners(AuditingEntityListener.class)
public class StatusChangeHistory extends AuditEntity implements Serializable {
	
	private static final long serialVersionUID = -5019024388179398823L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
			
	@Column(name="APPOINTMENT_CODE")
	private String appointmentCode;
		
	@Column(name="STATUS_CODE")
	private String statusCode;
		
	/*
	@Column(name="FROM_DT")
	private LocalDate fromDate;
		
	@Column(name="TO_DT")
	private LocalDate toDate;
	*/
	
	@Embedded
	private DatePeriod period;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", nullable=false, updatable=false)
	private Employee employee;

	/**
	 * @param employee
	 * @param appointmentCode
	 * @param statusCode
	 * @param fromDate
	 * @param toDate
	 */
	public StatusChangeHistory(Employee employee
							  ,String appointmentCode
							  ,String statusCode
							  ,DatePeriod period) {		
		this.employee = employee;
		this.appointmentCode = appointmentCode;
		this.statusCode = statusCode;
		this.period = period;
		//this.fromDate = fromDate;
		//this.toDate = toDate;	
	}
	
	/**
	 * 시작일자, 종료일자 사이에 포함되는지 여부를 리턴
	 * from <= date <= to 
	 * @param date
	 * @return
	 */
	boolean isEnabled(LocalDate date) {
		return  ( date.isAfter(this.period.getFrom()) || date.isEqual(this.period.getFrom()) ) 
			 && ( date.isBefore(this.period.getTo()) || date.isEqual(this.period.getTo()) ) ? true : false;		
	}
	
	void expire(LocalDate date) {
		if (date.isAfter(this.period.getFrom())) {
			this.period = new DatePeriod(this.period.getFrom(), date);
		} else {
			this.period = new DatePeriod(this.period.getFrom(), this.period.getFrom());
		}
	}
	
	
}
