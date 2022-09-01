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
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Size(min = 2, message = "The lastname has to be more than 2 characters")
    @NotEmpty(message = "you have to fill the blank")
    @Column(name = "last_name",nullable = false)
    private String last_name;
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
    public Employee(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Employee() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
