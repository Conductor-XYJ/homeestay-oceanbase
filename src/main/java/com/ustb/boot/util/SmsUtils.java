package com.ustb.boot.util;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

public class SmsUtils {
    private static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
    private static final String ACCESS_KEY_SECRET = "YOUR_ACCESS_KEY_SECRET";
    private static final String TEMPLATE_CODE_VALIDATE_CODE = "SMS_305002601";

    //发送短信的方法
    public static void sendMessage(String phone,String param){
        Config config = new Config()
                .setAccessKeyId(ACCESS_KEY)
                .setAccessKeySecret(ACCESS_KEY_SECRET);
        //设置访问您的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = null;
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName("北京学佳澳")
                .setTemplateCode(TEMPLATE_CODE_VALIDATE_CODE)
                .setTemplateParam(param);
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            client.sendSmsWithOptions(sendSmsRequest, runtime);
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }
}
