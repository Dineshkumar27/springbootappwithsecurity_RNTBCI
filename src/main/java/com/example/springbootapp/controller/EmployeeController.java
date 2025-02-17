package com.example.springbootapp.controller;

import com.example.springbootapp.entity.Employee;
import com.example.springbootapp.exceptions.EmployeeNotFoundException;
import com.example.springbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException{
        Employee employee=employeeService.findById(id);
        if(employee!=null){
            return employee;
        }else{
            throw new EmployeeNotFoundException("Employee with "+id+" is not found");
        }
    }

    //adding employee to database
    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }
    @PostMapping("/allemployees")
    public String addEmployees(@RequestBody List<Employee> employeeList){

        return employeeService.saveAll(employeeList);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee){

        employeeService.save(newEmployee);
        return newEmployee;

    }


}
