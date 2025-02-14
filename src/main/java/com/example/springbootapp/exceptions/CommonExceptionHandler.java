package com.example.springbootapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){

        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();

        studentErrorResponse.setErrorValue(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTime(Instant.now());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> generalException(Exception exception){

        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();

        studentErrorResponse.setErrorValue(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTime(Instant.now());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeException(EmployeeNotFoundException exception){

        EmployeeErrorResponse error=new EmployeeErrorResponse();

        error.setErrorValue(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTime(Instant.now());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
}
