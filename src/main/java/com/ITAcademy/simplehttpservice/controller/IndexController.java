package com.ITAcademy.simplehttpservice.controller;

import com.ITAcademy.simplehttpservice.model.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping("/")
    public String init(Model model){

        Employee em = new Employee();

        Employee employee1 = new Employee();
        employee1.setName("Elena");
        employee1.setSurname("Piaggio");
        employee1.setJob("Developer");

        Employee employee2 = new Employee();
        employee2.setName("Sophia");
        employee2.setSurname("Collins");
        employee2.setJob("Analist");

        ArrayList<Employee> employeeList = new ArrayList();
        employeeList.add(employee1);
        employeeList.add(employee2);

        // ArrayList<Employee> employeeArrayList = (ArrayList<Employee>) Arrays.asList(employee, employee2);

        //model.addAttribute("employee", employee);
        model.addAttribute("employeeList", employeeList);

        return "index";
    }
}
