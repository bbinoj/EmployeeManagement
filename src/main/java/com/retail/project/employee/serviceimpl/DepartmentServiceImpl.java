package com.retail.project.employee.serviceimpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;
import com.retail.project.employee.exception.DepartmentNotFoundException;
import com.retail.project.employee.exception.EmployeeNotFoundException;
import com.retail.project.employee.repository.DepartmentRepository;
import com.retail.project.employee.repository.EmployeeRepository;
import com.retail.project.employee.response.ApiResponse;
import com.retail.project.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
		
	}
	@Override
	public ApiResponse deleteById(int depId) {
		
		
		if(departmentRepository.existsById(depId)==false) {
			return new ApiResponse("error", "Department not found with Id "+depId,null);
		}
		
		Optional<Department> department=departmentRepository.findById(depId);
		int count=employeeRepository.countByDepartment(department);
		if(count>0) {
			return new ApiResponse("error","Department contains "+count+" employees cant delete",null);
		}
		
		departmentRepository.deleteById(depId);
		return new ApiResponse("success","Deleted the department with id"+depId,null);
				
	}
	
	@Override
	public Department update(int depId, Department department) {
		
		 Department existingDepartment = departmentRepository.findById(depId)
		            .orElseThrow(() -> new DepartmentNotFoundException("Department not found with ID: " + depId));

		 
		    if (department.getName() != null) existingDepartment.setName(department.getName());
		    if (department.getCreationDate() != null) existingDepartment.setCreationDate(department.getCreationDate());
		    if (department.getDepartmentHead() != null) existingDepartment.setDepartmentHead(department.getDepartmentHead());
		   
		    
		   return departmentRepository.save(existingDepartment);
	
		
	}
	@Override
	public Optional<Department> findById(int deptId) {
		
		return departmentRepository.findById(deptId);
	}
	@Override
	public Map<String, Object> findByDepartment(Department department, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
	    Page<Employee> employeePage = employeeRepository.findByDepartment(department, pageable); 

	    Map<String, Object> response = new HashMap<>();
	    response.put("page", employeePage.getNumber());
	    response.put("totalPages", employeePage.getTotalPages());
	    response.put("totalElements", employeePage.getTotalElements());
	    response.put("data", employeePage.getContent());

	    return response;
	}
	@Override
	public Map<String, Object> getAllDepartments(
			int page,int size) {
		 PageRequest pageable = PageRequest.of(page, size);
		 Page<Department> departmentPage = departmentRepository.findAll(pageable);
		 
		 Map<String, Object> response = new HashMap<>();
		    response.put("page", departmentPage.getNumber());
		    response.put("totalPages", departmentPage.getTotalPages());
		    response.put("totalElements", departmentPage.getTotalElements());
		    response.put("data", departmentPage.getContent());
		    
		    return response;
		 
	}
	
	
}
	


