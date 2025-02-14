package com.example.springbootapp.dao;

import com.example.springbootapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Integer> {

    // no need to type method as of now
}
