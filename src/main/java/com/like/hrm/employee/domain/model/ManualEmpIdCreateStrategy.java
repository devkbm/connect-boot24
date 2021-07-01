package com.like.hrm.employee.domain.model;

import com.like.hrm.employee.boundary.EmployeeDTO.NewEmployee;

public class ManualEmpIdCreateStrategy implements EmpIdCreateStrategy  {

	@Override
	public String create(NewEmployee emp) {
		return emp.getName();
	}

}
