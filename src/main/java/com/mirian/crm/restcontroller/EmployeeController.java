package com.mirian.crm.restcontroller;

import com.mirian.crm.model.Employee;
import com.mirian.crm.repository.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeDAOImpl employeeDAOImpl;
    @Autowired
    EmployeeController(EmployeeDAOImpl employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }



    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDAOImpl.getAllEmployees();
    }
}
