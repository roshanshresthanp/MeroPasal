/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ROSHAB
 */
@Entity
@Table(name="product_table")
public class Product implements Serializable {
    
    private static final long serialVersionUID = 12345646;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="prod_id")
    private int id;
    
    private String name;
    
    private String brand;
    
    private LocalDate entrydate;
    
    private int quantity;
    
    private String description;
    
    private String image;
    
    private double price;
    
    @ManyToOne
    @JoinColumn(name="cat_id", nullable=false)
    private Category category; 
    
    

    public Product() {
    }

    public Product(int id, String name, String brand, LocalDate entrydate, int quantity, String description, String image, double price, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.entrydate = entrydate;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(LocalDate enrydate) {
        this.entrydate = enrydate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
//        category.setProduct(this );
    }
    
    
}
    

