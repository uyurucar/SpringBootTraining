package com.ucaru.mvcthymeleaf.controller;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.ucaru.mvcthymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel)
    {
        //create Student object
        Student theStudent = new Student();

        //add to model as attr
        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries",countries);

        theModel.addAttribute("languages",languages);

        theModel.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        //log student
        System.out.println("student: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
