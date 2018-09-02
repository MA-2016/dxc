package com.mobileai.dxc.controller;

import com.mobileai.dxc.service.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

    @Autowired
    ProvisionService provisionService;

    @PostMapping("/fileUpload.do")
    public void fileUpload(@RequestParam("file") MultipartFile file){
        provisionService.addServicePicture(17,file);
        }


    }
