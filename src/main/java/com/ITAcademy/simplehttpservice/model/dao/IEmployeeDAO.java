package com.ITAcademy.simplehttpservice.model.dao;


import com.ITAcademy.simplehttpservice.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IEmployeeDAO{

    // Create an employee
    public void create(Employee employee);

    // List all employees
    public List<Employee> findAll();

    // Find employee by id
    public Employee findOne(Long id);

    // Find employee by job
    public List<Employee> findByJob(String job);

    // Delete an employee by id
    public void delete(Long id);

}
