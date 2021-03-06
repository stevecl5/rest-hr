package com.stevencl.resthr.controller;

import com.stevencl.resthr.model.Manager;
import com.stevencl.resthr.repository.ManagerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Provides a REST controller for CRUD operations on managers.
 */
@RestController
@RequestMapping("api/managers")
public class ManagerController {

    private final ManagerRepository managerRepository;

    /**
     * Sole constructor.
     *
     * @param managerRepository  the manager repository dependency
     */
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    /**
     * Returns a list of all managers.
     *
     * @return  a list of all managers
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Manager> listManagers() {
        return managerRepository.findAll();
    }

    /**
     * Gets a single manager.
     *
     * @param id  the ID of the manager to be retrieved
     * @return    a single manager with the given ID
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Manager getManager(@PathVariable long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Manager not found"));
    }

    /**
     * Creates a new manager.
     *
     * @param newManager  new manager to be added to the repository
     * @return            the successfully added manager
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> createManager(@RequestBody Manager newManager) {
        return new ResponseEntity<>(managerRepository.save(newManager),
                HttpStatus.CREATED);
    }

    /**
     * Replaces an existing manager.
     *
     * @param newManager  new manager to replace an existing manager
     * @param id          ID of the manager to be replaced
     * @return  the successfully updated (i.e. replaced) manager
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manager replaceManager(@RequestBody Manager newManager, @PathVariable long id) {
        return managerRepository.findById(id)
                .map(manager -> {
                    manager.setFirstName(newManager.getFirstName());
                    manager.setLastName(newManager.getLastName());
                    manager.setEmail(newManager.getEmail());
                    return managerRepository.save(manager);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Manager not found"));
    }

    /**
     * Deletes a manager.
     *
     * @param id  ID of the manager to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable long id) {
        managerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Manager not found"));

        managerRepository.deleteById(id);
    }

}
