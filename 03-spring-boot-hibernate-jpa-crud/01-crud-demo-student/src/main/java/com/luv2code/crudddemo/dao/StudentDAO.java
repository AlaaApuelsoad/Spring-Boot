package com.luv2code.crudddemo.dao;

import com.luv2code.crudddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    //method sort student orderBy last name
    List<Student> sortByLastName();

    //method to find a student by last name
    List<Student> findByLastName(String theLastName);

    List<Student> findByLike();

    //update student information
    void update(Student theStudent);

    //update all students
    int updateAll();

    // delete student method
    void deleteStudent(Integer id);

    //delete all students in the database
    int deleteAll();
}
