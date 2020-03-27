/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.model.Order;
import java.util.List;

/**
 *
 * @author ROSHAB
 */
public interface OrderService {
    
    public void saveOrder(Order order);
    
    public List<Order> selectAll();
    
    public void updateOrder(Order order);
    
    public void deleteOrder(Order order);
}
