package com.luv2code.crudddemo.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

//mapping entity class with database table
@Entity
@Table(name = "student")
public class Student {
    //define field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    //define constructor
    public Student(){

    }
    @Autowired
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getters/setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNamed() {
        return firstName;
    }

    public void setFirstNamed(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamed() {
        return lastName;
    }

    public void setLastNamed(String lastNamed) {
        this.lastName = lastNamed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //define toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
