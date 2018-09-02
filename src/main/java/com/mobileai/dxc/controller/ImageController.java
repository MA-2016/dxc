package com.mobileai.dxc.controller;

import com.mobileai.dxc.util.ImageUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")

public class ImageController{

    @PostMapping("/upload")
    public void uploadImage(MultipartFile file){
        ImageUtil.generateThumbnail(file, "");

    }
}