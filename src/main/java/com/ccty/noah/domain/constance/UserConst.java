package com.ccty.noah.domain.constance;

/**
 * 用户常量
 * @author 缄默
 * @date   2020/09/08
 */
public interface UserConst {

    /** 后台管理员 */
    Integer MANAGER_TYPE = 2;

    /** 小程序会员 */
    Integer APPLETS_TYPE = 1;

    /** 会员等级 -游客 */
    Integer MEMBER_LEVEL_TOURIST = 0;

    /** 初始密码 */
    String INIT_PASSWORD = "123456";

    /** 根资源 */
    Long ROOT_RESOURCES = 0L;

    /** 小程序首页轮播图 */
    Integer APPLETS_INDEX_CAROUSEL = 1;

}
