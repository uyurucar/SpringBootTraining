package com.ucaru.OneToManyDemo.dao;

import com.ucaru.OneToManyDemo.entity.Course;
import com.ucaru.OneToManyDemo.entity.Instructor;
import com.ucaru.OneToManyDemo.entity.InstructorDetail;
import com.ucaru.OneToManyDemo.entity.Student;

import java.util.List;

public interface AppDAO {

    public void save(Instructor instructor);
    public void save(InstructorDetail instructorDetail);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public void deleteCourseById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInsDetailById(int id);

    public List<Course> findCoursesByInsId(int id);

    public Course findCourseById(int id);

    public Instructor findInstructorByIDJoinFetch(int id);

    public void update(Instructor instructor);

    public void update(Course course);

    public void save(Course course);

    public Course findCourseAndReviewsByID(int id);

    public Course findCourseAndStudentsById(int id);

    public Student findStudentAndCoursesById(int id);

    public void update(Student student);

    public void deleteStudentById(int id);


}
