package com.mirian.crm.service;

import com.mirian.crm.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);
}
