package com.ep4.cruddemo.service;

import com.ep4.cruddemo.dao.EmployeeRepository;
import com.ep4.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        //java 8 new approach
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else
        {
            throw new RuntimeException("employee not found: " + id);
        }
        return theEmployee;
    }

    //@Transactional //not required for spring data jpa
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    //@Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }

}
