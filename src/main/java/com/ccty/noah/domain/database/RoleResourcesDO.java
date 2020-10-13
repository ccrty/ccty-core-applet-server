package com.ccty.noah.domain.database;

import lombok.Data;

/**
 * @author 缄默
 * @date   2020/10/13
 */
@Data
public class RoleResourcesDO extends BaseDO{

    /** 资源id*/
    private Long resourcesId;

    /** 夫资源id*/
    private Long parentId;
}
