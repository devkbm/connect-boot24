package com.like.hrm.employee.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.employee.boundary.EmployeeDTO;
import com.like.hrm.employee.domain.model.Employee;
import com.like.hrm.employee.domain.model.SchoolCareer;
import com.like.hrm.employee.domain.repository.EmployeeRepository;


@Transactional
@Service
public class EmployeeSchoolCareerService {

	private EmployeeRepository repository;
				
	public EmployeeSchoolCareerService(EmployeeRepository repository) {
		this.repository = repository;	
	}
	
	public SchoolCareer getSchoolCareer(String empId, Long id) {
		Employee emp = getEmployeeInfo(empId);
		
		return emp.getSchoolCareerList().get(id);
	}
	
	public void saveSchoolCareer(EmployeeDTO.SaveEducation dto) {
		Employee emp = getEmployeeInfo(dto.getEmployeeId());
		
		SchoolCareer education = emp.getSchoolCareerList().get(dto.getEducationId());
		
		if (education == null) {
			education = dto.newEntity(emp);
		} else {
			dto.modifyEnity(education);
		}
		
		emp.getSchoolCareerList().add(education);
		
		repository.save(emp);
	}
	
	private Employee getEmployeeInfo(String empId) {
		return repository.findById(empId)
				 .orElseThrow(() -> new EntityNotFoundException(empId + " 사번이 존재하지 않습니다."));
	}
}
