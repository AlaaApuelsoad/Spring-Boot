package com.luv2code.springboot.crudemployeedemo.dao;

import com.luv2code.springboot.crudemployeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{


    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get the employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbemployee = entityManager.merge(theEmployee);
        return dbemployee;
    }

    @Override
    public void deleteById(int theId) {
        //find employee by id
        Employee deletedEmployee = entityManager.find(Employee.class,theId);
        //remove employee
        entityManager.remove(deletedEmployee);
    }
}
