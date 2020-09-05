package com.ccty.noah.domain.database;

import lombok.Data;

/**
 * @author 缄默
 * @date   2020/09/05
 */
@Data
public class UserListConditionDO {
    /**用户名*/
    private String name;

    /**类型**/
    private Integer type;
}
