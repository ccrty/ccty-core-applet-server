package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 缄默
 * @date   2020/09/13
 */
@ApiModel("资讯实体")
@Data
public class NewsDTO extends BaseDTO {

    @ApiModelProperty(value = "资讯标题")
    private String title;

    @ApiModelProperty(value = "资讯内容")
    private String content;

    @ApiModelProperty(value = "资讯链接地址")
    private String url;

    @ApiModelProperty(value = "资讯类型 1-网站公告")
    private Integer type;
}
