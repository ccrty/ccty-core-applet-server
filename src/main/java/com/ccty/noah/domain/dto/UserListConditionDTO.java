package com.ccty.noah.domain.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户列表搜索条件对象
 * @author 缄默
 * @date   2020/09/05
 */
@Data
@ApiModel("用户列表搜索条件对象")
public class UserListConditionDTO extends PageDTO {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty(value = "类型",notes = "0-小程序会员 1-后台管理员")
    private Integer type;
}
