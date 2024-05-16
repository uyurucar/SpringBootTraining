package com.ucaru.cruddemo;

import com.ucaru.cruddemo.dao.StudentDAO;
import com.ucaru.cruddemo.entity.Student;
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
	CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			System.out.println("hello");
			createStudent(studentDAO);
			//findStudent(studentDAO);
			//queryStudents(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
			updateID(studentDAO);
		};
	}

	private void updateID(StudentDAO studentDAO) {
		studentDAO.updateId(2,18);
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("deleting all data");
		int deletedStudent;
		deletedStudent =studentDAO.deleteAll();
		System.out.println("deleted: "+deletedStudent + " rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		System.out.println("deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student
		int studentId = 4;
		System.out.println("retrieving student id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name
		System.out.println("update student");
		myStudent.setFirstName("jacob");
		studentDAO.update(myStudent);
		//display updated student
		System.out.println("updated student: " + myStudent);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		//create student with different lastname
			//Student aStudent = new Student("mahmut","orhan","orhan@gmail.com");
			//studentDAO.save(aStudent);
		//find students
		List<Student> students = studentDAO.findByLastName("orhan");
		//display found students
		for (var student: students) {
			System.out.println(student.toString());
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> students = studentDAO.findAll();
		//display students
		for (var student: students) {
			System.out.println(student.toString());
		}
	}

	public void createStudent(StudentDAO studentDAO)
	{
		// create the student
		Student student = new Student("jacob","jason","jj@ucaru.com");
		System.out.println("new student");
		//save student
		studentDAO.save(student);
		//display id of the student
		System.out.println("save student. id: " + student.getId());
	}

	public void findStudent(StudentDAO studentDAO)
	{
		// create the student
		Student student = new Student("jacob","jason","jj@ucaru.com");
		System.out.println("new student");
		//save student
		studentDAO.save(student);
		//display id of the student
		System.out.println("save student. id: " + student.getId());
		//find student
		Student foundStudent = studentDAO.findById(student.getId());
		//display found student
		System.out.println("found student, id: " + foundStudent.getId());
	}
}
