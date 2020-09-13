package com.ccty.noah.domain.database.applets;

import com.ccty.noah.domain.database.BaseDO;
import com.ccty.noah.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 缄默
 * @date   2020/09/13
 */
@Data
public class NewsDO extends BaseDO {

    /** 资讯标题 */
    private String title;

    /** 资讯内容 */
    private String content;

    /** 资讯链接地址 */
    private String url;

    /** 资讯类型 1-网站公告 */
    private Integer type;
}
