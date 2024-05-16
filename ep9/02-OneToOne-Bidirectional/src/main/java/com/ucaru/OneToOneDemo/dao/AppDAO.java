package com.ucaru.OneToOneDemo.dao;

import com.ucaru.OneToOneDemo.entity.Instructor;
import com.ucaru.OneToOneDemo.entity.InstructorDetail;

public interface AppDAO {

    public void save(Instructor instructor);

    public void update(Instructor instructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInsDetailById(int id);
}
