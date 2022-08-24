package com.example.week21.service;

import com.example.week21.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(Department departmentDto);

    List<Department> getAllDepartments();

    Optional<Department> getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
