/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.dao.CategoryDao;
import com.roshan.mavenspring.model.Category;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROSHAB
 */
@Service
@Transactional
public class CategoryServiceImp implements CategoryService{
    
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void saveCategory(Category cat) {
     categoryDao.insert(cat);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.selectAll();
    }

    @Override
    public Category getCategoryByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.selectById(id);
    }

    @Override
    public void updateCategory(Category cat) {
    categoryDao.update(cat); 
    }

    @Override
    public void deleteCategory(Category cat) {
    categoryDao.delete(cat);
    }
    
}
