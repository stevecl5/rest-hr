package com.stevencl.resthr.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
@SequenceGenerator(name = "sequence_gen", sequenceName = "manager_seq", initialValue = 4)
public class Manager extends Employee {

    protected Manager() {
        super();
    }

    public Manager(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

}
