package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@Data
@ApiModel("轮播图对象")
public class CarouselDTO extends BaseDTO {

    @ApiModelProperty(value = "链接地址")
    private String address;

    @ApiModelProperty(value = "类型")
    private Integer type;
}
