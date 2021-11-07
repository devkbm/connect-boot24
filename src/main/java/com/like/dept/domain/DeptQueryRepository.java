package com.like.dept.domain;

import java.util.List;

import com.like.dept.boundary.DeptDTO.SearchDept;
import com.like.dept.boundary.ResponseDeptHierarchy;

public interface DeptQueryRepository {

	List<Dept> getDeptList(SearchDept searchCondition);
	
	List<ResponseDeptHierarchy> getDeptHierarchy();
}
