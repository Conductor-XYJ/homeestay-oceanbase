package com.ustb.boot.service;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.pojo.User;

public interface UserService {
    Result isPhoneAvailable(String phone);
    Result isNameAvailable(String name);
    Result registerUser(User user);
    Result login(String userName,String password);
    Result codeLogin(String phone,String code);
    Result resetPassword(String phone,String code,String newPassword);
}
