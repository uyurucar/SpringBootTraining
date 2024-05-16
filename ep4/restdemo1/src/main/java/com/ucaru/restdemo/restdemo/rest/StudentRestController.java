package com.ucaru.restdemo.restdemo.rest;


import com.ucaru.restdemo.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData()
    {
        students = new ArrayList<>();
        students.add(new Student("ahmet","muhsin"));
        students.add(new Student("ahmet","mohsin"));
        students.add(new Student("ahmad","mugsin"));
        students.add(new Student("ahmedi","muhsin"));
    }
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID)
    {
        //check student id
        if(studentID >= students.size() || studentID < 0)
        {
            throw new StudentNotFoundException("student id not found: "+ studentID);
        }
        return students.get(studentID);

    }


    //define endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }




}
