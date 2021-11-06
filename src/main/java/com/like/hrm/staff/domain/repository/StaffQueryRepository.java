package com.like.hrm.staff.domain.repository;

import java.util.List;

import com.like.hrm.staff.boundary.StaffDTO.SearchEmployee;
import com.like.hrm.staff.boundary.StafflAppointmentRecordList;
import com.like.hrm.staff.domain.model.Staff;

public interface StaffQueryRepository {

	List<Staff> getEmployeeList(SearchEmployee dto);
	
	/**
	 * <p>조회조건에 해당하는 마지막 생성된 사원을 조회한다.</p>
	 * @param yyyy	년도
	 * @return Employee 엔티티
	 */
	Staff getLastEmployee(String yyyy);
	
	List<StafflAppointmentRecordList> getStafflAppointmentRecordList(String staffId);
}
