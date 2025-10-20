package com.retail.project.employee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;
import com.retail.project.employee.exception.DepartmentNotFoundException;
import com.retail.project.employee.response.ApiResponse;
import com.retail.project.employee.service.DepartmentService;
import com.retail.project.employee.service.EmployeeService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/add/dep")
	public ResponseEntity<ApiResponse> addDepartment(@RequestBody Department department)
	{
		
		Department departmentAdded=departmentService.save(department);
		 
		return ResponseEntity.status(201).body(
				new ApiResponse("created", "Department created  ", departmentAdded));
    }
	
	
	@DeleteMapping("/delete/dep/{depId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable int depId)
	{
		ApiResponse response= departmentService.deleteById(depId);
		
		if("error".equals(response.getStatus())) {
			return ResponseEntity.status(400).body(response);
		}
		return ResponseEntity.status(200).body(response);
	
	}
	
	@PatchMapping("/update/dep/{depId}")
	public ResponseEntity<?> updateDepartment(@PathVariable int depId,@RequestBody Department department)
	{
		Department updated= departmentService.update(depId,department);
		return ResponseEntity.status(200).body(
				new ApiResponse("Updated", "department is updated", updated));
	}
	
	
	@GetMapping("/{deptId}/employees")
	public ResponseEntity<?> getEmployeesByDepartment(@PathVariable int deptId,
			@RequestParam(required=false) String expand,
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
	   
	    Department department = departmentService.findById(deptId)
	            .orElseThrow(() -> new DepartmentNotFoundException("Department not found with ID: " + deptId));

	    if(expand.equals("employee")) {
	    Map<String, Object> employees =departmentService.findByDepartment(department,page,size);

	    return ResponseEntity.status(200).body(
	    		new ApiResponse("success", "Employees of department="+deptId, employees)
	    		);
	    }
	    return ResponseEntity.status(400).body(new ApiResponse("Failed","Parameter not given",null));
	}
	
	@GetMapping("/allDepartments")
	public ResponseEntity<?> getAllDepartments(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size)
	{
		return ResponseEntity.status(200).body(new ApiResponse("success","fetched all departments",departmentService.getAllDepartments(page,size)));
	}
}
