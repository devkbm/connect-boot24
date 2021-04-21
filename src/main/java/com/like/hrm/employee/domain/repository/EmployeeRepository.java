package com.like.hrm.employee.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.hrm.employee.domain.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, QuerydslPredicateExecutor<Employee> {			
}
