package com.ustb.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ustb.boot.mapper.UserMapper;
import com.ustb.boot.pojo.Result;
import com.ustb.boot.pojo.User;
import com.ustb.boot.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Result isPhoneAvailable(String phone) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_phone", phone);
        User user = userMapper.selectOne(wrapper);
        if(user==null){
            return new Result(true,"手机号可用",null);
        }else{
            return new Result(false,"手机号已被注册",null);
        }
    }

    @Override
    public Result isNameAvailable(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", name);
        User user = userMapper.selectOne(wrapper);
        if(user==null){
            return new Result(true,"用户名可用",null);
        }else{
            return new Result(false,"用户名已被占用",null);
        }
    }

    @Override
    public Result registerUser(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败",null);
        }
        return new Result(true,"注册成功",user.getUserId());
    }

    @Override
    public Result login(String userName, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName)
                .eq("user_password", password);
        User user = userMapper.selectOne(wrapper);
        if(user==null){
            return new Result(false,"登录失败",null);
        }else{
            return new Result(true,"登录成功",user);
        }
    }

    @Override
    public Result codeLogin(String phone, String code) {
        String code4Redis = (String)redisTemplate.opsForValue().get("login_" + phone);
        if(code4Redis==null){
            return new Result(false,"验证码过期请重新发送",null);
        }else{
            if(code4Redis.equals(code)){
                QueryWrapper<User> wrapper = new QueryWrapper<>();
                wrapper.eq("user_phone", phone);
                User user = userMapper.selectOne(wrapper);
                return new Result(true,"登录成功",user);
            }else{
                return new Result(false,"验证码错误",null);
            }
        }
    }

    @Override
    public Result resetPassword(String phone, String code, String newPassword) {
        String code4Redis = (String)redisTemplate.opsForValue().get("reset_"+phone);
        if(code4Redis==null){
            return new Result(false,"验证码过期请重新发送",null);
        }else{
            if(code4Redis.equals(code)){
                userMapper.resetPassword(phone,newPassword);
                return new Result(true,"密码重置成功",null);
            }else{
                return new Result(false,"验证码错误",null);
            }
        }
    }
}
