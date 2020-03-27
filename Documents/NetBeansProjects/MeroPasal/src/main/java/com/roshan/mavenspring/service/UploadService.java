/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ROSHAB
 */
public interface UploadService {
    public static final String UPLOAD_DIR="c:/users/roshab/desktop/mavenspringccc/";
    
    public boolean uploadImage(MultipartFile image, String imageDir);
    
}
