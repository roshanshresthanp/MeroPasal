/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.controller;


import com.roshan.mavenspring.model.UserDetail;
import com.roshan.mavenspring.service.ProductService;
import com.roshan.mavenspring.service.UploadService;
import com.roshan.mavenspring.service.UserService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ROSHAB
 */
@Controller
public class HomeController {
    @Autowired
    UploadService uploadService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
   
    @Autowired
    ProductService productService;
    
    @RequestMapping(value="/about", method=RequestMethod.GET)
    public String openAbout(Model model){
       model.addAttribute("SiteName","MavenSpringApp"); 
       return "about";
       
    }
      @RequestMapping(value="/services", method=RequestMethod.GET)
    public String openServices(Model model){
       model.addAttribute("SiteName","MavenSpringApp"); 
       return "services";
       
    }
      @RequestMapping(value="/contact", method=RequestMethod.GET)
    public String openContact(Model model){
       model.addAttribute("SiteName","MavenSpringApp"); 
      return "contact"; 
    }
     @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String opensignup(Model model){ 
      return "signup";
    }
    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signUp(@RequestParam("image") MultipartFile Image,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email,
                        @RequestParam("dob") String dob,
                        @RequestParam("phone") long phoneno,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("confirmPassword") String cpassword,
                        @RequestParam("authority") String authority){
       
        UserDetail ud = new UserDetail();
        ud.setAuthority(authority);
        ud.setDob(LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE));
        ud.setEmail(email);     
        ud.setFirstName(firstName);
        ud.setLastName(lastName);
        ud.setPhone(phoneno);
        ud.setUsername(username);
        if(password.equals(cpassword)){
            ud.setPassword(passwordEncoder.encode(password));
            //add password to userDetail object and continue
            //otherwise redirect to signup page saying password didnot match
        }else{
            return "redirect:/signup?password_mismatch=true";
        }
                
                                   
        if(uploadService.uploadImage(Image, "User_Image")){
            ud.setImage(Image.getOriginalFilename());
            
            userService.addUser(ud);
            return "redirect:/login";
        }
       return "signup";
    }
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String openLogin()
    {
            return "login";
    }
    
    
    
    @GetMapping({"/","/index","/home"})
    public ModelAndView displayProducts(ModelAndView mv){
        mv.setViewName("index");
        mv.addObject("productlist1", productService.getAllProducts());
        return mv;
    }
     
}

