package com.ucaru.ep4tekrar.rest;


import com.ucaru.ep4tekrar.entity.Student;
import com.ucaru.ep4tekrar.error.StudentErrorResponse;
import com.ucaru.ep4tekrar.error.StudentNotFoundException;
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
    public void initiateStudents()
    {
        students = new ArrayList<>();

        students.add(new Student("mahmut","orhan"));
        students.add(new Student("sena","sener"));
        students.add(new Student("dj","kantik"));
        students.add(new Student("dj","dikkat"));
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID)
    {
        if(studentID < 0 || studentID >= students.size())
        {
            System.out.println("true");
            throw new StudentNotFoundException("out of bounds");

        }
        return students.get(studentID);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(StudentNotFoundException exc)
    {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exc.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(Exception exc)
    {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exc.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
