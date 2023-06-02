package com.mirian.crm.restcontroller;

import com.mirian.crm.model.Manager;
import com.mirian.crm.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ManagerRestController {

    private final ManagerService managerService;

    @Autowired
    ManagerRestController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/managers/{managerId}")
    public Manager getManagerById(@PathVariable int managerId) {
        return managerService.getManagerById(managerId).get();
    }

    @PostMapping("/managers")
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @PutMapping("/managers")
    public Manager updateManager(@RequestBody Manager updatedManager) {
        return managerService.updateManager(updatedManager, updatedManager.getId());
    }

    @DeleteMapping("/managers/{managerId}")
    public void deleteManagerById(@PathVariable int managerId) {
        managerService.deleteManagerById(managerId);
    }


}
