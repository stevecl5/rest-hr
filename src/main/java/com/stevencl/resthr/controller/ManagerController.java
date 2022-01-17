package com.stevencl.resthr.controller;

import com.stevencl.resthr.model.Manager;
import com.stevencl.resthr.repository.ManagerRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/managers")
public class ManagerController {

    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Manager> listManagers() {
        return managerRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Manager getManager(@PathVariable long id) {
        return managerRepository.findManagerById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manager createManager(@RequestBody Manager newManager) {
        return managerRepository.save(newManager);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manager updateManager(@RequestBody Manager newManager, @PathVariable long id) {
        return managerRepository.findById(id)
                .map(manager -> {
                    manager.setFirstName(newManager.getFirstName());
                    manager.setLastName(newManager.getLastName());
                    manager.setEmail(newManager.getEmail());
                    return managerRepository.save(manager);
                })
                .orElseThrow(RuntimeException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable long id) {
        managerRepository.deleteById(id);
    }

}
