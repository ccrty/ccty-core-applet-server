package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户对象
 * @author 缄默
 * @date   2020/08/26
 */
@ApiModel("用户对象")
@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty(value = "性别",example = "1-男 2-女")
    private Integer sex;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("语言")
    private String language;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("地区")
    private String area;

}
