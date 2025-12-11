package com.ustb.boot.service;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.pojo.User;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    Result upload(MultipartFile file);
}
