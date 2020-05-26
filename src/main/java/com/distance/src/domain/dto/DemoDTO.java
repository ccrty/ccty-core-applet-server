package com.distance.src.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 缄默
 * @date 2019/5/23
 */
@Data
@ApiModel(value = "示例模型")
public class DemoDTO {

    @ApiModelProperty(value = "名字",example = "陈任远")
    private String name;

    @ApiModelProperty(value = "昵称",example = "陈总")
    @NotBlank(message = "昵称不能为空")
    private String nickName;
}
