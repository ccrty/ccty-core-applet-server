package com.ccty.noah.domain.database;

import lombok.Data;

@Data
public class DataDictDO extends BaseDO {

    /**数据字典类型**/
    private String dataDictType;

    /**数据字典描述**/
    private String dataDictAccount;

    /**数据字典_key**/
    private Integer dataDictKey;

    /**数据字段_value**/
    private String dataDictValue;

    /**数据字段_value**/
    private String isDeleted;
}
