package com.ITAcademy.simplehttpservice.controller;

import com.ITAcademy.simplehttpservice.model.dao.IEmployeeDAO;
import com.ITAcademy.simplehttpservice.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class EmployeerController {

    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    // Create an employee
    @PostMapping("/create")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        iEmployeeDAO.create(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // List all employees
    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getAllEmployees() throws Exception {
        return iEmployeeDAO.findAll();
    }

    // List one employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable(name = "id") Long id) throws Exception {

        Employee Employee = iEmployeeDAO.findOne(id);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    // Delete employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable(value = "id") Long id) {
        Employee Employee = iEmployeeDAO.findOne(id);
        iEmployeeDAO.delete(id);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }
}
