package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 缄默
 * @date   2020/09/25
 */
@ApiModel("资讯条件对象")
@Data
@NoArgsConstructor
public class NewsConditionDTO extends PageDTO {

    @ApiModelProperty("资讯标题")
    private String title;

    @ApiModelProperty("资讯类型")
    private Integer type;
}
