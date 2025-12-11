package com.ustb.boot.util;

import java.util.Random;

public class ValidateCodeUtils {
    public static Integer generateValidateCode(int length){
        Integer code = null;
        if(length == 4){
            code = new Random().nextInt(9999); // 0-9999
            if(code < 1000){
                code = code+1000;
            }
        }else if(length == 6){
            code = new Random().nextInt(999999); // 0-9999
            if(code < 100000){
                code = code+100000;
            }
        }else{
            throw new RuntimeException("只能生成4位或者6位的验证码");
        }
        return code;
    }
}
