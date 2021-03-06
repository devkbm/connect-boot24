package com.like.hrm.staff.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.boundary.StaffDTO;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.domain.repository.StaffRepository;

@Service
@Transactional
public class StaffService {
	
	private StaffRepository repository;	
		
	public StaffService(StaffRepository repository) {
		this.repository = repository;
	}	
	
	public Staff getStaff(String id) {
		return repository.findById(id).orElse(null);
	}
	
	public void saveStaff(Staff employee) {				
		repository.save(employee);
	}
	
	public void saveStaff(StaffDTO.FormEmployee dto) {
		Staff employee = this.getStaff(dto.getStaffId());
		
		dto.modifyEntity(employee);
		
		repository.save(employee);
	}
	
	public void newEmployee(StaffDTO.NewEmployee dto) {										
		
		Staff emp = new Staff(dto.getStaffId()
			                 ,dto.getName()
			                 ,dto.getNameEng()
			                 ,dto.getNameChi()
			                 ,dto.getResidentRegistrationNumber());
		
		repository.save(emp);
	}
	
	public void deleteStaff(String id) {		
		repository.deleteById(id);
	}
		
	
	private Staff findStaff(String empId) {
		return repository.findById(empId).orElseThrow(() -> new EntityNotFoundException(empId + " 사번이 존재하지 않습니다."));
	}
}
