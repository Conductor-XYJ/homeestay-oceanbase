package com.ustb.boot.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustb.boot.mapper.UserMapper;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.pojo.User;
import com.ustb.boot.service.OssService;
import com.ustb.boot.service.UserService;
import org.joda.time.DateTime;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public Result upload(MultipartFile file) {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String endpoint2resp = "oss-cn-beijing.aliyuncs.com";
        String accesssKeyId = "YOUR_ACCESS_KEY";
        String accessKeySecret = "YOUR_ACCESS_KEY_SECRET";
        String bucketName = "xyj-homestay";
        OSS ossClient = new OSSClientBuilder().build(endpoint,accesssKeyId,accessKeySecret);
        try {
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            filename = uuid + filename;
            String timeUrl = new DateTime().toString("yyyy/MM/dd");
            filename = timeUrl + "/" + filename;
            ossClient.putObject(bucketName,filename,inputStream);
            ossClient.shutdown();
            //把上传的路径返回给前端
            String url = "https://"+bucketName+"."+endpoint2resp+"/"+filename;
            return new Result(true,"图片上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,"图片上传失败",null);
        }

    }
}
