package com.like.hrm.appointmentcode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.commoncode.domain.repository.CommonCodeQueryRepository;
import com.like.hrm.appointment.boundary.ChangeableCodeDTO;
import com.like.hrm.appointmentcode.boundary.AppointmentCodeDTO;
import com.like.hrm.appointmentcode.boundary.AppointmentCodeDTO.SearchCodeDetail;
import com.like.hrm.appointmentcode.domain.AppointmentCode;
import com.like.hrm.appointmentcode.domain.AppointmentCodeDetail;
import com.like.hrm.appointmentcode.domain.AppointmentCodeQueryRepository;
import com.like.hrm.code.domain.model.enums.HrmTypeEnum;

@Service
@Transactional(readOnly = true)
public class AppointmentCodeQueryService {
	
	private AppointmentCodeQueryRepository repository;
	
	private CommonCodeQueryRepository codeQueryRepository;
		
	public AppointmentCodeQueryService(AppointmentCodeQueryRepository repository
			                          ,CommonCodeQueryRepository codeQueryRepository) {
		this.repository = repository;
		this.codeQueryRepository = codeQueryRepository;
	}	
	
	public List<AppointmentCode> getAppointentCodeList(AppointmentCodeDTO.SearchCode search) {
		return repository.getAppointmentCodeList(search);
	}
	
	public List<AppointmentCodeDetail> getAppointmentCodeDetailList(SearchCodeDetail dto) {
		return repository.getAppointmentCodeDetailList(dto);
	}
	
	public List<ChangeableCodeDTO.EnumDTO> getChangeableCodeDTO(HrmTypeEnum type) {
		return this.codeQueryRepository.getCodeList(type.getParentCommonCodeId())
									 .stream()
									 .map( r -> ChangeableCodeDTO.EnumDTO.builder().code(r.getCode()).name(r.getCodeName()).build())
									 .collect(Collectors.toList());
	}
		
}
