/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.controller;


import com.roshan.mavenspring.model.Product;
import com.roshan.mavenspring.model.UserDetail;
import com.roshan.mavenspring.service.CategoryService;
import com.roshan.mavenspring.service.ProductService;
import com.roshan.mavenspring.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ROSHAB
 */
@Controller
public class MiscellaneousController {
    
    @Autowired
    
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
   
    
    @Autowired
    UserService userService;
   
    @GetMapping("/shop")
    public ModelAndView viewShop(ModelAndView mv){
//        String username = p.getName();
//        mv.addObject("msg",username);
        mv.setViewName("shop");
       mv.addObject("productlist1", productService.getAllProducts());
        return mv;
    }
   
    
    @GetMapping("/product_detail/{id}")
    public ModelAndView viewProductDetail(ModelAndView mv, @PathVariable("id") int id){
      mv.setViewName("product_detail");
      mv.addObject("prod", productService.getProductById(id));
        return mv;
    }
     
     
    
    @PostMapping("/productdetail")
    public ModelAndView saveOrder(ModelAndView mv,
                                    @RequestParam("quantity") int quantity){
        
//        Product product = productService.getProductById(prodId);
//        UserDetail userDetail = userService.getUserByid(prodId);
 //       Order order = new Order();
        
 //       order.setQuantity(quantity);
//        order.setProduct(product);
//        order.setUserDetail(userDetail);
//        
 //       orderService.saveOrder(order);
        mv.setViewName("redirect:/shop");
    return mv;
            }

    @PostMapping("/shoppingcart")
    public ModelAndView viewCart(ModelAndView mv,Principal p){
       String username = p.getName();
       mv.addObject("msg",username);
      //   System.out.println(username);
        mv.setViewName("shoppingcart");
        
       // mv.addObject("productlist1", productService.getAllProducts());
        return mv;
    }
            
}
