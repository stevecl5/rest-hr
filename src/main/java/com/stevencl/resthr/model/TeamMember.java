package com.stevencl.resthr.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team_members")
public class TeamMember extends Employee {

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    protected TeamMember() {
        super();
    }

    public TeamMember(String firstName, String lastName, String email, Manager manager) {
        super(firstName, lastName, email);
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return String.format(
                "TeamMember[id=%d, firstName='%s', lastName='%s', email='%s', managerId=%d]",
                super.getId(), super.getFirstName(), super.getLastName(), super.getEmail(),
                manager.getId());
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
