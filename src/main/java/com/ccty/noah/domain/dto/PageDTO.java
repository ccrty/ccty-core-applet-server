package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页对象
 * @author 缄默
 * @date   2020/09/05
 */
@Data
@ApiModel
public class PageDTO {

    @ApiModelProperty("每页大小")
    public Integer pageSize = 10;

    @ApiModelProperty("当前页开始记录数")
    public Integer pageNum = 1;
}
