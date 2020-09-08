package com.ccty.noah.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 缄默
 * @date   2020/09/08
 */
@Data
@AllArgsConstructor
public class CodeDTO {

    /** 电话号码 */
    private String phone;

    /** 验证码 */
    private String code;

    /** 创建时间 */
    private Date time;

}
