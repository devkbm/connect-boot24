package com.like.hrm.staff.infra.jparepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.boundary.StaffDTO.SearchEmployee;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.domain.repository.StaffQueryRepository;

@Repository
public class StaffQuery implements StaffQueryRepository {

	@Override
	public List<Staff> getEmployeeList(SearchEmployee dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff getLastEmployee(String yyyy) {
		// TODO Auto-generated method stub
		return null;
	}

}
