package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 角色对象
 * @author ryan
 * @date   2020/09/15
 */
@ApiModel("角色对象")
@Data
public class RoleDTO extends BaseDTO{
    @NotEmpty(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色等级")
    private Integer orderIndex;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "value = 角色类型")
    private Integer type;

}
