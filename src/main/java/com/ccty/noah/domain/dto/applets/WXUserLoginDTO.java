package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Data
@ApiModel("微信用户登陆对象")
public class WXUserLoginDTO extends BaseDTO {

    @NotNull(message = "昵称不能为空")
    @ApiModelProperty("昵称")
    private String nickName;

    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别",example = "1-男 2-女 0-未知")
    private Integer gender;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("用户头像")
    private String avatarUrl;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区域")
    private String province;

    @ApiModelProperty("语言")
    private String language;

}
