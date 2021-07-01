package com.like.hrm.appointmentcode.domain;

import java.util.List;

import com.like.hrm.appointmentcode.boundary.AppointmentCodeDTO;

public interface AppointmentCodeQueryRepository {

	/**
	 * 발령코드 명단을 조회한다.
	 * @param condition
	 * @return
	 */
	List<AppointmentCode> getAppointmentCodeList(AppointmentCodeDTO.SearchCode dto);
	
	/**
	 * 발령코드 상세정보 명단을 조회한다.
	 * @param dto
	 * @return
	 */
	List<AppointmentCodeDetail> getAppointmentCodeDetailList(AppointmentCodeDTO.SearchCodeDetail dto);
}
