package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/25
 */
@ApiModel("用户资源对象")
@Data
@NoArgsConstructor
public class UserResourcesDTO{

    @ApiModelProperty("资源对象")
    private ResourcesDTO resources;

    @ApiModelProperty("子资源对象集合")
    private List<ResourcesDTO> resourcesList;
}
