package com.like.hrm.salary.domain.model;

import java.util.List;

import com.like.hrm.employee.domain.model.Employee;

public interface Matchable {

	public boolean match(Employee employee, List<String> condition);
}
