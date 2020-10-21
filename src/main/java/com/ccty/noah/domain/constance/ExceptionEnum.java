package com.ccty.noah.domain.constance;

/**
 * @author 缄默
 * @date   2020/08/27
 */
public enum ExceptionEnum {
    //用户信息为空
    USER_NAME_ERROR("001","用户不存在"),
    USER_PASSWORD_ERROR("002","用户名或密码输入错误"),
    USER_REPEAT_ERROR("003","用户名重复"),
    SEND_SMS_ERROR("004","短信发送失败"),
    CODE_INPUT_ERROR("005","验证码错误"),
    CODE_EXPIRED_ERROR("006","验证码过期"),
    PHONE_ERROR("007","手机号不存在"),
    ROLE_NAME_ERROR("008","角色不存在"),
    FILE_UPLOAD_ERROR("009","文件上传失败");

    private String code;
    private String name;

    ExceptionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
