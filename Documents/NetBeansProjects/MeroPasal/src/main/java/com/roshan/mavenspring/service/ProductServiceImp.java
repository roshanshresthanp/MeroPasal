/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.dao.ProductDao;
import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.model.Product;
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
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductDao productDao;
    
    
    @Override
    public void saveProduct(Product product) {
        productDao.insert(product);
    }

    @Override
    public List<Product> getAllProducts() {
       return productDao.selectAll();
    }

    @Override
    public Product getProductById(int id) {
       return productDao.selectById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Category cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProductByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}