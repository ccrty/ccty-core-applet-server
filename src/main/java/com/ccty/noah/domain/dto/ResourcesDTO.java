package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 资源对象
 * @author ryan
 * @date   2020/09/15
 */
@ApiModel("资源对象")
@Data
@NoArgsConstructor
public class ResourcesDTO extends BaseDTO{
    @NotEmpty(message = "资源名称不能为空")
    @ApiModelProperty(value = "资源名称")
    private String name;

    @NotEmpty(message = "资源路径不能为空")
    @ApiModelProperty(value = "资源路径")
    private String address;

    @ApiModelProperty(value = "资源类型")
    private Integer type;

    @ApiModelProperty(value = "资源描述")
    private String description;

    @ApiModelProperty(value = "父id")
    private Long parentId;
}
