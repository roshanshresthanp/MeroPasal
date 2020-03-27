/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author ROSHAB
 */
public class WebApplnitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ DatabaseConfig.class, WebAppSecurityConfig.class };
        }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebMVCConfig.class};
            
    }

    @Override
    protected String[] getServletMappings() {
    return new String[]{"/"};    
    }
    
}
