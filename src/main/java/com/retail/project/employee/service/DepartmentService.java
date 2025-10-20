package com.retail.project.employee.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;
import com.retail.project.employee.response.ApiResponse;

public interface DepartmentService {

	Department save(Department department);

	ApiResponse deleteById(int depId);

	Department update(int depId, Department department);

	Optional<Department> findById(int deptId);

	Map<String, Object> findByDepartment(Department department, int page, int size);

	Map<String,Object> getAllDepartments(int page, int size);

	

}
