package com.like.hrm.employee.domain.model;

import com.like.hrm.employee.boundary.EmployeeDTO.NewEmployee;

/**
 * 사번 생성 전략 인터페이스
 * 
 * @author cb457
 *
 */
public interface EmpIdCreateStrategy {
	public String create(NewEmployee emp);
}
