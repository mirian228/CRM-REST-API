package com.mirian.crm.service;

import com.mirian.crm.model.Employee;
import com.mirian.crm.repository.EmployeeDAO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);
    }
}
