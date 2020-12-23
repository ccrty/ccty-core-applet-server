package com.ccty.noah.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("数据字典对象")
@Data
public class DataDictDTO extends BaseDTO {

    @NotNull(message = "数据字典类型不能为空")
    @ApiModelProperty("数据字典类型")
    private Integer dataDictType;

    @NotNull(message = "数据字典描述不能为空")
    @ApiModelProperty("数据字典描述")
    private String dataDictAccount;

    @NotNull(message = "数据字典_key不能为空")
    @ApiModelProperty("数据字典_key")
    private Integer dataDictKey;

    @ApiModelProperty("数据字段_value")
    private String dataDictValue;

    @ApiModelProperty("数据字段_删除标识")
    public String isDeleted;
}
