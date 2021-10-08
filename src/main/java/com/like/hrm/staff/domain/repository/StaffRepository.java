package com.like.hrm.staff.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.hrm.staff.domain.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String>, QuerydslPredicateExecutor<Staff> {			
}
