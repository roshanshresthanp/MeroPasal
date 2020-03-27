/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ROSHAB
 */
@Entity //for hibernate
@Table(name="category_table")
public class Category implements Serializable {
    private static final long serialVersionUID = 1281282L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cat_id")
    private int id;
    @Column(name="cat_name")
    private String name;
    @Column(name="cat_desc")
    private String description;
    @Column(name="cat_parent")
    private int parentCat;
    // 0 for main-category otherwise id of other category for subcategory
    
    @OneToMany(mappedBy="category")
    private List<Product> product;
    
    public Category() {
    }

    public Category(int id, String name, String description, int parentCat , List<Product> product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentCat = parentCat;
        
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentCat() {
        return parentCat;
    }

    public void setParentCat(int parentCat) {
        this.parentCat = parentCat;
    }
    
}
