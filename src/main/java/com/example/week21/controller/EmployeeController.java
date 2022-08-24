package com.example.week21.controller;

import com.example.week21.payload.dto.EmployeeDto;
import com.example.week21.payload.BaseResponse;
import com.example.week21.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {

        return ResponseEntity.ok(BaseResponse.success(employeeService.getAllEmployees()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            EmployeeDto result = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(BaseResponse.success(result), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error("Not found employee with id = " + id), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            EmployeeDto result = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(BaseResponse.success(result), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error("Not found department with id = " + employeeDto.getDepartmentId()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error("Not found employee with id = " + id), HttpStatus.NOT_FOUND);
        }
    }

}
