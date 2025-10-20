package com.retail.project.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.retail.project.employee.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ApiResponse> handleDepartmentNotFound(DepartmentNotFoundException ex) {
        return ResponseEntity.status(404).body(
            new ApiResponse("error", ex.getMessage(), null)
        );
    }
    
    
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(404).body(
            new ApiResponse("error", ex.getMessage(), null)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(500).body(
            new ApiResponse("error", "Internal server error", null)
        );
    }

}
