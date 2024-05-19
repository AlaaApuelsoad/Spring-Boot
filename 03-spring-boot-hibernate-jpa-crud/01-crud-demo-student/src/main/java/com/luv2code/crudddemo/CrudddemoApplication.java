package com.luv2code.crudddemo;

import com.luv2code.crudddemo.dao.StudentDAO;
import com.luv2code.crudddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudddemoApplication.class, args);
	}
	// executed after spring beans have loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			querySortByLastName(studentDAO);
//			queryByLastName(studentDAO);
//			queryOfLIke(studentDAO);
//			updateStudent(studentDAO);
//			updateAllStudents(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		System.out.println("updating all students...");
		int numOfRows = studentDAO.updateAll();
		System.out.println("number of rows: "+numOfRows);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numOfRows = studentDAO.deleteAll();
		System.out.println("number of deleted rows: "+numOfRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("deleting Student with id: "+studentId);
		studentDAO.deleteStudent(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change the name to scooby
		System.out.println("Updating student...");
		myStudent.setFirstNamed("scooby");

		//update the student
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Update student: "+ myStudent);
	}

	private void queryOfLIke(StudentDAO studentDAO) {
		List<Student> theStudent4 = studentDAO.findByLike();
		for (Student tempStudent : theStudent4){
			System.out.println(tempStudent);
		}
	}

	private void queryByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudent3 = studentDAO.findByLastName("yassen");
		//display the list
		for (Student tempStudent : theStudent3){
			System.out.println(tempStudent);
		}
	}

	private void querySortByLastName(StudentDAO studentDAO) {
		List<Student> theStudents2 = studentDAO.sortByLastName();
		for (Student tempStudent : theStudents2){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudnets = studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudnets){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student...");
		Student temstudent = new Student("Ahmed","Helmy","Ahmed@gmail.com");

		//save the student
		System.out.println("Saving student...");
		studentDAO.save(temstudent);

		//display id for the saved student
		int theId = temstudent.getId();
		System.out.println("student: "+temstudent.getFirstNamed()+", Generated id: "+theId);

		//retrieve student based on the id:primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Ali","mohamed","ali@gmail.com");
		Student tempStudent2 = new Student("mohamed","yassen","mohamed@gmail.com");
		Student tempStudent3 = new Student("ahmed","sayed","ahmed@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("mariam","Apuelsoad","mariam@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display the student object
		System.out.println("Student: "+tempStudent.getFirstNamed()+ " ,Generated id: "+tempStudent.getId());

	}

}
