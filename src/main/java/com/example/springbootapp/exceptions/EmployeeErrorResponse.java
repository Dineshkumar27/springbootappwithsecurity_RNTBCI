package com.example.springbootapp.exceptions;

import java.time.Instant;

public class EmployeeErrorResponse {

    private String message;
    private int errorValue;
    private Instant time;

    public EmployeeErrorResponse(String message, int errorValue, Instant time) {
        this.message = message;
        this.errorValue = errorValue;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(int errorValue) {
        this.errorValue = errorValue;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public EmployeeErrorResponse() {
    }
}
