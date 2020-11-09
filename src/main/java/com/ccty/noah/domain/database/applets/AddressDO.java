package com.ccty.noah.domain.database.applets;

import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;


/**
 * 地址对象
 * @author 缄默
 * @date   2020/11/09
 */
@Data
public class AddressDO extends BaseDO {
    /**省id*/
    private Integer provinceId;

    /**省名称*/
    private String provinceName;

    /**市id*/
    private Integer cityId;

    /**市名称*/
    private String cityName;

    /**区id*/
    private Integer areaId;

    /**区id*/
    private String areaName;

    private String detail;

    /**收货人*/
    private String name;

    /**收获号码*/
    private String phone;

    /**是否是默认地址*/
    private Integer isDefault;

}
