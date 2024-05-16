package com.example.training;

import com.example.training.dao.StudentDAO;
import com.example.training.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO dao)
	{
		return runner ->
		{
			//createStudent(dao);
			//deleteStudent(dao);
			//retrieveRecords(dao);
			changeLastName(dao);
		};
	}

	private void changeLastName(StudentDAO dao) {
		int rumsAffected = dao.newLastName("mahmud", "jason");
		System.out.println("#### "+rumsAffected + " entries affected ####");
		List<Student> newList = dao.getAll();
		for (var student: newList
			 ) {
			System.out.println(student.toString());
		}
	}

	private void retrieveRecords(StudentDAO dao) {
		List<Student> students = dao.getAll();
		for(var student : students) System.out.println(student.toString());

		List<Student> studentsByLName = dao.findByLastName("jason");
		System.out.println("#### last name: jason ####");
		if(!studentsByLName.isEmpty())
		{
			for (var student: studentsByLName) {
				System.out.println(student);
			}
		}
	}

	private void deleteStudent(StudentDAO dao) {

		Student student = dao.findById(20);
		System.out.println("found student: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("delete student");
		dao.deleteById(student.getId());
		System.out.println("...done...");

	}

	public void createStudent(StudentDAO dao)
	{
		Student student = new Student("new_email@gmail.com", "ogulcan","portakal");
		dao.save(student);
	}
}
