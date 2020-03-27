/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.controller;

import com.roshan.mavenspring.model.Category;
import com.roshan.mavenspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ROSHAB
 */

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/add")
    public ModelAndView openCategory(){
          ModelAndView  mv = new ModelAndView("category_add");
          mv.addObject("catlist", categoryService.getAllCategories());
    return mv;
    }
    
    @PostMapping("/add")
    public ModelAndView saveCategory (@RequestParam("cat_name") String cat_name,
                                      @RequestParam("cat_desc") String cat_desc,
                                      @RequestParam("cat_parent") int cat_parent,
                                      ModelAndView mv){
        Category cat = new Category();
        cat.setName(cat_name);
        cat.setDescription(cat_desc);
        cat.setParentCat(cat_parent);
        
        //to save category object
        categoryService.saveCategory(cat);
        
        //after save operation is complete re open fresh category_add page
        mv.setViewName("redirect:/admin/category/add");
        return mv;
    }
    
    
    @GetMapping("/show")
    public ModelAndView displayCategoryXYZ(ModelAndView mv){
        mv.setViewName("category_show");
        mv.addObject("catlist",categoryService.getAllCategories());
        return mv;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCategory(@PathVariable("id") int cid, ModelAndView mv){
        mv.setViewName("category_edit");
        mv.addObject("category",categoryService.getCategoryById(cid));
        return mv;
    }
    
    @PostMapping("/edit")
    public ModelAndView updateCategory(@ModelAttribute("Category") Category category, ModelAndView mv){
        categoryService.updateCategory(category);
        mv.setViewName("redirect:/admin/category/show");
        return mv;
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable("id") int id, ModelAndView mv){
        mv.setViewName("redirect:/admin/category/show");
//        Category cat = new Category();
//        cat.setId(id); //delete operation
        
        Category cat = categoryService.getCategoryById(id);
//        delete operation using presistent object
        categoryService.deleteCategory(cat);
        return mv;
    }
    
}
