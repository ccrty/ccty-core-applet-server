package com.ccty.noah.domain.constance;

/**
 * @author 缄默
 * @date   2020/08/27
 */
public enum ExceptionEnum {
    //用户信息为空
    USER_NULL_ERROR("001","用户信息为空"),
    USER_NAME_NULL_ERROR("002","用户姓名为空"),
    USER_NAME_ERROR("003","用户不存在"),
    USER_PASSWORD_ERROR("004","用户名或密码输入错误"),
    PASSWORD_NULL_ERROR("005","用户密码为空");

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
