package com.ccty.noah.domain.database.applets;

import lombok.Data;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@Data
public class RunnerConditionDO {

    /** 订单状态 0-已发布 1-接收派送中 2-订单结束 3-订单取消 4-订单异常 */
    private Integer status;
}
