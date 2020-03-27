/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.controller;

import com.roshan.mavenspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ROSHAB
 */
@Controller
public class AdminController {
    
    @GetMapping("/admin/home")
    public String adminDashboard(){
        return "adminpanel";
       
    }
    
    @Autowired
    UserService userService;
    
    @GetMapping("/admin/userdetail")
    public ModelAndView displayUserDetails(ModelAndView mv){
        mv.setViewName("user_show");
        mv.addObject("userList",userService.getALLUsers());
        return mv;
       
        
    }
        
}
