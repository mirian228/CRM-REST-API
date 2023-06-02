package com.mirian.crm.service;

import com.mirian.crm.exceptions.ManagerIdNotFoundException;
import com.mirian.crm.model.Manager;
import com.mirian.crm.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<Manager> getManagerById(Integer managerId) {
        return managerRepository.findById(managerId);
    }

    @Override
    @Transactional
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    @Transactional
    public Manager updateManager(Manager updatedManager, Integer managerId) {
        Optional<Manager> managerOptional = managerRepository.findById(managerId);
        if (managerOptional.isPresent()) {
            Manager managerToUpdate = managerOptional.get();

            managerToUpdate.setFirstName(updatedManager.getFirstName());
            managerToUpdate.setLastName(updatedManager.getLastName());
            managerToUpdate.setEmail(updatedManager.getEmail());

            return managerRepository.save(managerToUpdate);
        } else {
            throw new ManagerIdNotFoundException("Manager with ID " + managerId + " doesn't exist");
        }

    }

    @Override
    @Transactional
    public void deleteManagerById(Integer managerId) {
        Optional<Manager> managerToDelete = managerRepository.findById(managerId);
        managerRepository.delete(managerToDelete.get());
    }
}
