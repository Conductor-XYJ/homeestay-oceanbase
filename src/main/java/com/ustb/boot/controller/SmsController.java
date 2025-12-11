package com.ustb.boot.controller;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.util.SmsUtils;
import com.ustb.boot.util.ValidateCodeUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/send-message-login/{phone}")
    public Result sendMessageLogin(@PathVariable("phone") String phone) {
        //发送短信验证码
        String code = String.valueOf(ValidateCodeUtils.generateValidateCode(6));
        String param = "{\"code\":\"" + code + "\"}";
        SmsUtils.sendMessage(phone, param);
        //把验证码存储在redis中
        redisTemplate.opsForValue().set("login_"+phone, code,3, TimeUnit.MINUTES);
        return new Result(true,"验证码发送成功",null);
    }

    @GetMapping("/send-message-reset-password/{phone}")
    public Result sendMessageResetPassword(@PathVariable("phone") String phone) {
        //发送短信验证码
        String code = String.valueOf(ValidateCodeUtils.generateValidateCode(6));
        String param = "{\"code\":\"" + code + "\"}";
        SmsUtils.sendMessage(phone, param);
        //把验证码存储在redis中
        redisTemplate.opsForValue().set("reset_"+phone, code,3, TimeUnit.MINUTES);
        return new Result(true,"验证码发送成功",null);
    }
}
