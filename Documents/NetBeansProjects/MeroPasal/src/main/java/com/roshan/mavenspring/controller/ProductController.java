/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.controller;

import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.model.Product;
import com.roshan.mavenspring.service.CategoryService;
import com.roshan.mavenspring.service.ProductService;
import com.roshan.mavenspring.service.UploadService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ROSHAB
 */
@Controller
public class ProductController {
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    UploadService uploadService;
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/admin/product/show")
    public ModelAndView showProduct(ModelAndView mv){
        mv.addObject("productlist", productService.getAllProducts());
        mv.addObject("catlist", categoryService.getAllCategories());
        mv.setViewName("product_show");
        return mv;
    }
    @GetMapping("/admin/product/add")
    public ModelAndView addProduct(ModelAndView mv){
        mv.addObject("productlist", productService.getAllProducts());
        mv.addObject("catlist", categoryService.getAllCategories());
        mv.setViewName("product_add");
        return mv;
    }
    
    @PostMapping("admin/product/add")
    public ModelAndView saveProduct (ModelAndView mv, 
                                      @RequestParam("prod_name") String prod_name,
                                      @RequestParam("prod_brand") String prod_brand,
                                      @RequestParam("prod_quantity") int prod_quantity,
                                      @RequestParam("prod_cat") int catId,
                                      @RequestParam("prod_price") double prod_price,
                                      @RequestParam("entry_date") String entry_date,
                                      @RequestParam("prod_desc") String prod_desc,
                                      @RequestParam("image") MultipartFile image){
        
        if(!uploadService.uploadImage(image, "Product_image")){
            mv.setViewName("redirect:/admin/product/add?upload_failed=true");
        }else{
            
        Category category = categoryService.getCategoryById(catId);
        Product product = new Product();
       
        product.setName(prod_name);
        product.setBrand(prod_brand);
        product.setEntrydate(LocalDate.parse(entry_date, DateTimeFormatter.ISO_LOCAL_DATE));
        product.setQuantity(prod_quantity);
        product.setDescription(prod_desc);
        product.setPrice(prod_price);
        product.setImage(image.getOriginalFilename());
        product.setCategory(category); //to save category object
        
        productService.saveProduct(product);
        
      
        mv.setViewName("redirect:/admin/product/add");
        }
        return mv;
    }
    
    
}
