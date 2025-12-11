package com.ustb.boot.controller;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.OssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/oss")
public class OssController {
    @Resource
    private OssService ossService;

    @PostMapping("/upload")
        public Result upload(MultipartFile file){
           return ossService.upload(file);
    }

}
