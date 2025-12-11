package com.ustb.boot.controller;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.pojo.User;
import com.ustb.boot.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/isPhoneAvailable/{phone}")
    public Result isPhoneAvailable(@PathVariable("phone") String phone) {
        return userService.isPhoneAvailable(phone);
    }

    @GetMapping("/isNameAvailable/{name}")
    public Result isNameAvailable(@PathVariable("name") String name) {
        return userService.isNameAvailable(name);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/login/{userName}/{password}")
    public Result login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        return userService.login(userName, password);
    }

    @GetMapping("/code-login/{phone}/{code}")
    public Result codeLogin(@PathVariable("phone") String phone, @PathVariable("code") String code) {
        return userService.codeLogin(phone, code);
    }

    @PutMapping("/reset-password/{phone}/{code}/{newPassword}")
    public Result resetPassword(@PathVariable("phone") String phone, @PathVariable("code") String code,@PathVariable("newPassword") String newPassword){
        return userService.resetPassword(phone, code, newPassword);
    }
}