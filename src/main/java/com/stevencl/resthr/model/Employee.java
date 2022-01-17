package com.stevencl.resthr.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Mapped superclass for all employee types (manager, team member, etc.)
 */
@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_gen")
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * No args constructor.
     */
    protected Employee() {}

    /**
     * Normal constructor.
     *
     * @param firstName  first name
     * @param lastName   last name
     * @param email      email address
     */
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the ID for this employee.
     *
     * @return  the ID for this employee
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the first name for this employee.
     *
     * @return  the first name for this employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name for this employee.
     *
     * @return  the last name for this employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the email for this employee.
     *
     * @return  the email for this employee
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of this employee.
     *
     * @return  a string representation of this employee
     */
    @Override
    public String toString() {
        return String.format(
                "%s[id=%d, firstName='%s', lastName='%s', email='%s']",
                this.getClass().getSimpleName(), id, firstName, lastName, email);
    }

    /**
     * Sets the ID for this employee.
     *
     * @param id  ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the first name for this employee.
     *
     * @param firstName  first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name for this employee.
     *
     * @param lastName  last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the email address for this employee.
     *
     * @param email  email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
