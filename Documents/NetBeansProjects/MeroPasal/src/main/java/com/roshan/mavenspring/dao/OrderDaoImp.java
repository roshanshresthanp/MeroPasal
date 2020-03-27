/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.Order;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ROSHAB
 */
@Repository
public class OrderDaoImp implements OrderDao{
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    
    @Override
    public void insert(Order order) {
       Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    @Override
    public List<Order> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
