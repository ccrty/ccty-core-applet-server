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

    private  String name;

    private Integer orderIndex;

    private String desc;

    private Integer type;


}
