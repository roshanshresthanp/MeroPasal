/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;


import com.roshan.mavenspring.model.Category;
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
public class CategoryDaoImp implements CategoryDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
   
    @Override
    public void insert(Category cat) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(cat);
        tx.commit();
        session.close();
    }

    @Override
    public List<Category> selectAll() {
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query<Category> q = session.createQuery("from Category c", Category.class);
       List<Category> catList = q.getResultList();
       session.close();
       return catList;
    }

    @Override
    public Category selectByName(String name) {
      Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query<Category> q = session.createQuery("from Category c where name=:name", Category.class);
       q.setParameter("name",name);
       Category cat = q.uniqueResult();
       session.close();
       return cat;
    }

    @Override
    public Category selectById(int id) {
      Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query<Category> q = session.createQuery("from Category c where id=:cid", Category.class);
       q.setParameter("cid",id);
       Category cat = q.uniqueResult();
       session.close();
       return cat;
    }

    @Override
    public void update(Category cat) {
       Session session = sessionFactory.openSession();
       Transaction tx = session.beginTransaction();
       session.update(cat);
       tx.commit();
       session.close();
    }

    @Override
    public void delete(Category cat) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(cat);
        session.getTransaction().commit();
        session.close();
    }
    
    
}
