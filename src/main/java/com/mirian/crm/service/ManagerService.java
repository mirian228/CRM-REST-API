package com.mirian.crm.service;

import com.mirian.crm.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<Manager> getAllManagers();

    Optional<Manager> getManagerById(Integer managerId);

    Manager createManager(Manager manager);

    Manager updateManager(Manager updatedManager, Integer managerId);

    void deleteManagerById(Integer managerId);
}
