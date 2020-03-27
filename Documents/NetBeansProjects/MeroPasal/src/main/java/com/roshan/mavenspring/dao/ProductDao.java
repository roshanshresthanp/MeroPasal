/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.model.Product;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface ProductDao {
    
    public void insert(Product product);
    
    public List<Product> selectAll();
    
    public Product selectById(int id);
    
    public List<Product> selectByCategory(Category category);
    
    public void update(Product product);
    
    public void delete(Product product);
    
}
