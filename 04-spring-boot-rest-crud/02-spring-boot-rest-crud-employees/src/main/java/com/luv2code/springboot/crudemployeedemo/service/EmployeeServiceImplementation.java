package com.luv2code.springboot.crudemployeedemo.service;

import com.luv2code.springboot.crudemployeedemo.dao.EmployeeDAO;
import com.luv2code.springboot.crudemployeedemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    //define EmployeeDAO
    private EmployeeDAO employeeDAO;

    //inject EmployeeDAO by constructor injection
    @Autowired
    public EmployeeServiceImplementation(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> finaAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
