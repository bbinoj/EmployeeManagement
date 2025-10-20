package com.retail.project.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.retail.project.employee.entity.Employee;

public interface EmployeeService {

	 Employee save(Employee employee);

	Employee update(Employee employee, int employeeId);

	Employee updateEmployeeDepartment(int id, int deptId);

	Map<String, Object> findAllEmployeeNameId(int page, int size);

	Map<String, Object> findAllEmployees(int page,int size);

}
