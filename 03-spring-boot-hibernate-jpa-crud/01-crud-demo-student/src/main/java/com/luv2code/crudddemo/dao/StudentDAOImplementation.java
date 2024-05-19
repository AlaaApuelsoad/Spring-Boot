package com.luv2code.crudddemo.dao;

import com.luv2code.crudddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement save method
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //implement retrieve method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    //implement retrieve student method
    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> sortByLastName() {
        TypedQuery<Student> theQuery1 = entityManager.createQuery("FROM Student order by lastName",Student.class);
        return theQuery1.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery3 = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData",Student.class);
        //set query parameters place holder
        theQuery3.setParameter("theData",theLastName);
        //return query results
        return theQuery3.getResultList();
    }

    @Override
    public List<Student> findByLike() {
        //create Query
        TypedQuery<Student> theQuery4 = entityManager.createQuery(
                "FROM Student where email like '%.com'",Student.class);
        //return query result
        return theQuery4.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateAll() {
        int numOfRow = entityManager.createQuery("update Student set lastName='tester'").executeUpdate();
        return numOfRow;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        //retrieve the student
        Student thestudent = entityManager.find(Student.class,id);
        //remove the student
        entityManager.remove(thestudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        //method return number of rows we delete
        int numRowDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowDeleted;
    }


}
