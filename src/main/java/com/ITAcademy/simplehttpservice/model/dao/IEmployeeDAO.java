package com.ITAcademy.simplehttpservice.model.dao;


import com.ITAcademy.simplehttpservice.model.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IEmployeeDAO {

    // CRUD Methods

    // Create
    public void create(Employee employee);

    // Read
    public List<Employee> findAll();

    // Update
    public Employee findOne(Long id);

    // Delete
    public void delete(Long id);

}
