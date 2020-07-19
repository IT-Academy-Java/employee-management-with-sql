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
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable(value = "id") Long id) {
        Employee Employee = iEmployeeDAO.findOne(id);
        iEmployeeDAO.delete(id);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

   /** @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("title", "Employees list");
        model.addAttribute("employees", iEmployeeDAO.findAll());
        return "/list";
    }

    @RequestMapping(value="/create")
    public String create(Map<String, Object> model){
        Employee employee = new Employee();
        model.put("employee", employee);
        model.put("title", "Create Employee");
        return "/form";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String save(Employee employee){
        iEmployeeDAO.create(employee);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Employee employee = null;
        if(id > 0){
            employee = iEmployeeDAO.findOne(id);
        } else{
            return "redirect:/list";
        }

        model.put("employee", employee);
        model.put("title", "Edit employee");
        return "form";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        if(id > 0){
            iEmployeeDAO.delete(id);
        }
        return "redirect:/list";
    }
    */
}
