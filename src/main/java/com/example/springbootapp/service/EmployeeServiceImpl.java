package com.example.springbootapp.service;

import com.example.springbootapp.dao.EmployeeRespository;
import com.example.springbootapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRespository employeeRespository;
    @Override
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRespository.findById(id).orElse(null);
    }

    @Override
    public String save(Employee employee) {
         employeeRespository.save(employee);
         return "Employee has been added with id "+employee.getId()+" successfully";
    }

    @Override
    public String saveAll(List<Employee> employeeList) {
         employeeRespository.saveAll(employeeList);
         return "added "+employeeList.size()+" employees Successfully";
    }


}
