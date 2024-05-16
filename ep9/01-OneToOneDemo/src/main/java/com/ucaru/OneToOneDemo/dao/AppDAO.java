package com.ucaru.OneToOneDemo.dao;

import com.ucaru.OneToOneDemo.entity.Instructor;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);
}
