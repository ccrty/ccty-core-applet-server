package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@ApiModel("资源查询条件对象")
@Data
@NoArgsConstructor
public class ResourcesListConditionDTO extends PageDTO {

    @ApiModelProperty(value = "资源名")
    private String name;
}
