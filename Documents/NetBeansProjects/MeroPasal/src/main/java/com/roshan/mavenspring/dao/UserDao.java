/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.UserDetail;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface UserDao {
    
    public void insert(UserDetail userDetail);
    
    public List<UserDetail> selectALL();
    
    public UserDetail selectById(int id);
    
    public void update(UserDetail userDetail);
    
    public void delete(UserDetail userDetail);
    
}
