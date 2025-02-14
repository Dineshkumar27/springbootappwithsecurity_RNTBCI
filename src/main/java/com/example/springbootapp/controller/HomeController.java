package com.example.springbootapp.controller;

import com.example.springbootapp.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    List<Students> studentsList;
    @GetMapping("/hello")
    public String getHello(){
        return "Welcome to Spring Boot";
    }
    @PostConstruct
    public void initialize(){

        studentsList=new ArrayList<>();
        studentsList.add(new Students("Umesh","yadav"));
        studentsList.add(new Students("Rajesh","Kumar"));
        studentsList.add(new Students("Ramesh","Karan"));
    }

    @GetMapping("/students")
    public List<Students> getStudents(){


        return studentsList;
    }

    @GetMapping("/students/{studentId}")
    public Students getStudent(@PathVariable int studentId) throws StudentNotFoundException {

        if(studentId>studentsList.size()||studentId<0){
            throw new StudentNotFoundException("Student is not found with id"+studentId);
        }
        return studentsList.get(studentId);
    }


}
