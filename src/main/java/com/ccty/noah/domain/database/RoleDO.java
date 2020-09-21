package com.ccty.noah.domain.database;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ryan
 * @date 2020/09/16
 */
@Data
@NoArgsConstructor
public class RoleDO extends BaseDO{

    /**
     * 角色名
     */
    private  String name;

    /**
     * 等级
     */
    private Integer orderIndex;

    /**
     * 描述
     */
    private String description;

    /**
     * 类型
     */
    private Integer type;


}
