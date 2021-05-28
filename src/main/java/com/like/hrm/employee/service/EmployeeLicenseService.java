package com.like.hrm.employee.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.employee.boundary.EmployeeDTO;
import com.like.hrm.employee.domain.model.Employee;
import com.like.hrm.employee.domain.model.license.License;
import com.like.hrm.employee.domain.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeLicenseService {

	private EmployeeRepository repository;
	
	public EmployeeLicenseService(EmployeeRepository repository) {
		this.repository = repository;	
	}
	
	public License getLicense(String empId, Long id) {
		Employee emp = getEmployeeInfo(empId);
						
		return emp.getLicenseList().get(id);
	}
	
	public void saveLicense(EmployeeDTO.SaveLicense dto) {
		Employee emp = getEmployeeInfo(dto.getEmployeeId());
		
		License license = emp.getLicenseList().get(dto.getLicenseId());
		
		if (license == null) {
			license = dto.newEntity(emp);
		} else {
			dto.modifyEntity(license);
		}
		
		emp.getLicenseList().add(license);
		
		repository.save(emp);
	}	
	
	private Employee getEmployeeInfo(String empId) {
		return repository.findById(empId)
				 .orElseThrow(() -> new EntityNotFoundException(empId + " 사번이 존재하지 않습니다."));
	}
}
