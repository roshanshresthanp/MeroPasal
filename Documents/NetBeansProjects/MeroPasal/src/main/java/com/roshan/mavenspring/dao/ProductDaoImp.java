/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ROSHAB
 */
@Repository
public class ProductDaoImp implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void insert(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }
    @Override
    public List<Product> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product p", Product.class).getResultList();
        session.close();
        return products;
    }

    @Override
    public Product selectById(int id) {
        Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query<Product> q = session.createQuery("from Product p where id=:id", Product.class);
       q.setParameter("id",id);
       Product pro = q.uniqueResult();
       session.close();
       return pro;
         
    }

    @Override
    public List<Product> selectByCategory(Category category) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
    }

    @Override
    public void update(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
