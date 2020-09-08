package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 缄默
 * @date   2020/09/08
 */
@Data
@ApiModel("用户注册对象")
public class UserRegisterDTO extends BaseDTO {

    @NotBlank(message = "名字不能为空")
    @ApiModelProperty(value = "名字")
    private String name;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别",example = "1-男 2-女")
    private Integer sex;

    @NotBlank(message = "电话号码不能为空")
    @ApiModelProperty("电话号码")
    private String phone;

    @NotNull(message = "管理员类型不能为空")
    @ApiModelProperty("管理员类型")
    private Integer managerType;

    @ApiModelProperty("用户类型")
    private Integer type;

    @NotBlank(message = "短信验证码不能为空")
    @ApiModelProperty("短信验证码")
    private String code;
}
