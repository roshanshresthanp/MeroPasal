/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.dao;

import com.roshan.mavenspring.model.Order;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface OrderDao {
    
    
    public void insert(Order order);
    
    public List<Order> selectAll();
    
    public void update(Order order);
    
    public void delete(Order order);
    
}
