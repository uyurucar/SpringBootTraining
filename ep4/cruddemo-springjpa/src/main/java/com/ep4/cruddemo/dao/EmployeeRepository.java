package com.ep4.cruddemo.dao;

import com.ep4.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //public Employee findById(int id);

}
