/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.UserDetail;
import com.roshan.mavenspring.model.UserRole;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ROSHAB
 */
@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void insert(UserDetail userDetail) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserRole ur = new UserRole();
        if(userDetail.getAuthority().equals("ROLE_ADMIN")){
            ur.setRole("ROLE_ADMIN");
            userDetail.setActive("0");
            //deactivate admin until another admin manually enables him /her
        }else{
            ur.setRole("ROLE_USER");
            userDetail.setActive("1");
        }
        //to establish realation between UserDetail and UserRole we add object of one classs into another and vice versa
        
        userDetail.setUserRole(ur);
        ur.setUserDetail(userDetail);
        
        session.save(userDetail);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserDetail> selectALL() {
    Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query<UserDetail> q = session.createQuery("from UserDetail ud", UserDetail.class);
       List<UserDetail> userDetail = q.getResultList();
       session.close();
       return userDetail;
    }

    @Override
    public UserDetail selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserDetail userDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UserDetail userDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
