package com.ccty.noah.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.ccty.noah.aop.exception.NoahException;
import com.ccty.noah.domain.constance.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信发送工具类
 * @author 缄默
 * @date   2020/09/07
 */
@Component
@Slf4j
public class AliyunSmsUtils {


    @Value("${aliyun.SMS.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.SMS.accessSecret}")
    private String accessSecret;

    @Value("${aliyun.SMS.singleName}")
    private String singleName;

    @Value("${aliyun.SMS.templateCode}")
    private String templateCode;


    /**
     * 发送短信
     * @param phone
     * @param code
     * @return
     */
    public void sendSMS(String phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", singleName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject result = JSON.parseObject(response.getData());
            String resultCode = result.getString("Code");
            if("OK".equals(resultCode)){
                return;
            }
            throw new NoahException(ExceptionEnum.SEND_SMS_ERROR.getCode(),ExceptionEnum.SEND_SMS_ERROR.getName()+":"+result.getString("Message"));
        } catch (Exception e) {
            log.error("短信发送失败:{}",e);
        }
        throw new NoahException(ExceptionEnum.SEND_SMS_ERROR.getCode(),ExceptionEnum.SEND_SMS_ERROR.getName());
    }

}