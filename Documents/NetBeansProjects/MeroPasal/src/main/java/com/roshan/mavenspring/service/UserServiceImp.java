/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.dao.UserDao;
import com.roshan.mavenspring.model.UserDetail;
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
public class UserServiceImp implements UserService{

    @Autowired
    UserDao userDao;
    
    
    @Override
    public void addUser(UserDetail userDetail) {
        userDao.insert(userDetail);
    }

    @Override
    public List<UserDetail> getALLUsers() {
       return userDao.selectALL();
    }

    @Override
    public UserDetail getUserByid(int id) {
       return userDao.selectById(id);
    }

    @Override
    public UserDetail getUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(UserDetail userDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteuser(UserDetail userDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
