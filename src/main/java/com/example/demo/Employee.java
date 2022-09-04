package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "Employee")
@Table(name = "employee",uniqueConstraints = {@UniqueConstraint(name = "email_unique",columnNames = "email")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;


    @Size(min = 2, message = "The firstname has to be more than 2 characters")
    @NotEmpty(message = "you have to fill the blank")
    @Column(nullable = false)
    private String firstname;
    @Size(min = 2, message = "The lastname has to be more than 2 characters")
    @NotEmpty(message = "you have to fill the blank")
    @Column(nullable = false)
    private String lastname;
    @NotEmpty(message = "you have to fill the blank")
    @Email(message = "insert a valid email")
    @Column(name = "email",nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Employee(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Employee() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String first_name) {
        this.firstname = first_name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String last_name) {
        this.lastname = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstname + '\'' +
                ", last_name='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
