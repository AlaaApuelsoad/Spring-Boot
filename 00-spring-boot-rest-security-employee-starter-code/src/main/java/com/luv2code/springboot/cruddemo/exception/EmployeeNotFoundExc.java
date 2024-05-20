package com.luv2code.springboot.cruddemo.exception;

public class EmployeeNotFoundExc extends RuntimeException{
    public EmployeeNotFoundExc(String message) {

        super(message);
    }

    public EmployeeNotFoundExc(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExc(Throwable cause) {
        super(cause);
    }
}
