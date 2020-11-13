package com.ccty.noah.service.applets;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/10/22
 */
public interface AppletsManagerService {

    /**
     * 根据类型获取轮播图
     * @param type
     * @return
     */
    List<String> getCarouselList(Integer type);
}
