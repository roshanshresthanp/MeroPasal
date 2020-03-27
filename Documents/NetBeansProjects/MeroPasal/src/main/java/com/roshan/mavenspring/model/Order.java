/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ROSHAB
 */
@Entity
@Table(name="order_detail")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 12145646;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cart_id")
    private int id;
    
    private LocalDate entrydate;
    
    private int quantity;
      
    
    @JoinColumn(name="ud_id", nullable=false)
    @ManyToOne
    private UserDetail userDetails;
    
    
    @JoinColumn(name="prod_id", nullable=false)
    @ManyToOne
    private Product product;

    public Order() {
    }

    public Order(int id, LocalDate entrydate, int quantity, UserDetail userDetails, Product product) {
        this.id = id;
        this.entrydate = entrydate;
        this.quantity = quantity;
        this.userDetails = userDetails;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(LocalDate entrydate) {
        this.entrydate = entrydate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserDetail getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetail userDetails) {
        this.userDetails = userDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
         
}