package com.ccty.src.service;

import com.ccty.src.domain.dto.DemoDTO;

/**
 * @author 缄默
 * @date 2019/12/14
 */
public interface DemoService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    DemoDTO queryUserInfoById(int id);
}
