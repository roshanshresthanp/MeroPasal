/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.service;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ROSHAB
 */
@Service
public class UploadServiceImp implements UploadService {

    @Override
    public boolean uploadImage(MultipartFile image, String imageDir) {
        File uploadDir = new File(UPLOAD_DIR + imageDir);
    if(!uploadDir.exists()){
        uploadDir.mkdirs();
    }
    boolean ok =false;
    String filename = image.getOriginalFilename();
    File imageFile = new File(uploadDir +File.separator + filename);
    
    try{
        image.transferTo(imageFile);
        ok=true;
    }
    catch(IOException | IllegalStateException ex){
        System.out.println(ex);
    }
         return ok;
                 }
    
}
