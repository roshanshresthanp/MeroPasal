/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.model.Product;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface ProductService {
    
    public void saveProduct(Product product);
    
    public List<Product> getAllProducts();
    
    public Product getProductById(int id);
    
    public List<Product> getProductsByCategory(Category cat);
    
    public List<Product> getProductByName(String name);
    
    public void updateProduct(Product product);
    
    public void deleteProduct(Product product);
}
