package com.mirian.crm.repository;

import com.mirian.crm.model.Employee;
import jakarta.persistence.Entity;
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
        return entityManager.createQuery("FROM employee", Employee.class).getResultList();
    }

    @Override
    public void createEmployee() {

    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee() {

    }
}
