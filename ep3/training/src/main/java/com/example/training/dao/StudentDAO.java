package com.example.training.dao;


import com.example.training.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentDAO {


    public void save(Student student);

    public Student findById(int id);

    public int newLastName(String oldName, String newName);

    public List<Student> getAll();

    public List<Student> findByLastName(String lastName);

    public void deleteById(int id);
}
