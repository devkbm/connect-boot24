package com.like.dept.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.dept.boundary.DeptDTO;
import com.like.dept.boundary.ResponseDeptHierarchy;
import com.like.dept.domain.Dept;
import com.like.dept.domain.DeptQueryRepository;

@Service
@Transactional(readOnly = true)
public class DeptQueryService {

	private DeptQueryRepository repository;
	
	public DeptQueryService(DeptQueryRepository repository) {
		this.repository = repository;
	}
	
	public List<Dept> getDeptList(DeptDTO.SearchDept searchCondition) {
		return repository.getDeptList(searchCondition);
	}
	
	public List<ResponseDeptHierarchy> getDeptHierarchyList() {
		return repository.getDeptHierarchy();
	}
	
}
