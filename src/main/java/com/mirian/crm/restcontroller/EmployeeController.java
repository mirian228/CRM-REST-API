package com.mirian.crm.restcontroller;

import com.mirian.crm.model.Employee;
import com.mirian.crm.repository.EmployeeDAO;
import com.mirian.crm.repository.EmployeeDAOImpl;
import com.mirian.crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PostMapping("employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }


}
