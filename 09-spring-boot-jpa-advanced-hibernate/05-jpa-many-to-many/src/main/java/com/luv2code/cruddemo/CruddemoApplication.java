package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){

		return runner -> {
			//deleteCourse(appDAO);
			//createCourseAndStudent(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCoursesToStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting student with id: "+theId);
		appDAO.deleteStudent(theId);

	}

	private void addMoreCoursesToStudent(AppDAO appDAO) {

		int theId = 1;
		Student tempStudent = appDAO.findStudentsAndCourseByStudentId(theId);

		Course tempCourse1 = new Course("Data Structure");
		tempStudent.addCourse(tempCourse1);

		System.out.println("Saving student: "+tempStudent);
		System.out.println("associated course: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
	}

	private void findStudentAndCourse(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding Student with id: "+theId);
		Student tempStudent = appDAO.findStudentsAndCourseByStudentId(theId);
		System.out.println("Student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseStudentByCourseId(theId);
		System.out.println("Loaded course: "+tempCourse);
		System.out.println("students: "+tempCourse.getStudents());

	}

	private void createCourseAndStudent(AppDAO appDAO) {

		//create course
		Course temCourse = new Course("Computer science");

		//create student
		Student tempStudent1 = new Student("Alaa","Apuelsoad","alaa@gmail.com");

		//add course to student
		tempStudent1.addCourse(temCourse);

		//save the student
		appDAO.saveStudent(tempStudent1);
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;
		System.out.println("deleting course with Id: "+theId);

		appDAO.deleteCourse(theId);

		System.out.println("Done");
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());


	}

	private void createCourseAndReview(AppDAO appDAO) {

		//create a course
		Course tempCourse = new Course("Pacman");
		//add review
		tempCourse.addReview(new Review("Great course"));
		tempCourse.addReview(new Review("cool course"));
		tempCourse.addReview(new Review("bad course"));

		//save the course... also it will save the reviews CascadeType.All
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: "+theId);
		appDAO.deleteCourse(theId);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("deleting instructor id: "+theId);

		appDAO.deleteInstructor(theId);

	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 11;
		System.out.println("Finding course id:" +theId);

		Course tempCourse = appDAO.findCourseById(theId);
		System.out.println("Updating course with id:" +theId);

		tempCourse.setTitle("Enjoy the simple things");
		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("updating instructor id: "+theId);

		tempInstructor.setFirstName("Tester");
		appDAO.update(tempInstructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);

		//find courses for instructor
		System.out.println("Finding course for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the objects
		//tempInstructor.setCourses(courses);
		System.out.println("the associated courses : "+courses);

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		//find instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor temInstructor = new Instructor("Susan","public","susan.public@luv2code.com");

		InstructorDetail temInstructorDetail = new InstructorDetail("www.youtube.com","video Games");

		temInstructor.setInstructorDetail(temInstructorDetail);

		//create some course
		Course temCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course temCourse2 = new Course("The Pinball Masterclass");

		temInstructor.add(temCourse1);
		temInstructor.add(temCourse2);

		System.out.println("Saving instructor: "+temInstructor);
		System.out.println("The courses: "+temInstructor.getCourses());
		appDAO.save(temInstructor);

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("deleting instructor detail with id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor Detail with id: "+theId);
		InstructorDetail temInstructorDetail= appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Detail: " +temInstructorDetail);
		System.out.println("the associated instructor: " +temInstructorDetail.getInstructor());

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only : "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor temInstructor = new Instructor("Chad","Darby","darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"Luv 2 Code");

		//associate the object
		temInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//Note: this will also save the detail object
		//because of CascadeType.All
		System.out.println("saving instructor: "+temInstructor);
		appDAO.save(temInstructor);

	}

}
