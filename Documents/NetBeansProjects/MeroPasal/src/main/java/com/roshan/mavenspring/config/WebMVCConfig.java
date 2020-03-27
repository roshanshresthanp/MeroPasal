/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.config;

;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**   f
 *
 * @author SOURAJ
 */
@EnableWebMvc
@ComponentScan(basePackages= "com.roshan.mavenspring")
@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
  
    @Bean
    public ViewResolver getViewReselver(){
    
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
       vr.setPrefix("/WEB-INF/views/");
       vr.setSuffix(".jsp");
       return vr;
  } 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/static/**")
               .addResourceLocations("/resources/")
               .setCachePeriod(3600);
       
       
       registry.addResourceHandler("/user_image/**")
               .addResourceLocations("file:///c:/users/roshab/desktop/mavenspringccc/User_Image/")
               .setCachePeriod(3600);
       
        registry.addResourceHandler("/product_image/**")
               .addResourceLocations("file:///c:/users/roshab/desktop/mavenspringccc/Product_image/")
               .setCachePeriod(3600);
    }
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver mr= new CommonsMultipartResolver();
        mr.setMaxUploadSize(10000000000L);
        return mr;
    }
   
    
}
                                                                                            