package com.luv2code.springboot.crudemployeedemo.service;

import com.luv2code.springboot.crudemployeedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> finaAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
