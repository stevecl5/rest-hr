package com.stevencl.resthr.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    protected Manager() {
        super();
    }

    public Manager(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

}
