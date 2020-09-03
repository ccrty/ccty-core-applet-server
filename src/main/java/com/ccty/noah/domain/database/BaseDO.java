package com.ccty.noah.domain.database;

import lombok.Data;

import java.util.Date;

/**
 * DTO基类
 * @author 缄默
 * @date   2020/08/26
 */
@Data
public class BaseDO {
    /**id*/
    public Long id;
    /**创建人*/
    public String creator;
    /**修改人*/
    public String modifier;
    /**创建时间*/
    public Date createTime;
    /**修改时间*/
    public Date updateTime;
}
