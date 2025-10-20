package com.retail.project.employee.serviceimpl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;
import com.retail.project.employee.exception.DepartmentNotFoundException;
import com.retail.project.employee.exception.EmployeeNotFoundException;
import com.retail.project.employee.repository.DepartmentRepository;
import com.retail.project.employee.repository.EmployeeRepository;
import com.retail.project.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Employee save(Employee employee) {
		
		
//		  if (employee.getDepartment().getDepartmentId() != 0) {
//		        Department department = departmentRepository.findById(employee.getDepartment(3).get)
//		                .orElseThrow(() -> new DepartmentNotFoundException(
//		                        "Department not found with id " + request.getDepartmentId()));
//		        employee.setDepartment(department);
//		    }
//
//		    // Set manager if provided
//		    if (request.getManagerId() != null) {
//		        Employee manager = employeeRepository.findById(request.getManagerId())
//		                .orElseThrow(() -> new EmployeeNotFoundException(
//		                        "Manager not found with id " + request.getManagerId()));
//		        employee.setManager(manager);
//		    }
//
		   return employeeRepository.save(employee);	
	}

	@Override
	public Employee update(Employee updatedEmployee, int employeeId) {
		 Employee existingEmployee = employeeRepository.findById(employeeId)
		            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));

		 
		    if (updatedEmployee.getName() != null) existingEmployee.setName(updatedEmployee.getName());
		    if (updatedEmployee.getDob() != null) existingEmployee.setDob(updatedEmployee.getDob());
		    if (updatedEmployee.getSalary() != 0) existingEmployee.setSalary(updatedEmployee.getSalary());
		    if (updatedEmployee.getAddress() != null) existingEmployee.setAddress(updatedEmployee.getAddress());
		    if (updatedEmployee.getDepartment() != null) existingEmployee.setDepartment(updatedEmployee.getDepartment());
		    if (updatedEmployee.getRole() != null) existingEmployee.setRole(updatedEmployee.getRole());
		    if (updatedEmployee.getJoiningDate() != null) existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
		    if (updatedEmployee.getBonus() != null) existingEmployee.setBonus(updatedEmployee.getBonus());
		    if (updatedEmployee.getManager() != null) existingEmployee.setManager(updatedEmployee.getManager());

		    
		    return employeeRepository.save(existingEmployee);
	}

	@Override
	public Employee updateEmployeeDepartment(int id, int deptId) {
		Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        emp.setDepartment(dept);
        return employeeRepository.save(emp);
	}

	@Override 
	public Map<String,Object> findAllEmployeeNameId(int page,int size) {
		  PageRequest pageable = PageRequest.of(page, size);
		    Page<Employee> employeePage = employeeRepository.findAll(pageable);

		    List<Map<String, Object>> employeeList = new ArrayList<>();

		    for (Employee emp : employeePage.getContent()) {
		        Map<String, Object> map = new HashMap<>();
		        map.put("employeeId", emp.getEmployeeId());
		        map.put("employeeName", emp.getName());
		        employeeList.add(map);
		    }

		    Map<String, Object> response = new HashMap<>();
		    response.put("employees", employeeList);
		    response.put("currentPage", employeePage.getNumber());
		    response.put("totalItems", employeePage.getTotalElements());
		    response.put("totalPages", employeePage.getTotalPages());

		    return response;
	}

	@Override
	public Map<String ,Object> findAllEmployees(int page , int size) {
		    PageRequest pageable = PageRequest.of(page, size);
		    Page<Employee> employeePage = employeeRepository.findAll(pageable);

	        Map<String, Object> response = new HashMap<>();
	        response.put("page", employeePage.getNumber());
	        response.put("totalPages", employeePage.getTotalPages());
	        response.put("totalElements", employeePage.getTotalElements());
	        response.put("data", employeePage.getContent());
	        return response;
		
	}

}
