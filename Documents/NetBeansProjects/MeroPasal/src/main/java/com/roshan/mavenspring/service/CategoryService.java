/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.model.Category;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface CategoryService {
    
    public void saveCategory(Category cat);
    
    public List<Category> getAllCategories();
    
    public Category getCategoryByName(String name);
    
    public  Category getCategoryById(int id);
    
    public void updateCategory(Category cat);
    
    public void deleteCategory(Category cat);
    
    
    
}
