/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import com.roshan.mavenspring.dao.OrderDao;
import com.roshan.mavenspring.model.Order;
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
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Override
    public void saveOrder(Order order) {
        orderDao.insert(order);
    }

    @Override
    public List<Order> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
