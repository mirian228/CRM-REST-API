package com.mirian.crm.repository;

import com.mirian.crm.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(int employeeId);



}
