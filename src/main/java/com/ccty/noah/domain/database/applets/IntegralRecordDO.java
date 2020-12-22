package com.ccty.noah.domain.database.applets;


import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@Data
public class IntegralRecordDO extends BaseDO {

    /**积分id*/
    private Long integralId;

    /**用户id*/
    private Long userId;

    /**操作积分*/
    private BigDecimal operateIntegral;

    /**操作类型*/
    private Integer operateType;

    /**积分类型*/
    private Integer integralType;

    /**积分状态*/
    private Integer integralStatus;

    public IntegralRecordDO(Long integralId, Long userId, BigDecimal operateIntegral, Integer operateType, Integer integralType, Integer integralStatus) {
        this.integralId = integralId;
        this.userId = userId;
        this.operateIntegral = operateIntegral;
        this.operateType = operateType;
        this.integralType = integralType;
        this.integralStatus = integralStatus;
    }
}
