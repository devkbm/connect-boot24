package com.like.hrm.staff.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.boundary.StaffDTO;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.domain.model.license.License;
import com.like.hrm.staff.domain.repository.StaffRepository;

@Transactional
@Service
public class StaffLicenseService {

	private StaffRepository repository;
	
	public StaffLicenseService(StaffRepository repository) {
		this.repository = repository;	
	}
	
	public License getLicense(String empId, Long id) {
		Staff emp = getEmployeeInfo(empId);
						
		return emp.getLicenseList().get(id);
	}
	
	public void saveLicense(StaffDTO.SaveLicense dto) {
		Staff emp = getEmployeeInfo(dto.getStaffId());
		
		License license = emp.getLicenseList().get(dto.getLicenseId());
		
		if (license == null) {
			license = dto.newEntity(emp);
		} else {
			dto.modifyEntity(license);
		}
		
		emp.getLicenseList().add(license);
		
		repository.save(emp);
	}	
	
	private Staff getEmployeeInfo(String empId) {
		return repository.findById(empId)
				 .orElseThrow(() -> new EntityNotFoundException(empId + " 사번이 존재하지 않습니다."));
	}
}