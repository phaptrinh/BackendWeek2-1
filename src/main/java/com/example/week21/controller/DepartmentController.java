package com.example.week21.controller;

import com.example.week21.entity.Department;
import com.example.week21.payload.BaseResponse;
import com.example.week21.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(BaseResponse.success(departmentService.getAllDepartments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        if (department.isPresent()) {
            return new ResponseEntity<>(BaseResponse.success(department), HttpStatus.OK);
        }
        return new ResponseEntity<>(BaseResponse.error("Not found department with id = " + id), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(BaseResponse.success(departmentService.createDepartment(department)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) {
        try {
            departmentService.deleteDepartmentById(id);
            return new ResponseEntity<>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponse.error("Not found department with id = " + id), HttpStatus.NOT_FOUND);
        }
    }
}
