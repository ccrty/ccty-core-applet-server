package com.ccty.noah.service.impl;

import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.convertor.DemoConvertor;
import com.ccty.noah.mapper.DemoMapper;
import com.ccty.noah.domain.dto.DemoDTO;
import com.ccty.noah.service.DemoService;
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
