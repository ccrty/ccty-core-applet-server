package com.ccty.noah.domain.database.applets;

import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@Data
public class RunnerDO extends BaseDO {

    /**跑腿类型*/
    private Integer type;

    /**发布人id*/
    private Long publishId;

    /**重量*/
    private BigDecimal weight;

    /**费用*/
    private BigDecimal cost;

    /**备注*/
    private String remake;

    /**垫付费用*/
    private BigDecimal advance;

    /**骑手id*/
    private Long riderId;

    /**送达地址id*/
    private Long sendAddressId;

    /**服务地址id（取件地址/购买地址）*/
    private Long serviceAddressId;

    /**订单状态",example = "0-已发布 1-接收派送中 2-订单结束 3-订单取消 4-订单异常*/
    private Integer status;

    /**业务id*/
    private String businessId;

}
