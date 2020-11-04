package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@ApiModel("帖子对象")
@Data
@NoArgsConstructor
public class InvitationDTO extends BaseDTO {

    @NotNull(message = "标题不能为空")
    @ApiModelProperty("标题")
    private String headLine;

    @NotNull(message = "内容不能为空")
    @ApiModelProperty("内容")
    private String content;

    @NotNull(message = "帖子类目不能为空")
    @ApiModelProperty("帖子类目")
    private String data_dict_key;

    @ApiModelProperty(value = "状态",example="0")
    private Integer status;
}
