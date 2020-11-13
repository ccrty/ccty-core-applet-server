package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 地址对象
 * @author 缄默
 * @date   2020/11/09
 */
@ApiModel("地址对象")
@Data
public class AddressDTO extends BaseDTO {
    @NotNull(message = "省id不能为空")
    @ApiModelProperty(value = "省id")
    private Integer provinceId;

    @NotEmpty(message = "省名称不能为空")
    @ApiModelProperty(value = "省名称")
    private String provinceName;

    @NotNull(message = "市id不能为空")
    @ApiModelProperty(value = "市id")
    private Integer cityId;

    @NotEmpty(message = "市名称不能为空")
    @ApiModelProperty(value = "市名称")
    private String cityName;

    @NotNull(message = "区id不能为空")
    @ApiModelProperty(value = "区id")
    private Integer areaId;

    @NotEmpty(message = "区名称不能为空")
    @ApiModelProperty(value = "区id")
    private String areaName;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @NotNull(message = "收货人不能为空")
    @ApiModelProperty(value = "收货人")
    private String name;

    @ApiModelProperty(value = "收获号码")
    private String phone;

    @ApiModelProperty(value = "是否是默认地址")
    private Integer isDefault;

}
