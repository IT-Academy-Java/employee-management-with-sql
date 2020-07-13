package com.ITAcademy.simplehttpservice.controller;

import com.ITAcademy.simplehttpservice.model.dao.IEmployeeDAO;
import com.ITAcademy.simplehttpservice.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EmployeerController {

    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
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
}
