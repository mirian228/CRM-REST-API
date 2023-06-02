package com.mirian.crm.restcontroller;

import com.mirian.crm.exceptions.EmployeeIdNotFoundException;
import com.mirian.crm.model.Employee;
import com.mirian.crm.model.EmployeeErrorResponse;
import com.mirian.crm.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        if (employeeId >= employeeService.getAllEmployees().size() || employeeId < 0) {
            throw new EmployeeIdNotFoundException("Employee id not found - " + employeeId);
        }
        return employeeService.getEmployeeById(employeeId);
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.createEmployee(employee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

}
