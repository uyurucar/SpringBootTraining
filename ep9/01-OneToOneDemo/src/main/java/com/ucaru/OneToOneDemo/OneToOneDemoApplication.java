package com.ucaru.OneToOneDemo;

import com.ucaru.OneToOneDemo.dao.AppDAO;
import com.ucaru.OneToOneDemo.entity.Instructor;
import com.ucaru.OneToOneDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao)
	{
		return runner ->
		{
			//createInstructor(dao);
			//findInstructorById(dao);
			deleteInstructorByID(dao);
		};
	}

	private void deleteInstructorByID(AppDAO dao) {
		int id = 1;
		dao.deleteInstructorById(id);
		System.out.println("eof");
	}

	private void findInstructorById(AppDAO dao) {
		Instructor instructor = dao.findInstructorById(1);

		System.out.println("instructor: " + instructor);

		System.out.println("details: " + instructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO dao) {

		//create instructor
		Instructor tempInstructor = new Instructor("Ugur","Kacar","kucaru1@gmail.com");

		//create instructorDetail
		InstructorDetail tempDetail = new InstructorDetail("memur","baglama");

		tempInstructor.setInstructorDetail(tempDetail);

		System.out.println(tempInstructor);

		dao.save(tempInstructor);

	}

}
