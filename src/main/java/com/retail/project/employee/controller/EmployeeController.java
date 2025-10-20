package com.retail.project.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.project.employee.entity.Employee;
import com.retail.project.employee.response.ApiResponse;
import com.retail.project.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/find")
	public String check()
	{
		return "working";
	}

	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		Employee employeeAdded=employeeService.save(employee);
		return ResponseEntity.status(201).body(new ApiResponse("success"," Employee Created", employeeAdded));
	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		Employee existingEmployee=  employeeService.update(employee,id);
		return ResponseEntity.status(200).body(new ApiResponse("success"," Employee updated", existingEmployee));
	}
	
	@PatchMapping("/{id}/update/{deptId}")
	public ResponseEntity<?> updateEmployeeDepartment(@PathVariable int id, @PathVariable int deptId) {
		Employee existingEmployee=employeeService.updateEmployeeDepartment(id, deptId);
		return ResponseEntity.status(200).body(new ApiResponse("success"," Depratment updated for employee "+id, existingEmployee));
    }
	
	@GetMapping("/employees")
	public ResponseEntity<?> getEmployeesNameId(
			@RequestParam String lookup,
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size)
			
	{
		if("true".equals(lookup)) {
			return ResponseEntity.status(200).body(new ApiResponse( "success","Employee with name and id retrived",employeeService.findAllEmployeeNameId(page,size)));
			
		}
	    return ResponseEntity.status(400).body(new ApiResponse("Failed","Parameter not given",null));
	}
	
	@GetMapping("/allEmployees")
	public ResponseEntity<?> getAllemployees(
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size)
	{ 
		return ResponseEntity.status(200).body(new ApiResponse("success","All employees",employeeService.findAllEmployees(page,size)));
	}
	
	
}
