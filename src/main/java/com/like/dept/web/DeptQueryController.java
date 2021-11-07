package com.like.dept.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebControllerUtil;
import com.like.dept.boundary.DeptDTO;
import com.like.dept.boundary.ResponseDeptHierarchy;
import com.like.dept.domain.Dept;
import com.like.dept.service.DeptQueryService;

@RestController
public class DeptQueryController {

	private DeptQueryService service;
	
	public DeptQueryController(DeptQueryService service) {
		this.service = service;
	}
	
	@GetMapping("/api/common/depttree")
	public ResponseEntity<?> getDeptHierarchyList(@ModelAttribute DeptDTO.SearchDept searchCondition) {
							
		List<ResponseDeptHierarchy> list = service.getDeptHierarchyList();  						 						
		
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
	
	@GetMapping("/api/common/dept")
	public ResponseEntity<?> getDeptList(@ModelAttribute DeptDTO.SearchDept searchCondition) {
							
		List<Dept> list = service.getDeptList(searchCondition);  						 						
		
		return WebControllerUtil.getResponse(list											
											,String.format("%d 건 조회되었습니다.", list.size())
											,HttpStatus.OK);
	}
}
