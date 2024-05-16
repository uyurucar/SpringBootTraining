package com.ep4.cruddemo.rest;


import com.ep4.cruddemo.dao.EmployeeDAO;
import com.ep4.cruddemo.entity.Employee;
import com.ep4.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //create and inject employee service
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose /employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    //expose /employees/{id}
    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID)
    {
        Employee theEmployee = employeeService.findById(employeeID);
        if(theEmployee == null)
        {
            throw new RuntimeException("not found: "+ employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //override theEmployee id with 0 to force-save
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID)
    {
        Employee dbEmployee = employeeService.findById(employeeID);
        if(dbEmployee == null)
        {
            throw new RuntimeException("employee not found in db: " + employeeID);
        }
        employeeService.deleteById(employeeID);

        return "deleted employee: " + employeeID;
    }

}
