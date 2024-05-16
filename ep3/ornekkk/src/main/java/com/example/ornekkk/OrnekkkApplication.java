package com.example.ornekkk;

import com.example.ornekkk.dao.StudentDao;
import com.example.ornekkk.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrnekkkApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrnekkkApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao dao)
	{
		return (args) -> {
			System.out.println("hello");
			createAndSave(dao);
		};
	}

	public void createAndSave(StudentDao dao) {
		Student student = new Student("ucar","ugur","eben");
		dao.save(student);
		System.out.println(student.getId());

	}
}
