package com.mirian.crm.repository;

import com.mirian.crm.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int employeeId);



}
