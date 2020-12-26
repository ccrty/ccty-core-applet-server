package com.ccty.noah.domain.dto.applets;

import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@ApiModel("跑腿对象")
@Data
public class RunnerDTO extends BaseDTO {

    @NotNull(message = "跑腿类型不能为空")
    @ApiModelProperty(value = "跑腿类型",example = "0-帮我买 1-帮我送")
    private Integer type;

    @NotNull(message = "发布人id不能为空")
    @ApiModelProperty(value = "发布人id")
    private Long publishId;

    @ApiModelProperty(value = "重量")
    private BigDecimal weight;

    @DecimalMin("0")
    @ApiModelProperty(value = "费用")
    private BigDecimal cost;

    @ApiModelProperty(value = "备注")
    private String remake;

    @ApiModelProperty(value = "垫付费用")
    private BigDecimal advance;

    @ApiModelProperty(value = "骑手id")
    private Long riderId;

    @ApiModelProperty(value = "送达地址id")
    private Long sendAddressId;

    @ApiModelProperty(value = "服务地址id（取件地址/购买地址）")
    private Long serviceAddressId;

    @NotNull(message = "订单状态不能为空")
    @ApiModelProperty(value = "订单状态",example = "0-已发布 1-接收派送中 2-订单结束 3-订单取消 4-订单异常")
    private Integer status;

    @ApiModelProperty("业务id")
    private String businessId;

}
