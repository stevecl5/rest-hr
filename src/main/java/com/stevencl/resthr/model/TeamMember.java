package com.stevencl.resthr.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents a team member (employee).
 */
@Entity
@Table(name = "team_members")
@SequenceGenerator(name = "sequence_gen", sequenceName = "team_member_seq", initialValue = 10)
public class TeamMember extends Employee {

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    /**
     * No args constructor.
     */
    protected TeamMember() {
        super();
    }

    /**
     * Normal constructor.
     *
     * @param firstName  first name
     * @param lastName   last name
     * @param email      email address
     * @param manager    manager (or null)
     */
    public TeamMember(String firstName, String lastName, String email, Manager manager) {
        super(firstName, lastName, email);
        this.manager = manager;
    }

    /**
     * Gets the manager for this team member.
     *
     * @return  the manager for this team member
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Returns a string representation of this team member.
     *
     * @return  a string representation of this team member
     */
    @Override
    public String toString() {
        return String.format(
                "TeamMember[id=%d, firstName='%s', lastName='%s', email='%s', managerId=%d]",
                super.getId(), super.getFirstName(), super.getLastName(), super.getEmail(),
                manager.getId());
    }

    /**
     * Sets the manager for this team member.
     *
     * @param manager  the manager for this team member
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
