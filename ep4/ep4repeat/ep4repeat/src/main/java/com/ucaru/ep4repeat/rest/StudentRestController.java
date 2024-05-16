package com.ucaru.ep4repeat.rest;


import com.ucaru.ep4repeat.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    //add students
    @PostConstruct
    private void loadData()
    {
        students = new ArrayList<>();

        students.add(new Student("mahmud", "orhan"));
        students.add(new Student("sena", "sener"));
        students.add(new Student("dj", "kantik"));
    }

    //create /students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId >= students.size() || studentId < 0)
            throw new StudentNotFoundException("student not found: " + studentId);

        return students.get(studentId);
    }


}
