package com.retail.project.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.project.employee.entity.Department;
import com.retail.project.employee.entity.Employee;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
	
}
