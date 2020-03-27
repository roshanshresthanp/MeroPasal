/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.Category;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface CategoryDao {
    
    public void insert(Category cat);
    
    public List<Category> selectAll();
    
    public Category selectByName(String name);
    
    public Category selectById(int id);
    
    public void update(Category cat);
    
    public void delete(Category cat);
    
    
}
