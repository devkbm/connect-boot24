package com.like.workschedule.domain;

import java.util.List;

import com.like.workschedule.boundary.ScheduleDTO;

public interface ScheduleQueryRepository {

	public List<Schedule> getScheduleList(ScheduleDTO.SearchSchedule searchCondition);
}
