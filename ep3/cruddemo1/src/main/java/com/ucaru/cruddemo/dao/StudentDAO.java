package com.ucaru.cruddemo.dao;

import com.ucaru.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void update(Student student);

    public void updateId(Integer oldID, Integer newID);

    public void delete(Integer id);

    public int deleteAll();
}
