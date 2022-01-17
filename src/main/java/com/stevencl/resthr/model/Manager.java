package com.stevencl.resthr.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents a manager (employee).
 */
@Entity
@Table(name = "managers")
@SequenceGenerator(name = "sequence_gen", sequenceName = "manager_seq", initialValue = 4)
public class Manager extends Employee {

    /**
     * No args constructor.
     */
    protected Manager() {
        super();
    }

    /**
     * Normal constructor.
     *
     * @param firstName  first name
     * @param lastName   last name
     * @param email      email address
     */
    public Manager(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

}
