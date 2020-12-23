package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@ApiModel("跑腿搜索对象")
@Data
public class RunnerConditionDTO extends PageDTO {

    @ApiModelProperty(value = "订单状态",example = "0-已发布 1-接收派送中 2-订单结束 3-订单取消 4-订单异常")
    private Integer status;
}
