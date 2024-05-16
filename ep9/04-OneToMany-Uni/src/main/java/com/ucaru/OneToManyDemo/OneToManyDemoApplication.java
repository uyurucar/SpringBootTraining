package com.ucaru.OneToManyDemo;

import com.ucaru.OneToManyDemo.dao.AppDAO;
import com.ucaru.OneToManyDemo.entity.Course;
import com.ucaru.OneToManyDemo.entity.Instructor;
import com.ucaru.OneToManyDemo.entity.InstructorDetail;
import com.ucaru.OneToManyDemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@SpringBootApplication
public class OneToManyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO dao)
	{
		return runner ->
		{
			//createCourseAndReviews(dao);
			//getCourseAndReviews(dao);
			//deleteCourseAndReviews(dao);
		};
	}

	private void deleteCourseAndReviews(AppDAO dao) {

		int id = 10;
		dao.deleteCourseById(id);
	}

	private void getCourseAndReviews(AppDAO dao) {

		//get course
		int id = 10;

		Course course = dao.findCourseAndReviewsByID(id);
		//print
		System.out.println(course);
		System.out.println(course.getReviews());

	}

	private void createCourseAndReviews(AppDAO dao) {
		Course course = new Course("MAT212");
		course.add(new Review("YES"));
		course.add(new Review("no"));
		course.add(new Review("okey"));

		dao.save(course);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void deleteCourseById(AppDAO dao) {
		int id = 10;
		dao.deleteCourseById(id);
	}

	private void updateInstructor(AppDAO dao) {

		int id = 1;
		Instructor instructor = dao.findInstructorById(id);

		instructor.setLastName("TEST");

		dao.update(instructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO dao) {

		int id = 11;
		Instructor instructor = dao.findInstructorByIDJoinFetch(id);

		System.out.println("instructor: " + instructor);
		System.out.println("courses: " + instructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO dao) {
		int id = 11;
		Instructor instructor = dao.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		//will throw an error if fetch type is lazy (it is by default)
		//System.out.println("courses: " + instructor.getCourses());
		List<Course> courseList = dao.findCoursesByInsId(id);
		instructor.setCourses(courseList);
		System.out.println("courses: "+ instructor.getCourses());

	}

	private void createInstrAndCourse(AppDAO dao){

		//create instructor
		Instructor tempInstructor = new Instructor("Ugur","Kudur","kucaru1@gmail.com");

		//create instructorDetail
		InstructorDetail tempDetail = new InstructorDetail("memur","baglama");

		tempInstructor.setInstructorDetail(tempDetail);

		//update existing courses
		Course tempCourse1 = dao.findCourseById(10);
		Course tempCourse2 = dao.findCourseById(11);

		//add courses to instructor

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save instructor
		dao.update(tempInstructor);
		System.out.println("save");

		System.out.println(tempInstructor.getCourses());

	}

	private void deleteInsDetailById(AppDAO dao) {
		int id = 4;
		dao.deleteInsDetailById(id);
		System.out.println("eof");
	}

	private void findInsDetailById(AppDAO dao) {

		int id=3;
		InstructorDetail detail;
		detail = dao.findInstructorDetailById(id);

		System.out.println(detail.getInstructor());

	}

	private void deleteInstructorByID(AppDAO dao) {
		int id = 11;
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
