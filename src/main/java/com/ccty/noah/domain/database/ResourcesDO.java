package com.ccty.noah.domain.database;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Data
@NoArgsConstructor
public class ResourcesDO extends BaseDO {

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源地址
     */
    private String address;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 父id
     */
    private Long parentId;


}
