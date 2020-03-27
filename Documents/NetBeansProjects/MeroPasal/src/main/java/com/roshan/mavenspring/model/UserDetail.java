
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ROSHAB
 */
@Entity
@Table(name="User_Detail")
public class UserDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ud_id")
    private int id;
    @Column(name="First_Name")
    private String firstName;
    
    @Column(name="Last_Name")
    private String lastName;
    
    @Column(name="Email", unique=true)
    private String email;
    
    @Column(name="Phone_no")
    private long phone;
    
    @Column(name="User_Image")
    private String image;
    
    @Column(name="Date_Of_Birth")
    private LocalDate dob;
    
    @Column(name="Username", unique=true)
    private String username;
    
    @Column(name="Password")
    private String password;
    @Transient
    private String confirmPassword;
    @Transient
    private String authority;
    @Column(name="Active")
    private String active;
    
    
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetail")
    private UserRole userRole;
    
    @OneToMany(mappedBy="userDetails")
    private List<Order> order;

    public UserDetail() {
    }

    public UserDetail(int id, String firstName, String lastName, String email, long phone, String image, LocalDate dob, String username, String password, String confirmPassword, String authority, String active, UserRole userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.authority = authority;
        this.active = active;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    
    
    
    
}
