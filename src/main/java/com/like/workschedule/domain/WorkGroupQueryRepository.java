package com.like.workschedule.domain;

import java.util.List;

import com.like.workschedule.boundary.WorkDTO;

public interface WorkGroupQueryRepository {

	public List<WorkGroup> getWorkGroupList(WorkDTO.SearchWorkGroup searchCondition);
	
	public List<WorkGroup> getWorkGroupList(String userId);
}
