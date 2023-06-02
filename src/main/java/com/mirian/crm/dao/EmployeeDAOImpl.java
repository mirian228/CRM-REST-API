package com.mirian.crm.dao;

import com.mirian.crm.model.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee getEmployeeById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee updatedEmployee = entityManager.merge(employee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        Employee employeeToRemove = entityManager.find(Employee.class, employeeId);

        entityManager.remove(employeeToRemove);
    }
}
