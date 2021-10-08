package com.like.hrm.staff.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.core.vo.DatePeriod;
import com.like.hrm.employee.domain.model.dept.DeptChangeHistory;
import com.like.hrm.employee.domain.model.job.JobChangeHistory;
import com.like.hrm.employee.domain.model.status.StatusChangeHistory;
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
	
	public Staff getEmployee(String id) {
		return repository.findById(id).orElse(null);
	}
	
	public void saveEmployee(Staff employee) {				
		repository.save(employee);
	}
	
	public void saveEmployee(StaffDTO.SaveEmployee dto) {
		Staff employee = this.getEmployee(dto.getId());
		
		dto.modifyEntity(employee);
		
		repository.save(employee);
	}
	
	public void newEmployee(StaffDTO.NewEmployee dto) {										
		
		Staff emp = new Staff("test"
				                   ,dto.getName()
				                   ,dto.getNameEng()
				                   ,dto.getNameChi()
				                   ,dto.getResidentRegistrationNumber());
		
		repository.save(emp);
	}
	
	public void deleteEmployee(String id) {		
		repository.deleteById(id);
	}
	
	public void saveDeptChangeHistory(StaffDTO.NewDept dto) {
		Staff emp = findEmployee(dto.getEmployeeId());
						
		DeptChangeHistory deptChangeHistory = new DeptChangeHistory(emp
																   ,dto.getDeptType()
																   ,dto.getDeptCode()
																   ,new DatePeriod(dto.getFromDate(),dto.getToDate()));
				
		//emp.getDeptHistory().add(deptChangeHistory);
		
		repository.save(emp);
	}
	
	public void saveJobChangeHistory(StaffDTO.NewJob dto) {
		Staff emp = findEmployee(dto.getEmployeeId());			
		
		JobChangeHistory jobChangeHistory = new JobChangeHistory(emp
																,dto.getJobType()
																,dto.getJobCode()
																,new DatePeriod(dto.getFromDate(),dto.getToDate()));
		//emp.getJobHistory().add(jobChangeHistory);
		
		repository.save(emp);
	}
	
	public void saveStatusChangeHistory(StaffDTO.NewStatus dto) {
		Staff emp = findEmployee(dto.getEmployeeId());
		
		StatusChangeHistory statusChangeHistory = new StatusChangeHistory(emp
																		 ,dto.getAppointmentCode()
																		 ,dto.getStatusCode()
																		 ,new DatePeriod(dto.getFromDate(),dto.getToDate())); 			
		//emp.getStatusHistory().add(statusChangeHistory);
		
		repository.save(emp);
	}	
	
	private Staff findEmployee(String empId) {
		return repository.findById(empId).orElseThrow(() -> new EntityNotFoundException(empId + " 사번이 존재하지 않습니다."));
	}
}
