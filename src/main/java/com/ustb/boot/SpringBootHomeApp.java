package com.ustb.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ustb.boot.mapper")
public class SpringBootHomeApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHomeApp.class, args);
    }
}
