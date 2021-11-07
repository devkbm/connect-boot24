package com.like.workschedule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.workschedule.boundary.ScheduleDTO;
import com.like.workschedule.domain.Schedule;
import com.like.workschedule.domain.ScheduleQueryRepository;

@Service
@Transactional(readOnly=true)
public class ScheduleQueryService {

	private ScheduleQueryRepository repository;
	
	public ScheduleQueryService(ScheduleQueryRepository repository) {
		this.repository = repository;
	}
	
	public List<Schedule> getScheduleList(ScheduleDTO.SearchSchedule searchCondition) {
		return repository.getScheduleList(searchCondition);		
	}
}
