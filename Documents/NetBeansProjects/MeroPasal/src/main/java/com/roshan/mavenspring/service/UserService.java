/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.model.UserDetail;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface UserService {
    public void addUser(UserDetail userDetail);
    
    public List<UserDetail> getALLUsers();
    
    public UserDetail getUserByid(int id);
    
    public UserDetail getUserByUsername(String username);
    
    public void updateUser(UserDetail userDetail);
    
    public void deleteuser(UserDetail userDetail);
    
}
