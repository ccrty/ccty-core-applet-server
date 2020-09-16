package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色对象
 * @author ryan
 * @date   2020/09/15
 */
@ApiModel("角色对象")
@Data
public class RoleDTO extends BaseDTO{
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色等级")
    private Integer order_index;

    @ApiModelProperty(value = "角色描述")
    private String desc;

    @ApiModelProperty(value = "value = 角色类型")
    private String type;


}
