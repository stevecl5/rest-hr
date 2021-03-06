package com.stevencl.resthr.repository;

import com.stevencl.resthr.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides methods for interacting with the manager repository.
 */
@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {}
