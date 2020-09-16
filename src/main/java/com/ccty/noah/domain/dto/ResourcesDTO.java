package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 资源对象
 * @author ryan
 * @date   2020/09/15
 */
@ApiModel("资源对象")
@Data
public class ResourcesDTO extends BaseDTO{
    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源路径")
    private String address;

    @ApiModelProperty(value = "资源类型")
    private String type;


}
