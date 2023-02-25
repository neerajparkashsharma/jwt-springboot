package com.example.jwt.Entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;



    @Column(name = "user_name",unique = true)
    private String username;

    @Column(name = "password")
    private String password;


    @Column(name = "email")
    private String email;


    @Column(name="role_name")
    private String roleName;
    
    public Employee(String firstname, String lastname, String username, String password, String email, String roleName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleName = roleName;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getRoleName() {
        return roleName;
    }
        
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



}
