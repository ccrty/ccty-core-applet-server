package com.distance.src.service.impl;

import com.distance.src.aop.aspect.target.NoahService;
import com.distance.src.domain.convertor.DemoConvertor;
import com.distance.src.domain.dto.DemoDTO;
import com.distance.src.mapper.DemoMapper;
import com.distance.src.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 缄默
 * @date 2019/12/14
 */
@NoahService
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private DemoConvertor demoConvertor;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public DemoDTO queryUserInfoById(int id) {
        return demoConvertor.demoDOToDemoDTO(demoMapper.queryUserInfoById(id));
    }
}
