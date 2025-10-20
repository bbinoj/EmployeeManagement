package com.retail.project.employee.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Page<Employee> findByDepartment(Department department, Pageable pageable);

	int countByDepartment(Optional<Department> department);

	 }
