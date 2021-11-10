package com.like.cooperation.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.like.cooperation.todo.domain.QTaskGroup;
import com.like.cooperation.todo.domain.TaskGroup;
import com.like.cooperation.todo.domain.TaskGroupRepository;

@Service
@Transactional(readOnly=true)
public class TaskQueryService {
	
	private TaskGroupRepository repository;
	
	public TaskQueryService(TaskGroupRepository repository) {
		this.repository = repository;
	}
			
	public List<TaskGroup> getTaskGroupList(String userId) {
		QTaskGroup qTaskGroup = QTaskGroup.taskGroup;
		
		return Lists.newArrayList(repository.findAll(qTaskGroup.createdBy.eq(userId)));
	}
		
}
