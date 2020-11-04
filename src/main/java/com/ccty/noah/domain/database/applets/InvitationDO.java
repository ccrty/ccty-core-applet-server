package com.ccty.noah.domain.database.applets;

import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;

@Data
public class InvitationDO extends BaseDO {

    /**标题**/
    private String headLine;

    /**内容**/
    private String content;

    /**帖子类目**/
    private String data_dict_key;

    /**状态**/
    private Integer status;
}
