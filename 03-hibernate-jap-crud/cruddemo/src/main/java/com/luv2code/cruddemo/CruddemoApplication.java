package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO){
		// create a student object
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.come");

		// save the student
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved Student, Generated id:" + theId);

		Student myStudent = studentDAO.findyById(theId);
		System.out.println("Found the student"+ myStudent);
	}

	private void createStudent(StudentDAO studentDAO){
		// create the student object
		// save the student object
		// display the id of the saved student

		System.out.println("Creating new student object...");

		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		System.out.println("Saving the Student");

		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+ tempStudent.getId());

	}

	public void queryForStudents(StudentDAO studentDAO){
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student student : theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		int studentId = 1;

		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findyById(studentId);

		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Updated student: "+ myStudent);


	}

	public void deleteStudent(StudentDAO studentDAO){
		int studentId = 3 ;
		studentDAO.delete(studentId);
	}




}
