package com.ccty.noah.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * DTO基类
 * @author 缄默
 * @date   2020/08/26
 */
@Data
public class BaseDTO {

    @ApiModelProperty(value = "id",example = "0")
    public Integer id;

    @ApiModelProperty(value = "创建人ID",example = "0")
    public Integer creator;

    @ApiModelProperty(value = "修改人ID",example = "0")
    public Integer modifier;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updateTime;
}
