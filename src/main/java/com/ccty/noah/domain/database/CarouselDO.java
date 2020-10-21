package com.ccty.noah.domain.database;

import lombok.Data;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@Data
public class CarouselDO extends BaseDO {

    /** 链接地址*/
    private String address;

    /** 类型*/
    private Integer type;
}
