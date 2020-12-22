package com.ccty.noah.domain.database.applets;

import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@Data
public class IntegralDO extends BaseDO {

    /**用户id*/
    private Long userId;

    /**总积分*/
    private BigDecimal totalIntegral;

    /**可用积分*/
    private BigDecimal availableIntegral;
}
