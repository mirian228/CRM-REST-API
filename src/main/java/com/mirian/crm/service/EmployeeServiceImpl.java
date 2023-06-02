package com.mirian.crm.service;

import com.mirian.crm.model.Employee;
import com.mirian.crm.dao.EmployeeDAO;
import com.mirian.crm.model.Manager;
import com.mirian.crm.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final ManagerRepository managerRepository;

    EmployeeServiceImpl(EmployeeDAO employeeDAO, ManagerRepository managerRepository) {
        this.employeeDAO = employeeDAO;
        this.managerRepository = managerRepository;
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
        Integer managerId = employee.getManagerId().getId();
        Manager manager = managerRepository.findById(managerId).get();
        if(manager != null) {
            employee.setManagerId(manager);
            return employeeDAO.createEmployee(employee);
        } else {
            throw new RuntimeException("Manager not found");
        }
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
