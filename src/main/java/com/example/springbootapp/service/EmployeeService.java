package com.example.springbootapp.service;

import com.example.springbootapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);

    String save(Employee employee);
    String saveAll(List<Employee> employeeList);
    Employee updateEmployee(Employee newEmployee);
}
