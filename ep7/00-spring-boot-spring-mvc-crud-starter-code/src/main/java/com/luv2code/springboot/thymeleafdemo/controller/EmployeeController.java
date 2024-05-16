package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        List<Employee> employees = employeeService.findAll();
        theModel.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String addEmployee(Model theModel)
    {
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);
        return "employees/employee-form";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model theModel)
    {
        Employee employee = employeeService.findById(id);
        theModel.addAttribute("employee",employee);

        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee)
    {
        employeeService.save(employee);
        //post-redirect-get pattern (prg -- check )
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }


}
