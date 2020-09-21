package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Data
@NoArgsConstructor
@ApiModel("角色列表搜条对象")
public class RoleListConditionDTO extends PageDTO {

    @ApiModelProperty("角色名称")
    private String name;
}
