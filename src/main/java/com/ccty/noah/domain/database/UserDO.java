package com.ccty.noah.domain.database;

import com.ccty.noah.domain.database.BaseDO;
import lombok.Data;

/**
 * 用户对象
 * @author 缄默
 * @date   2020/08/26
 */
@Data
public class UserDO extends BaseDO {

    /** 头像 */
    private String picture;

    /**名字*/
    private String name;

    /**会员等级*/
    private Integer level;

    /**密码*/
    private String password;

    /**昵称*/
    private String nickname;

    /**性别*/
    private Integer sex;

    /**电话号码*/
    private String phone;

    /**语言*/
    private String language;

    /**国家*/
    private String country;

    /**城市*/
    private String city;

    /**地区*/
    private String area;

    /** 用户类型 */
    private Integer type;

    /** 管理员类型 */
    private Integer managerType;

    /** 角色ID */
    private Long roleId;
}
